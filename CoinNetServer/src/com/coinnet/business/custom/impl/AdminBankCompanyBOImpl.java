/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.AdminBankCompanyBO;
import com.coinnet.dto.AdminBankCompanyDTO;
import com.coinnet.entity.AdminBankCompany;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.AdminBankCompanyRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class AdminBankCompanyBOImpl implements AdminBankCompanyBO{

    private AdminBankCompanyRepository adminBankCompanyRepository;

    public AdminBankCompanyBOImpl() {
        
        adminBankCompanyRepository=(AdminBankCompanyRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADMINBANKCOMPANY);
        
    }
    
    
    
    @Override
    public List<AdminBankCompanyDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            
            adminBankCompanyRepository.setSession(session);
            List<AdminBankCompany> list=adminBankCompanyRepository.getAll();
            List<AdminBankCompanyDTO> adminList=new ArrayList<>();
            
            for (AdminBankCompany adminBankCompany : list) {
                adminList.add(new AdminBankCompanyDTO(adminBankCompany.getTid(),adminBankCompany.getBank().getBid(),adminBankCompany.getAdminCompany().getAdminComId(),adminBankCompany.getAmount(),adminBankCompany.getTrasactionType(),adminBankCompany.getDates(),adminBankCompany.getTimes()));
            }
            session.close();
            return adminList;
        }
    }
    
}
