/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom.impl;

import com.coinnet.business.custom.AccountBO;
import com.coinnet.dto.AccountDTO;
import com.coinnet.entity.Account;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.repository.custom.AccountRepository;
import com.coinnet.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Vidurajith
 */
public class AccountBOImpl implements AccountBO{

    private AccountRepository accountRepository;

    public AccountBOImpl() {
        accountRepository=(AccountRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ACCOUNT);
    }

    @Override
    public AccountDTO getAccountDetail(String email, String password) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            accountRepository.setSession(session);
            Account account=accountRepository.getAccountDetail(email, password);
            AccountDTO accountDTO=new AccountDTO(account.getAid(),account.getCustomer().getCid(),account.getEmail(),account.getPassword(),account.getReal_payment());
            session.close();
            return accountDTO;
            
        }
    }

    @Override
    public AccountDTO getAccountDetail(String email) throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            accountRepository.setSession(session);
            Account account=accountRepository.getAccountDetail(email);
            session.close();
            if(account!=null){
                return new AccountDTO(account.getAid(),account.getCustomer().getCid(),account.getEmail(),account.getPassword(),account.getReal_payment());
            }else{
                return null;
            }
            
        }
    }

    @Override
    public List<AccountDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            accountRepository.setSession(session);
            List<Account> list=accountRepository.getAll();
            List<AccountDTO> accList=new ArrayList<>();
            for (Account account : list) {
                
                accList.add(new AccountDTO(account.getAid(),account.getCustomer().getCid(),account.getEmail(),account.getPassword(),account.getReal_payment()));
                
            }
            session.close();
            return accList;
        }
    }
    
    
}
