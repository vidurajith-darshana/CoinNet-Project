/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom.impl;

import com.coinnet.entity.Admin;
import com.coinnet.repository.SuperRepositoryImpl;
import com.coinnet.repository.custom.AdminRepository;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Vidurajith
 */
public class AdminRepositoryImpl extends SuperRepositoryImpl<Admin,Integer> implements AdminRepository{

    @Override
    public Admin getAdminDetail(String email, String password) throws Exception {
        
        Query query=session.createQuery("From Admin a where a.email=:email and a.password=:password");
        query.setParameter("email",email);
        query.setParameter("password", password);
        List<Admin> list=query.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    
}
