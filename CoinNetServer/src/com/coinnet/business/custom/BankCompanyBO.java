/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.BankCompanyDTO;

/**
 *
 * @author Vidurajith
 */
public interface BankCompanyBO extends SuperBO{
    
    public boolean save(BankCompanyDTO bankCompanyDTO)throws Exception;
    
}
