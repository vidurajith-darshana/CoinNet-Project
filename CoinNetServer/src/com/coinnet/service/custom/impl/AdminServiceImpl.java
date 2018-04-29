/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.AdminBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.service.custom.AdminService;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public class AdminServiceImpl extends UnicastRemoteObject implements AdminService{

    private AdminBO adminBO;

    public AdminServiceImpl() throws RemoteException{
        
        adminBO=(AdminBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.ADMIN);
    }
    
    
    
    @Override
    public boolean checkLogin(String email, String password) throws Exception {
        
        return adminBO.checkLogin(email, password);
    }

    @Override
    public List<AdminDTO> getAll() throws Exception {
        
        return adminBO.getAll();
    }

    @Override
    public byte[] getAdminImage(String name) throws Exception {
        
        try{
            File serverPathFile=new File("admin/"+name);
            byte[] myData=new byte[(int)serverPathFile.length()];
            FileInputStream in=new FileInputStream(serverPathFile);
            in.read(myData, 0, myData.length);
            in.close();
            return myData;
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public AdminDTO getAdminDetail(String email, String password) throws Exception {
        
        return adminBO.getAdminDetail(email, password);
    }

    
    
}
