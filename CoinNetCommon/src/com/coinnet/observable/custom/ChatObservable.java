/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.observable.custom;

import com.coinnet.observer.Observable;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface ChatObservable extends Observable{
    
    public void notifyMessageObservers(int sendId,int receiveId)throws Exception;
    
   public void viewLoggedClients()throws Exception;
   
   public List<Integer> getObservers()throws Exception;
   
   public String getMessage()throws Exception;
   
   public void setMessage(String message)throws Exception;
    
}
