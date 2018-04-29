/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom.impl;

import com.coinnet.entity.Account;
import com.coinnet.repository.SuperRepositoryImpl;
import com.coinnet.repository.custom.AccountRepository;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Vidurajith
 */
public class AccountRepositoryImpl extends SuperRepositoryImpl<Account, Integer> implements AccountRepository{

    @Override
    public Account getAccountDetail(String email, String password) throws Exception {
        
        Query query=session.createQuery("From Account a where a.email=:email and a.password=:password");
        query.setParameter("password", password);
        query.setParameter("email", email);
        List<Account> list=query.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public Account getAccountDetail(String email) throws Exception {
        
        Query query=session.createQuery("From Account where email=:email");
        query.setParameter("email", email);
        List<Account> list=query.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }
    
}
