/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.proxy;

import com.coinnet.service.ServiceFactory;
import com.coinnet.service.SuperService;
import com.coinnet.service.custom.CompanyService;
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
    
    private CompanyService companyService;
    
    private ProxyHandler(){
        try {
            serviceFactory=(ServiceFactory) Naming.lookup("rmi://localhost:5050/CoinNetServer");
            
            companyService=(CompanyService) serviceFactory.getService(ServiceTypes.COMPANY);
        } catch (Exception ex) {
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
            case COMPANY:
                return companyService;
            default:
                return null;
        }
    }
    
    
    
}
