/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.impl;

import com.coinnet.service.ServiceFactory;
import com.coinnet.service.SuperService;
import com.coinnet.service.custom.impl.AccountServiceImpl;
import com.coinnet.service.custom.impl.AdminBankCompanyServiceImpl;
import com.coinnet.service.custom.impl.AdminCompanyServiceImpl;
import com.coinnet.service.custom.impl.AdminServiceImpl;
import com.coinnet.service.custom.impl.BankAccountServiceImpl;
import com.coinnet.service.custom.impl.BankAdminServiceImpl;
import com.coinnet.service.custom.impl.BankServiceImpl;
import com.coinnet.service.custom.impl.ChatAccountServiceImpl;
import com.coinnet.service.custom.impl.ChatServiceImpl;
import com.coinnet.service.custom.impl.CompanyServiceImpl;
import com.coinnet.service.custom.impl.CustomerServiceImpl;
import com.coinnet.service.custom.impl.DrawTicketServiceImpl;
import com.coinnet.service.custom.impl.PublishTicketServiceImpl;
import com.coinnet.service.custom.impl.TicketServiceImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Vidurajith
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{

    private static ServiceFactoryImpl serviceFactoryImpl;
    
    private ServiceFactoryImpl()throws RemoteException{
        
    }
    
    public static ServiceFactoryImpl getInstance() throws RemoteException{
        if(serviceFactoryImpl==null){
            serviceFactoryImpl=new ServiceFactoryImpl();
        }
        return serviceFactoryImpl;
    }
    
    @Override
    public SuperService getService(ServiceTypes serviceTypes) throws Exception{
        
        switch(serviceTypes){
            case CHAT:
                return new ChatServiceImpl();
            case ACCOUNT:
                return new AccountServiceImpl();
            case CHATACCOUNT:
                return new ChatAccountServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ADMIN:
                return new AdminServiceImpl();
            case BANK:
                return new BankServiceImpl();
            case BANKADMIN:
                return new BankAdminServiceImpl();
            case COMPANY:
                return new CompanyServiceImpl();
            case ADMINBANKCOMPANY:
                return new AdminBankCompanyServiceImpl();
            case ADMINCOMPANY:
                return new AdminCompanyServiceImpl();
            case TICKET:
                return new TicketServiceImpl();
            case PUBLISHTICKET:
                return new PublishTicketServiceImpl();
            case DRAWTICKET:
                return new DrawTicketServiceImpl();
            case ACCOUNTBANK:
                return new BankAccountServiceImpl();
            default:
                return null;
        }
    }
    
}
