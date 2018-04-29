/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.other;

import com.coinnet.view.MessagePaneController;

/**
 *
 * @author Vidurajith
 */
public class UserDetail {
    
    private static UserDetail userDetail;
    
    private int userId;
    private String name;
    private String contact;
    private String email;
    private String pic;
    private int accountId;
    
    private MessagePaneController messagePaneController;
    
    private UserDetail(){
        
    }
    
    public static UserDetail getInstance(){
        if(userDetail==null){
            userDetail=new UserDetail();
        }
        return userDetail;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic the pic to set
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * @return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the messagePaneController
     */
    public MessagePaneController getMessagePaneController() {
        return messagePaneController;
    }

    /**
     * @param messagePaneController the messagePaneController to set
     */
    public void setMessagePaneController(MessagePaneController messagePaneController) {
        this.messagePaneController = messagePaneController;
    }
    
}
