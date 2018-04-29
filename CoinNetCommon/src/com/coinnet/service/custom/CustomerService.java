/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CustomerBankDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface CustomerService extends SuperService{
    
    public boolean saveCustomer(CustomerDTO customerDTO,AccountDTO accountDTO,CustomerBankDTO customerBankDTO,BankDTO bankDTO)throws Exception;
    
    public CustomerDTO getUserDetail(int cid) throws Exception;
    
    public boolean saveImage(byte[] image,String name)throws Exception;
    
    public byte[] getImage(String email)throws Exception;
    
    public boolean updateImage(String imgName,int cid)throws Exception;
    
    public List<CustomerDTO> getAll()throws Exception;
   
}
