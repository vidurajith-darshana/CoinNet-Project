/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.ChatAccountBO;
import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.service.custom.ChatAccountService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class ChatAccountServiceImpl extends UnicastRemoteObject implements ChatAccountService{

    private ChatAccountBO chatAccountBO;
    
    public ChatAccountServiceImpl()throws RemoteException{
        
        chatAccountBO=(ChatAccountBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.CHATACCOUNT);
        
    }
    

    @Override
    public List<ChatAccountDTO> getAllChatAccounts() throws Exception {
        
        return chatAccountBO.getAll();
    }
    
}
