/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.AdminCompanyBO;
import com.coinnet.dto.AdminCompanyDTO;
import com.coinnet.service.custom.AdminCompanyService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class AdminCompanyServiceImpl extends UnicastRemoteObject implements AdminCompanyService{

    private AdminCompanyBO adminCompanyBO;
    
    public AdminCompanyServiceImpl()throws RemoteException{
        
        adminCompanyBO=(AdminCompanyBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.ADMINCOMPANY);
    }
    
    @Override
    public List<AdminCompanyDTO> getAll() throws Exception {
        
        return adminCompanyBO.getAll();
    }
    
}
