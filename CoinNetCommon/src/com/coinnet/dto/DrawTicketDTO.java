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
public class DrawTicketDTO extends SuperDTO{
    
    private int drawId;
    private int publishId;
    private int wonPrice;

    public DrawTicketDTO() {
    }

    public DrawTicketDTO(int drawId, int publishId, int wonPrice) {
        this.drawId = drawId;
        this.publishId = publishId;
        this.wonPrice = wonPrice;
    }

    /**
     * @return the drawId
     */
    public int getDrawId() {
        return drawId;
    }

    /**
     * @param drawId the drawId to set
     */
    public void setDrawId(int drawId) {
        this.drawId = drawId;
    }

    /**
     * @return the publishId
     */
    public int getPublishId() {
        return publishId;
    }

    /**
     * @param publishId the publishId to set
     */
    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    /**
     * @return the wonPrice
     */
    public int getWonPrice() {
        return wonPrice;
    }

    /**
     * @param wonPrice the wonPrice to set
     */
    public void setWonPrice(int wonPrice) {
        this.wonPrice = wonPrice;
    }
    
    
    
}
