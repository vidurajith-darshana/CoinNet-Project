/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.service.custom.impl;

import com.coinnet.business.BOFactory;
import com.coinnet.business.custom.ChatBO;
import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.dto.ChatDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.observer.Observer;
import com.coinnet.service.custom.ChatService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import com.coinnet.observable.custom.ChatObservable;
import com.coinnet.observer.custom.ChatObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vidurajith
 */
public class ChatServiceImpl extends UnicastRemoteObject implements ChatService,ChatObservable{

    private ChatBO chatBO;
    public static Map<Integer,Observer> observerList=new HashMap<>();
    
    public static String message;
    
    public ChatServiceImpl()throws RemoteException{
     
        chatBO=(ChatBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.CHAT);
        
    }
    
    @Override
    public boolean saveChat(ChatDTO chatDTO, ChatAccountDTO chatAccountDTO,CustomerDTO customerDTO,AccountDTO accountDTO) throws Exception {
        
        if(chatBO.saveChat(chatDTO, chatAccountDTO,customerDTO,accountDTO)){
            notifyMessageObservers(chatAccountDTO.getSendAid(),chatAccountDTO.getReceiveAid());
            return true;
        }
        return false;
    }

    @Override
    public void registerObserver(int aid,Observer observer) throws Exception {
        
        observerList.put(aid,observer);
        viewLoggedClients();
        
       
    }

    @Override
    public void unRegisterObserver(int aid) throws Exception {
        
        observerList.remove(aid);
        viewLoggedClients();
        
    }
    
    
    @Override
    public void notifyMessageObservers(int sendId,int receiveId) throws Exception {

        new Thread(()->{
            
            Observer sendObserver=observerList.get(sendId);
            Observer receiveObserver=observerList.get(receiveId);
            try{
                if(sendObserver==null){
                    
                    ((ChatObserver)receiveObserver).updateMessagePane(sendId);
                }else if(receiveObserver==null){
                   
                    ((ChatObserver)sendObserver).updateMessagePane(sendId);
                }else{
                    
                    List<Observer> list=new ArrayList<>();
                    list.add(sendObserver);
                    list.add(receiveObserver);

                    for (Observer observer : list) {
                        ((ChatObserver)observer).updateMessagePane(sendId);
                    }
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }).start();
    }

    @Override
    public List<ChatDTO> getAllChats() throws Exception {
        
        return chatBO.getAllChat();
    }

    @Override
    public void viewLoggedClients() throws Exception {
        
        new Thread(()->{
            
            for (Integer integer : observerList.keySet()) {
                try {
                    ((ChatObserver)observerList.get(integer)).updateFriendStatus();
                } catch (Exception ex) {
                    Logger.getLogger(ChatServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }).start();
    }

    @Override
    public List<Integer> getObservers() throws Exception {
        
        List<Integer> keyList=new ArrayList<>();
        Iterator it=observerList.keySet().iterator();
        while(it.hasNext()){
            keyList.add((Integer)it.next());
        }
        return keyList;
    }

    @Override
    public String getMessage() throws Exception {
        
        return message;
    }

    @Override
    public void setMessage(String message) throws Exception {
        
        ChatServiceImpl.message=message;
    }

    
}
