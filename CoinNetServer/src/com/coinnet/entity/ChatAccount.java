/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vidurajith
 */
@Entity
public class ChatAccount{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int chatAccountId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Chat chat;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;
    
    private int receiveAid;

    public ChatAccount() {
    }

    public ChatAccount(int chatAccountId, Chat chat, Account account, int receiveAid) {
        this.chatAccountId = chatAccountId;
        this.chat = chat;
        this.account = account;
        this.receiveAid = receiveAid;
    }
    
    public ChatAccount(Chat chat, Account account, int receiveAid) {
        
        this.chat = chat;
        this.account = account;
        this.receiveAid = receiveAid;
    }

    /**
     * @return the chatAccountId
     */
    public int getChatAccountId() {
        return chatAccountId;
    }

    /**
     * @param chatAccountId the chatAccountId to set
     */
    public void setChatAccountId(int chatAccountId) {
        this.chatAccountId = chatAccountId;
    }

    /**
     * @return the chat
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * @param chat the chat to set
     */
    public void setChat(Chat chat) {
        this.chat = chat;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return the receiveAid
     */
    public int getReceiveAid() {
        return receiveAid;
    }

    /**
     * @param receiveAid the receiveAid to set
     */
    public void setReceiveAid(int receiveAid) {
        this.receiveAid = receiveAid;
    }

    @Override
    public String toString() {
        return "ChatAccount{" + "chatAccountId=" + chatAccountId + ", chat=" + chat + ", account=" + account + ", receiveAid=" + receiveAid + '}';
    }
    
    
    
}
