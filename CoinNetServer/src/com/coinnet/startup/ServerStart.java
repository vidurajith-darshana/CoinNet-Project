/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.startup;

import com.coinnet.service.impl.ServiceFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vidurajith
 */
public class ServerStart {
    
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","localhost");
        try {
            Registry registry=LocateRegistry.createRegistry(5050);
            registry.rebind("CoinNetServer", ServiceFactoryImpl.getInstance());
            System.out.println("Server is started...");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
}
