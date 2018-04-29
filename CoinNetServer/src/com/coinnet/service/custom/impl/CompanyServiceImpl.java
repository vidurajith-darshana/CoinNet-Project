/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.CompanyBO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.BankCompanyDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CompanyDTO;
import com.coinnet.service.custom.CompanyService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Vidurajith
 */
public class CompanyServiceImpl extends UnicastRemoteObject implements CompanyService{

    private CompanyBO companyBO;
    
    public CompanyServiceImpl()throws RemoteException{
        companyBO=(CompanyBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.COMPANY);
    }
    
    @Override
    public boolean saveCompany(CompanyDTO companyDTO, BankCompanyDTO bankCompanyDTO,BankDTO bankDTO,List<AdminDTO> adminList) throws Exception {
        
        return companyBO.saveCompany(companyDTO, bankCompanyDTO,bankDTO,adminList);
    }

    @Override
    public List<CompanyDTO> getAll() throws Exception {
        
        return companyBO.getAll();
    }

    @Override
    public CompanyDTO getCompany(String email,String password) throws Exception {
        
        return companyBO.getCompany(email,password);
    }

    @Override
    public void saveImage(byte[] data,String name) throws Exception {
        
        BufferedImage img=ImageIO.read(new ByteArrayInputStream(data));
        try{
           
            ImageIO.write(img, "png",new File("company/"+name+".png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    
    }

    @Override
    public byte[] getImage(String email) throws Exception {
        
        try {
      
            File serverPathFile = new File("company/" + email);
            byte[] mydata = new byte[(int) serverPathFile.length()];
   
            FileInputStream in = new FileInputStream(serverPathFile);
            in.read(mydata, 0, mydata.length);
            in.close();
            return mydata;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    @Override
    public boolean updateImage(String imgName, int cid) throws Exception {
        
        return companyBO.updateImage(imgName, cid);
    }

    @Override
    public CompanyDTO getUserDetail(String email) throws Exception {
        
        return companyBO.getUserDetail(email);
    }
}
