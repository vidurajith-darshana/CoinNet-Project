/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.BankAdminBO;
import com.coinnet.dto.BankAdminDTO;
import com.coinnet.entity.BankAdmin;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.BankAdminRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class BankAdminBOImpl implements BankAdminBO{

    private BankAdminRepository bankAdminRepository;
    
    public BankAdminBOImpl(){
        bankAdminRepository= (BankAdminRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.BANKADMIN);
    }
    
    @Override
    public List<BankAdminDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            bankAdminRepository.setSession(session);
            List<BankAdmin> bankResult=bankAdminRepository.getAll();
            List<BankAdminDTO> banks=new ArrayList<>();
            
            for (BankAdmin bankAdmin : bankResult) {

                banks.add(new BankAdminDTO(bankAdmin.getTid(), bankAdmin.getAdmin().getAdminId(),bankAdmin.getBank().getBid(),bankAdmin.getAmount(),bankAdmin.getTransaction_type(),bankAdmin.getDates(),bankAdmin.getTimes()));
            }
            session.close();
            return banks;
        }
        
    }
    
}
