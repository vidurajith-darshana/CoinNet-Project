/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom;

import com.coinnet.entity.Admin;
import com.coinnet.repository.SuperRepository;

/**
 *
 * @author Vidurajith
 */
public interface AdminRepository extends SuperRepository<Admin,Integer>{
    
    public Admin getAdminDetail(String email,String password)throws Exception;
    
}
