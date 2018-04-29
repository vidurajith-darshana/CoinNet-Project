/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.BankBO;
import com.coinnet.dto.BankDTO;
import com.coinnet.entity.Bank;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.BankRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class BankBOImpl implements BankBO{

    private BankRepository bankRepository;
    
    public BankBOImpl(){
        
        bankRepository=(BankRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.BANK);
    }
    
    @Override
    public List<BankDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            bankRepository.setSession(session);
            List<Bank> bankResults=bankRepository.getAll();
            List<BankDTO> banks=new ArrayList<>();

            for (Bank bankResult : bankResults) {
                banks.add(new BankDTO(bankResult.getBid(),bankResult.getName(),bankResult.getPic(),bankResult.getRating()));
            }
            session.close();
            return banks;
        }
    }
    
}
