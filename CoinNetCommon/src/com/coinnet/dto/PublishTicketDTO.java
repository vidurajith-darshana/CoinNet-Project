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
public class PublishTicketDTO extends SuperDTO{
    
    private int publishId;
    private int ticketId;
    private String numbers;
    private int term;
    private String date;
    private int giftPrice;

    public PublishTicketDTO() {
    }

    public PublishTicketDTO(int publishId, int ticketId, String numbers, int term, String date, int giftPrice) {
        this.publishId = publishId;
        this.ticketId = ticketId;
        this.numbers = numbers;
        this.term = term;
        this.date = date;
        this.giftPrice = giftPrice;
    }
    
    public PublishTicketDTO(int ticketId, String numbers, int term, String date, int giftPrice) {
     
        this.ticketId = ticketId;
        this.numbers = numbers;
        this.term = term;
        this.date = date;
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
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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
        return "PublishTicketDTO{" + "publishId=" + publishId + ", ticketId=" + ticketId + ", numbers=" + numbers + ", term=" + term + ", date=" + date + ", giftPrice=" + giftPrice + '}';
    }
    
    
    
    
}
