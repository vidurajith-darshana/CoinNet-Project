/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.BankAdminBO;
import com.coinnet.dto.BankAdminDTO;
import com.coinnet.service.custom.BankAdminService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class BankAdminServiceImpl extends UnicastRemoteObject implements BankAdminService{

    private BankAdminBO bankAdminBO;
    
    public BankAdminServiceImpl()throws RemoteException{
        bankAdminBO= (BankAdminBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.BANKADMIN);
    }
    
    
    @Override
    public List<BankAdminDTO> getAll() throws Exception {
        
        return bankAdminBO.getAll();
    }
    
}
