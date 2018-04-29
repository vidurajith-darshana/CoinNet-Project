/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.observer;

import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface Observable extends Remote{
    
    public void registerObserver(int aid,Observer observer)throws Exception;
    
    public void unRegisterObserver(int aid)throws Exception;
    
    
    
}
