/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.proxy;

import com.coinnet.service.ServiceFactory;
import com.coinnet.service.SuperService;
import com.coinnet.service.custom.AccountService;
import com.coinnet.service.custom.BankAccountService;
import com.coinnet.service.custom.ChatAccountService;
import com.coinnet.service.custom.ChatService;
import com.coinnet.service.custom.CustomerService;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vidurajith
 */
public class ProxyHandler implements ServiceFactory{
    
    private static ProxyHandler proxyHandler;
    
    private ServiceFactory serviceFactory;
    
    private CustomerService customerService;
    private ChatService chatService;
    private ChatAccountService chatAccountService;
    private AccountService accountService;
    private BankAccountService bankAccountService;
    
    private ProxyHandler(){
        
        try {
            serviceFactory=(ServiceFactory) Naming.lookup("rmi://localhost:5050/CoinNetServer");
            
            customerService=(CustomerService) serviceFactory.getService(ServiceTypes.CUSTOMER);
            chatService=(ChatService) serviceFactory.getService(ServiceTypes.CHAT);
            chatAccountService=(ChatAccountService) serviceFactory.getService(ServiceTypes.CHATACCOUNT);
            accountService=(AccountService) serviceFactory.getService(ServiceTypes.ACCOUNT);
            bankAccountService=(BankAccountService) serviceFactory.getService(ServiceTypes.ACCOUNTBANK);
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ProxyHandler getInstance(){
        if(proxyHandler==null){
            proxyHandler=new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes serviceTypes) throws Exception {
        
        switch(serviceTypes){
            case ACCOUNT:
                return accountService;
            case CHAT:
                return chatService;
            case CHATACCOUNT:
                return chatAccountService;
            case CUSTOMER:
                return customerService;
            case ACCOUNTBANK:
                return bankAccountService;
            default:
                return null;
        }
    }
    
}
