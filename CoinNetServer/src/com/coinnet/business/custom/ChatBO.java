/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.dto.ChatDTO;
import com.coinnet.dto.CustomerDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface ChatBO extends SuperBO{
    
    public boolean saveChat(ChatDTO chatDTO,ChatAccountDTO chatAccountDTO,CustomerDTO customer,AccountDTO accountDTO)throws Exception;
    
    public List<ChatDTO> getAllChat()throws Exception;
}
