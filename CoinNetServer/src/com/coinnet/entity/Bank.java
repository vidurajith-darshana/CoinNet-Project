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
public class Bank {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid;
    
    private String name;
    private String pic;
    private int rating;

    public Bank() {
    }

    public Bank(int bid, String name, String pic, int rating) {
        this.bid = bid;
        this.name = name;
        this.pic = pic;
        this.rating = rating;
    }
    
    public Bank(String name, String pic, int rating) {
       
        this.name = name;
        this.pic = pic;
        this.rating = rating;
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
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Bank{" + "bid=" + bid + ", name=" + name + ", pic=" + pic + ", rating=" + rating + '}';
    }
    
    
    
}
