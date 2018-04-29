/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.AdminCompanyBO;
import com.coinnet.dto.AdminCompanyDTO;
import com.coinnet.entity.AdminCompany;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.AdminCompanyRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class AdminCompanyBOImpl implements AdminCompanyBO{

    private AdminCompanyRepository adminCompanyRepository;

    public AdminCompanyBOImpl() {
        
        adminCompanyRepository=(AdminCompanyRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADMINCOMPNAY);
    }
    
    
    
    @Override
    public List<AdminCompanyDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            adminCompanyRepository.setSession(session);
            List<AdminCompany> list=adminCompanyRepository.getAll();
            List<AdminCompanyDTO> adminList=new ArrayList<>();
            for (AdminCompany adminCompany : list) {
                adminList.add(new AdminCompanyDTO(adminCompany.getAdminComId(),adminCompany.getAdmin().getAdminId(),adminCompany.getCompany().getComId(),adminCompany.getDates(),adminCompany.getPayment(),adminCompany.getContract()));
            }
            session.close();
            return adminList;
        }
    }
    
}
