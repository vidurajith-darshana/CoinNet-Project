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
public class BankDTO extends SuperDTO{
    
    private int bid;
    private String name;
    private String pic;
    private int rate;

    public BankDTO() {
    }

    public BankDTO(int bid, String name, String pic, int rate) {
        this.bid = bid;
        this.name = name;
        this.pic = pic;
        this.rate = rate;
    }

    /**
     * @return the bid
     */
    public int getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(int bid) {
        this.bid = bid;
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
     * @return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "BankDTO{" + "bid=" + bid + ", name=" + name + ", pic=" + pic + ", rate=" + rate + '}';
    }
    
    
    
}
