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
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;
    
    private String name;
    private String pic;
    private String address;
    private String contact;
    private String email;
    private String password;
    private int payment;

    public Admin() {
    }

    public Admin(int adminId, String name, String pic, String address, String contact, String email, String password, int payment) {
        this.adminId = adminId;
        this.name = name;
        this.pic = pic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.payment = payment;
    }
    
    public Admin(String name, String pic, String address, String contact, String email, String password, int payment) {
     
        this.name = name;
        this.pic = pic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.payment = payment;
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
     * @return the payment
     */
    public int getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Admin{" + "adminId=" + adminId + ", name=" + name + ", pic=" + pic + ", address=" + address + ", contact=" + contact + ", email=" + email + ", password=" + password + ", payment=" + payment + '}';
    }

    
}
