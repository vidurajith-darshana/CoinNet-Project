/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.observer;

import java.rmi.Remote;

/**
 *
 * @author Vidurajith
 */
public interface Observer extends Remote{
    
    public void update()throws Exception;
    
}
