/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.AdminBankCompanyBO;
import com.coinnet.dto.AdminBankCompanyDTO;
import com.coinnet.repository.RepositoryFactory;
import com.coinnet.service.custom.AdminBankCompanyService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class AdminBankCompanyServiceImpl extends UnicastRemoteObject implements AdminBankCompanyService{

    private AdminBankCompanyBO adminBankCompanyBO;

    public AdminBankCompanyServiceImpl()throws RemoteException{
        
        adminBankCompanyBO=(AdminBankCompanyBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.ADMINBANKCOMPANY);
    }
    
    
    @Override
    public List<AdminBankCompanyDTO> getAll() throws Exception {
        
        return adminBankCompanyBO.getAll();
    }
    
}
