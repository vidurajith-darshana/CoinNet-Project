/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom.impl;

import com.coinnet.entity.Company;
import com.coinnet.repository.SuperRepositoryImpl;
import com.coinnet.repository.custom.CompanyRepository;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Vidurajith
 */
public class CompanyRepositoryImpl extends SuperRepositoryImpl<Company,Integer> implements CompanyRepository{
    
    @Override
    public Company getCompany(String email,String password) throws Exception {
        
        Query query=session.createQuery("From Company where email='"+email+"' and password='"+password+"'");
        
        List<Company> list=query.list();
        System.out.println("list size is"+list.size());
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public boolean updateImage(String imgName, int cid) throws Exception {
        
        Query query=session.createQuery("update Company set pic=:pic"+" where comId=:cid");
        query.setParameter("pic",imgName);
        query.setParameter("cid", cid);
        return query.executeUpdate()>0;
    }

    @Override
    public Company getUserDetail(String email) throws Exception {
        
        Query query=session.createQuery("From Company where email=:email");
        query.setParameter("email", email);
        List<Company> list=query.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }
}
