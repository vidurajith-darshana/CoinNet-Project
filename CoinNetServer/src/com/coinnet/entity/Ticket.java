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
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Admin admin;
    
    private String name;
    private int price;
    private String pic;

    public Ticket() {
    }

    public Ticket(int ticketId, Admin admin, String name, int price, String pic) {
        this.ticketId = ticketId;
        this.admin = admin;
        this.name = name;
        this.price = price;
        this.pic = pic;
    }
    
    public Ticket(Admin admin, String name, int price, String pic) {
        
        this.admin = admin;
        this.name = name;
        this.price = price;
        this.pic = pic;
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
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
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
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Ticket{" + "ticketId=" + ticketId + ", admin=" + admin + ", name=" + name + ", price=" + price + ", pic=" + pic + '}';
    }
    
    
    
}
