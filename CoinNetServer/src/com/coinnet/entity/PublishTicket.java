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
public class PublishTicket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publishId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Ticket ticket;
    
    private String numbers;
    private int term;
    private String dates;
    private int giftPrice;

    public PublishTicket() {
    }

    public PublishTicket(int publishId, Ticket ticket, String numbers, int term, String date, int giftPrice) {
        this.publishId = publishId;
        this.ticket = ticket;
        this.numbers = numbers;
        this.term = term;
        this.dates = date;
        this.giftPrice = giftPrice;
    }
    
    public PublishTicket(Ticket ticket, String numbers, int term, String date, int giftPrice) {
    
        this.ticket = ticket;
        this.numbers = numbers;
        this.term = term;
        this.dates = date;
        this.giftPrice = giftPrice;
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
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the numbers
     */
    public String getNumbers() {
        return numbers;
    }

    /**
     * @param numbers the numbers to set
     */
    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    /**
     * @return the term
     */
    public int getTerm() {
        return term;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(int term) {
        this.term = term;
    }

    /**
     * @return the dates
     */
    public String getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(String dates) {
        this.dates = dates;
    }

    /**
     * @return the giftPrice
     */
    public int getGiftPrice() {
        return giftPrice;
    }

    /**
     * @param giftPrice the giftPrice to set
     */
    public void setGiftPrice(int giftPrice) {
        this.giftPrice = giftPrice;
    }

    @Override
    public String toString() {
        return "PublishTicket{" + "publishId=" + publishId + ", ticket=" + ticket + ", numbers=" + numbers + ", term=" + term + ", date=" + dates + ", giftPrice=" + giftPrice + '}';
    }
    
}
