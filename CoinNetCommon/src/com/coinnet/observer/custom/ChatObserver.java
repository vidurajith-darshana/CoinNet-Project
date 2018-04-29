/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.observer.custom;

import com.coinnet.observer.Observer;
import java.util.List;

/**
 *
 * @author Vidurajith
 */
public interface ChatObserver extends Observer{

    @Override
    public default void update() throws Exception {}
    
    public void updateMessagePane(int sendId)throws Exception;
    
    public void updateFriendStatus()throws Exception;
    
}
