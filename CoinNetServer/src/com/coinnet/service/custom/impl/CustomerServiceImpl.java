/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.CustomerBO;
import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CustomerBankDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.service.custom.CustomerService;
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
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService{

    private CustomerBO customerBO;
    
    public CustomerServiceImpl()throws RemoteException{
        
        customerBO=(CustomerBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.CUSTOMER);
    }
    
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO,AccountDTO accountDTO,CustomerBankDTO customerBankDTO,BankDTO bankDTO) throws Exception {
        
        return customerBO.saveCustomer(customerDTO,accountDTO,customerBankDTO,bankDTO);
    }

    @Override
    public CustomerDTO getUserDetail(int cid) throws Exception {
        
        return customerBO.getUserDetail(cid);
    }

    @Override
    public boolean saveImage(byte[] image, String name) throws Exception {
        
        try{
            BufferedImage buf=ImageIO.read(new ByteArrayInputStream(image));
            ImageIO.write(buf, "png",new File("customer/"+name+".png"));
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    @Override
    public byte[] getImage(String email) throws Exception {
        
        try {
      
            File serverPathFile = new File("customer/" + email+".png");
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
        
        return customerBO.updateImage(imgName, cid);
    }

    @Override
    public List<CustomerDTO> getAll() throws Exception {
        
        return customerBO.getAll();
    }

    
}
