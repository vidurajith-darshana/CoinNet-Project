/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.BankBO;
import com.coinnet.dto.BankDTO;
import com.coinnet.service.custom.BankService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class BankServiceImpl extends UnicastRemoteObject implements BankService{

    private BankBO bankBO;
    
    public BankServiceImpl()throws RemoteException{
        bankBO=(BankBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.BANK);
    }
    
    @Override
    public List<BankDTO> getAll() throws Exception {
        
        return bankBO.getAll();
    }
    
}
