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
public class TicketDTO extends SuperDTO{
    
    private int ticketId;
    private int adminId;
    private String name;
    private int price;
    private String pic;

    public TicketDTO() {
    }

    public TicketDTO(int ticketId, int adminId, String name, int price, String pic) {
        this.ticketId = ticketId;
        this.adminId = adminId;
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
     * @return the adminId
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * @param adminId the adminId to set
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
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
        return "TicketDTO{" + "ticketId=" + ticketId + ", adminId=" + adminId + ", name=" + name + ", price=" + price + ", pic=" + pic + '}';
    }
    
    
}
