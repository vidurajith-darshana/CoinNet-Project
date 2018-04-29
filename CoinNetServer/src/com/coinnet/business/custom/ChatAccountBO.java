/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.business.custom;

import com.coinnet.business.SuperBO;
import com.coinnet.dto.ChatAccountDTO;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface ChatAccountBO extends SuperBO{
    
    public List<ChatAccountDTO> getAll()throws Exception;
    
}
