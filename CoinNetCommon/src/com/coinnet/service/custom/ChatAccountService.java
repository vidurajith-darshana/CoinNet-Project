/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface ChatAccountService extends SuperService{
   
    public List<ChatAccountDTO> getAllChatAccounts()throws Exception;
    
}
