/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.dto;

/**
 *
 * @author Vidurajith
 */
public class ChatDTO extends SuperDTO{
    
    private int chatId;
    private String description;
    private String time;

    public ChatDTO() {
    }

    public ChatDTO(int chatId, String description, String time) {
        this.chatId = chatId;
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
        return "ChatDTO{" + "chatId=" + chatId + ", description=" + description + ", time=" + time + '}';
    }
    
    
    
}
