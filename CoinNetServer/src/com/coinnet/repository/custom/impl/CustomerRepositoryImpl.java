/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom.impl;

import com.coinnet.entity.Customer;
import com.coinnet.repository.SuperRepositoryImpl;
import com.coinnet.repository.custom.CustomerRepository;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Vidurajith
 */
public class CustomerRepositoryImpl extends SuperRepositoryImpl<Customer, Integer> implements CustomerRepository{

    @Override
    public Customer getUserDetail(int cid) throws Exception {
        
        Query query=session.createQuery("From Customer c where c.cid=:cid");
        query.setParameter("cid", cid);
        List<Customer> list=query.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public boolean updateImage(String imgName,int cid) throws Exception {
      
        Query query=session.createQuery("UPDATE Customer set pic = :pic "  + "WHERE  cid = :cid");
        query.setParameter("pic",imgName);
        query.setParameter("cid", cid);
        
        return query.executeUpdate()>0;
    }

}
