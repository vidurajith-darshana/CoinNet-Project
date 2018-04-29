/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom;

import com.coinnet.entity.Customer;
import com.coinnet.repository.SuperRepository;

/**
 *
 * @author Vidurajith
 */
public interface CustomerRepository extends SuperRepository<Customer, Integer>{
    
    public Customer getUserDetail(int cid) throws Exception;
    
    public boolean updateImage(String imgName,int cid)throws Exception;
    
    
}
