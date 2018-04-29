/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service;

import java.rmi.Remote;

/**
 *
 * @author Vidurajith
 */
public interface ServiceFactory extends Remote{
    
    public enum ServiceTypes{
        CUSTOMER,CHAT,CHATACCOUNT,ACCOUNT,ADMIN,BANK,BANKADMIN,COMPANY,ADMINBANKCOMPANY,ADMINCOMPANY,ACCOUNTBANK,TICKET,PUBLISHTICKET,DRAWTICKET
    }
    
    public SuperService getService(ServiceTypes serviceTypes)throws Exception;
}
