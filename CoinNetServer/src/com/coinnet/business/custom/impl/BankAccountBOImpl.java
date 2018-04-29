/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.BankAccountBO;
import com.coinnet.dto.BankAccountDTO;
import com.coinnet.entity.BankAccount;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.BankAccountRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class BankAccountBOImpl implements BankAccountBO{

    private BankAccountRepository bankAccountRepository;

    public BankAccountBOImpl() {
        
        bankAccountRepository=(BankAccountRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.BANKACCOUNT);
    }
    
    
    
    @Override
    public List<BankAccountDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            
            bankAccountRepository.setSession(session);
            List<BankAccount> list=bankAccountRepository.getAll();
            List<BankAccountDTO> bankList=new ArrayList<>();
            for (BankAccount bankAccount : list) {
                bankList.add(new BankAccountDTO(bankAccount.getTid(),bankAccount.getBank().getBid(),bankAccount.getAccount().getAid(),bankAccount.getAmount(),bankAccount.getTransaction_type(),bankAccount.getDates(),bankAccount.getTimes()));
            }
            session.close();
            return bankList;
        }
    }
    
}
