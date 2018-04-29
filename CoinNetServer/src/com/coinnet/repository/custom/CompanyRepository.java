/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.repository.custom;

import com.coinnet.entity.Company;
import com.coinnet.repository.SuperRepository;

/**
 *
 * @author Vidurajith
 */
public interface CompanyRepository extends SuperRepository<Company,Integer>{
    
    public Company getCompany(String email,String password)throws Exception;
    
    public boolean updateImage(String imgName,int cid)throws Exception;
    
    public Company getUserDetail(String email)throws Exception;
    
}
