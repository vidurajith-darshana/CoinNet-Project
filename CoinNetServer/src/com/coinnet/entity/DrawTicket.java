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
import javax.persistence.OneToOne;

/**
 *
 * @author Vidurajith
 */
@Entity
public class DrawTicket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int drawId;
    
    @OneToOne(cascade = CascadeType.ALL)
    private PublishTicket publishTicket;
    
    private int wonPrice;

    public DrawTicket() {
    }

    public DrawTicket(int drawId, PublishTicket publishTicket, int wonPrice) {
        this.drawId = drawId;
        this.publishTicket = publishTicket;
        this.wonPrice = wonPrice;
    }
    
    public DrawTicket(PublishTicket publishTicket, int wonPrice) {
        
        this.publishTicket = publishTicket;
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
     * @return the publishTicket
     */
    public PublishTicket getPublishTicket() {
        return publishTicket;
    }

    /**
     * @param publishTicket the publishTicket to set
     */
    public void setPublishTicket(PublishTicket publishTicket) {
        this.publishTicket = publishTicket;
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

    @Override
    public String toString() {
        return "DrawTicket{" + "drawId=" + drawId + ", publishTicket=" + publishTicket + ", wonPrice=" + wonPrice + '}';
    }
    
}
