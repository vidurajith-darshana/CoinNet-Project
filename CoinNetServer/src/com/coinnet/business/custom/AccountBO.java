/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.AccountDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface AccountBO extends SuperBO{
    
    public AccountDTO getAccountDetail(String email,String password)throws Exception;
    
    public AccountDTO getAccountDetail(String email)throws Exception;
    
    public List<AccountDTO> getAll()throws Exception;
    
}
