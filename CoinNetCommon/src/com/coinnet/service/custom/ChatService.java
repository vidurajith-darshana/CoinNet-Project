/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom;

import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.dto.ChatDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.service.SuperService;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface ChatService extends SuperService{
    
    public boolean saveChat(ChatDTO chatDTO,ChatAccountDTO chatAccountDTO,CustomerDTO customerDTO,AccountDTO accountDTO)throws Exception;
    
    public List<ChatDTO> getAllChats()throws Exception;
}
