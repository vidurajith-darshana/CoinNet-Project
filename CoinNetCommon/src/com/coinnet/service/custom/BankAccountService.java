/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.BankAccountDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface BankAccountService extends SuperService{
    
    public List<BankAccountDTO> getAll()throws Exception;
    
}
