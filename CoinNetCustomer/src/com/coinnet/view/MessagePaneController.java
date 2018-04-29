/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.dto.ChatDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.observable.custom.ChatObservable;
import com.coinnet.observer.custom.ChatObserver;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.AccountService;
import com.coinnet.service.custom.ChatAccountService;
import com.coinnet.service.custom.ChatService;
import com.coinnet.service.custom.CustomerService;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class MessagePaneController implements Initializable,ChatObserver {
    
    @FXML
    private ScrollPane friendsPane;

    @FXML
    private JFXTextArea msgArea;

    @FXML
    private ScrollPane chatPane;
    
    private AnchorPane containPane;
  
    private ChatService chatService;
    private ChatAccountService chatAccountService;
    private AccountService accountService;
    private CustomerService customerService;
    
    private ChatObservable chatObservable;
   
    private static ArrayList<FriendBoxController> myFriends=new ArrayList<>();
    private int id;
    private int last_clicked;
    private int height;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        try {
            containPane=new AnchorPane();
            containPane.setPrefSize(224,1000);
            chatPane.setContent(containPane);
            
            customerService=(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            accountService=(AccountService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCOUNT);
            chatService=(ChatService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CHAT);
            chatAccountService=(ChatAccountService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CHATACCOUNT);
            chatObservable=(ChatObservable) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CHAT);
            
            loadFriends();
            
            UnicastRemoteObject.exportObject(this,0);
            chatObservable.registerObserver(UserDetail.getInstance().getAccountId(), this);
            
            msgArea.setOnKeyPressed(e->{
                
                if(e.getCode()==KeyCode.SHIFT){
                    if(id==0){
                        Alert alert =new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("You must select a Friend to Chat!");
                        alert.showAndWait();
                    }else{
                        try {
                            Date d2=new Date();
                            SimpleDateFormat df2=new SimpleDateFormat("HH:mm:ss");
                            String time=df2.format(d2);

                            ChatDTO chat=new ChatDTO(0,msgArea.getText(), time);
                            ChatAccountDTO chatAccountDTO=new ChatAccountDTO(0,UserDetail.getInstance().getAccountId(), UserDetail.getInstance().getMessagePaneController().getOppositeId());

                            CustomerDTO customerDTO=customerService.getUserDetail(UserDetail.getInstance().getUserId());
                            AccountDTO accountDTO=accountService.getAccountDetail(UserDetail.getInstance().getEmail());

                            if(!msgArea.getText().equals("")){
                                chatObservable.setMessage(msgArea.getText());
                                chatService.saveChat(chat, chatAccountDTO,customerDTO,accountDTO);
                                msgArea.clear();

                            }else{
                                msgArea.clear();
                                Alert alert=new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText("Something went wrong!");
                                alert.setContentText("Check Your Connection..");
                                alert.showAndWait();
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(MessagePaneController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                
            });
            
        } catch (Exception ex) {
            Logger.getLogger(MessagePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @Override
    public void updateMessagePane(int sendId){
       
       loadMessages(sendId);
    }
    
    private void loadMessages(int sendId){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                
                Date d2=new Date();
                SimpleDateFormat df2=new SimpleDateFormat("HH:mm:ss");
                String time=df2.format(d2);

                try {

                    if(sendId==UserDetail.getInstance().getAccountId()){

                        ChatBoxController.setText=chatObservable.getMessage();
                        ChatBoxController.setPic=UserDetail.getInstance().getPic();
                        ChatBoxController.setTime=time;
                        ChatBoxController.background="blue";

                        AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/ChatBox.fxml"));
                        box.setLayoutY(height);
                        box.setLayoutX(0);
                        height+=box.getPrefHeight()+1;
                        containPane.getChildren().add(box);

                    }else{

                        List<AccountDTO> list=accountService.getAll();
                        String pic=null;
                        for (AccountDTO accountDTO : list) {
                             if(accountDTO.getAid()==sendId){
                                 CustomerDTO customer=customerService.getUserDetail(accountDTO.getCid());
                                 pic=customer.getPic();
                             }
                        }

                        ChatBoxController.setText=chatObservable.getMessage();
                        ChatBoxController.setPic=pic;
                        ChatBoxController.setTime=time;
                        ChatBoxController.background="gray";

                        AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/ChatBox.fxml"));
                        box.setLayoutY(height);
                        box.setLayoutX(55);
                        height+=box.getPrefHeight()+4;
                        containPane.getChildren().add(box);

                    }

                }catch(Exception e){

                }
                
            }
        });
        
    }
    
    private void loadFriends() {

        try {
            AnchorPane friendPane=new AnchorPane();
            int height=3;
            
            List<AccountDTO> accList=accountService.getAll();
            List<CustomerDTO> custList=customerService.getAll();
            
            for (CustomerDTO customerDTO : custList) {
                for (AccountDTO accountDTO : accList) {
                    if(customerDTO.getCid()==accountDTO.getCid() && accountDTO.getAid()!=UserDetail.getInstance().getAccountId()){
                        
                        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/com/coinnet/view/FriendBox.fxml"));
                        
                        FriendBoxController.email=accountDTO.getEmail();
                        FriendBoxController.name=customerDTO.getName();
                        FriendBoxController.pic=customerDTO.getPic();
                        
                        AnchorPane box=fxml.load();
                        myFriends.add(fxml.getController());
                        
                        box.setLayoutX(0);
                        box.setLayoutY(height);
                        friendPane.getChildren().add(box);
                        
                        height+=box.getPrefHeight();
                        
                    }
                }
            }
            
            friendsPane.setContent(friendPane);
        } catch (Exception ex) {
            Logger.getLogger(MessagePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateFriendStatus() throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                
                try {
                    List<Integer> onlineList=chatObservable.getObservers();
                    for (FriendBoxController myFriend : myFriends) {
                        
                        AccountDTO account=accountService.getAccountDetail(myFriend.getEmail());
                        for (Integer aid : onlineList) {
                         
                            if(account.getAid()==aid){
                                myFriend.setForOnline();
                                
                            }
                            
                        }
                       
                    }
                    
                    List<Integer> offlineList=new ArrayList<>();
                    
                    for (FriendBoxController myFriend : myFriends) {
                        
                        int aid=accountService.getAccountDetail(myFriend.getEmail()).getAid();
                        int count=0;
                        for (Integer integer : onlineList) {
                            if(integer==aid){
                                break;
                            }
                            count++;
                        }
                        if(count==onlineList.size()){
                            offlineList.add(aid);
                        }

                    }
                    
                    for (FriendBoxController myFriend : myFriends) {
                        int aid=accountService.getAccountDetail(myFriend.getEmail()).getAid();
                        for (Integer integer : offlineList) {
                            if(aid==integer){
                                myFriend.setForOffline();
                            }
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(MessagePaneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
   
    public void setLastClicked(int last_clicked){
        this.last_clicked=last_clicked;
    }
    
    public void setOppositeId(int id){
        
        
        height=0;
        containPane.getChildren().clear();
        this.id=id;
       
        try {
            
            if(last_clicked>0){
                List<AccountDTO> accountList=accountService.getAll();
                for (AccountDTO accountDTO : accountList) {
                    if(last_clicked==accountDTO.getAid()){
                        String email=accountDTO.getEmail();
                        for (FriendBoxController myFriend : myFriends) {
                            if(myFriend.getEmail().equals(email)){
                                myFriend.setAnotherClickBackground();
                                break;
                            }
                        }
                    }
                }
            }
            
            AnchorPane chats=new AnchorPane();
            chats.setPrefSize(224,1000);
            List<AccountDTO> accountList=accountService.getAll();
            AccountDTO account=null;
            
            for (AccountDTO accountDTO : accountList) {
                if(this.id==accountDTO.getAid()){
                    account=accountDTO;
                }
            }
            int cid=account.getCid();
            CustomerDTO customer=customerService.getUserDetail(cid);
            
            List<ChatAccountDTO> chatAccountList=chatAccountService.getAllChatAccounts();
            List<ChatDTO> chatList=chatService.getAllChats();
            if(!chatList.isEmpty()){
                for (ChatDTO chatDTO : chatList) {
                    for (ChatAccountDTO chatAccountDTO : chatAccountList) {
                        if(chatAccountDTO.getChatId()==chatDTO.getChatId() && ((chatAccountDTO.getSendAid()==account.getAid() && chatAccountDTO.getReceiveAid()==UserDetail.getInstance().getAccountId()) || (chatAccountDTO.getSendAid()==UserDetail.getInstance().getAccountId() && chatAccountDTO.getReceiveAid()==account.getAid()))){
                            if(chatAccountDTO.getSendAid()==account.getAid() && chatAccountDTO.getReceiveAid()==UserDetail.getInstance().getAccountId()){
                                List<Integer> onlineList=chatObservable.getObservers();
                                
                                ChatBoxController.setText=chatDTO.getDescription();
                                ChatBoxController.setPic=customer.getPic();
                                ChatBoxController.setTime=chatDTO.getTime();
                                ChatBoxController.background="gray";

                                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/ChatBox.fxml"));
                                box.setLayoutY(height);
                                box.setLayoutX(55);
                                height+=box.getPrefHeight()+4;
                                containPane.getChildren().add(box);
                                break;
                                
                            }else{
                                
                                ChatBoxController.setText=chatDTO.getDescription();
                                ChatBoxController.setPic=UserDetail.getInstance().getPic();
                                ChatBoxController.setTime=chatDTO.getTime();
                                ChatBoxController.background="blue";

                                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/ChatBox.fxml"));
                                box.setLayoutY(height);
                                box.setLayoutX(0);
                                height+=box.getPrefHeight()+4;
                                containPane.getChildren().add(box);
                                break;
                            }
                        }
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(MessagePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getOppositeId(){
        return id;
    }
    
    
}
