/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CustomerBankDTO;
import com.coinnet.dto.CustomerDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface CustomerBO extends SuperBO{
    
    public boolean saveCustomer(CustomerDTO customerDTO,AccountDTO accountDTO,CustomerBankDTO customerBankDTO,BankDTO bankDTO)throws Exception;
    
    public CustomerDTO getUserDetail(int cid) throws Exception;
    
    public boolean updateImage(String imgName,int cid)throws Exception;
    
    public List<CustomerDTO> getAll()throws Exception;
   
}
