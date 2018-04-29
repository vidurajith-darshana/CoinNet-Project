/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vidurajith
 */
@Entity
public class Chat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int chatId;
    
    private String description;
    private String time;

    public Chat() {
    }

    public Chat(int chatId, String description, String time) {
        this.chatId = chatId;
        this.description = description;
        this.time = time;
    }
    
    public Chat(String description, String time) {
        
        this.description = description;
        this.time = time;
    }

    /**
     * @return the chatId
     */
    public int getChatId() {
        return chatId;
    }

    /**
     * @param chatId the chatId to set
     */
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Chat{" + "chatId=" + chatId + ", description=" + description + ", time=" + time + '}';
    }
    
    
    
}
