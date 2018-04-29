/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom;

import com.coinnet.entity.Account;
import com.coinnet.repository.SuperRepository;

/**
 *
 * @author Vidurajith
 */
public interface AccountRepository extends SuperRepository<Account, Integer>{
    
    public Account getAccountDetail(String email,String password)throws Exception;
    
    public Account getAccountDetail(String email)throws Exception;
    
}
