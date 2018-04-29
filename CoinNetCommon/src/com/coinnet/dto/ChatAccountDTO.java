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
public class ChatAccountDTO extends SuperDTO{
    
    private int chatId;
    private int sendAid;
    private int receiveAid;

    public ChatAccountDTO() {
    }

    public ChatAccountDTO(int chatId, int sendAid, int receiveAid) {
        this.chatId = chatId;
        this.sendAid = sendAid;
        this.receiveAid = receiveAid;
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
     * @return the sendAid
     */
    public int getSendAid() {
        return sendAid;
    }

    /**
     * @param sendAid the sendAid to set
     */
    public void setSendAid(int sendAid) {
        this.sendAid = sendAid;
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
        return "ChatAccountDTO{" + "chatId=" + chatId + ", sendAid=" + sendAid + ", receiveAid=" + receiveAid + '}';
    }
    
    
    
}
