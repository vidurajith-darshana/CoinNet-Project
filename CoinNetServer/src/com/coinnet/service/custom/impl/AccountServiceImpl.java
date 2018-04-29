/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.AccountBO;
import com.coinnet.dto.AccountDTO;
import com.coinnet.service.custom.AccountService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class AccountServiceImpl extends UnicastRemoteObject implements AccountService{

    private AccountBO accountBO;
    
    public AccountServiceImpl()throws RemoteException{
        
        accountBO=(AccountBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.ACCOUNT);
        
    }

    @Override
    public AccountDTO getAccountDetail(String email, String password) throws Exception {
        
        return accountBO.getAccountDetail(email, password);
    }

    @Override
    public AccountDTO getAccountDetail(String email) throws Exception {
        
        return accountBO.getAccountDetail(email);
    }

    @Override
    public List<AccountDTO> getAll() throws Exception {
        
        return accountBO.getAll();
    }
    
}
