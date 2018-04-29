/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.AccountDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface AccountService extends SuperService{
    
    public AccountDTO getAccountDetail(String email,String password)throws Exception;
    
    public AccountDTO getAccountDetail(String email)throws Exception;
    
    public List<AccountDTO> getAll()throws Exception;
    
}
