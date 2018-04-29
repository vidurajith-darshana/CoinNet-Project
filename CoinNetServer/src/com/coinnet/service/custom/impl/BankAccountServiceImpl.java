/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.BankAccountBO;
import com.coinnet.dto.BankAccountDTO;
import com.coinnet.service.custom.BankAccountService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class BankAccountServiceImpl extends UnicastRemoteObject implements BankAccountService{

    private BankAccountBO bankAccountBO;
    
    public BankAccountServiceImpl()throws RemoteException{
        
        bankAccountBO=(BankAccountBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.BANKACCOUNT);
    }
    
    @Override
    public List<BankAccountDTO> getAll() throws Exception {
        
        return bankAccountBO.getAll();
    }
    
}
