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
public class AdminDTO extends SuperDTO{
    
    private int adminID;
    private String name;
    private String pic;
    private String address;
    private String contact;
    private String email;
    private String password;
    private int real_payment;

    public AdminDTO() {
    }

    public AdminDTO(int adminID, String name, String pic, String address, String contact, String email, String password, int real_payment) {
        this.adminID = adminID;
        this.name = name;
        this.pic = pic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.real_payment = real_payment;
    }

    /**
     * @return the adminID
     */
    public int getAdminID() {
        return adminID;
    }

    /**
     * @param adminID the adminID to set
     */
    public void setAdminID(int adminID) {
        this.adminID = adminID;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the real_payment
     */
    public int getReal_payment() {
        return real_payment;
    }

    /**
     * @param real_payment the real_payment to set
     */
    public void setReal_payment(int real_payment) {
        this.real_payment = real_payment;
    }

    @Override
    public String toString() {
        return "AdminDTO{" + "adminID=" + adminID + ", name=" + name + ", pic=" + pic + ", address=" + address + ", contact=" + contact + ", email=" + email + ", password=" + password + ", real_payment=" + real_payment + '}';
    }

    
}
