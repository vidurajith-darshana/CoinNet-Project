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
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    
    private String email;
    private String password;
    private int real_payment;

    public Account() {
    }

    public Account(int aid, Customer customer, String email, String password, int real_payment) {
        this.aid = aid;
        this.customer = customer;
        this.email = email;
        this.password = password;
        this.real_payment = real_payment;
    }
    
    public Account(Customer customer, String email, String password, int real_payment) {
      
        this.customer = customer;
        this.email = email;
        this.password = password;
        this.real_payment = real_payment;
    }

    /**
     * @return the aid
     */
    public int getAid() {
        return aid;
    }

    /**
     * @param aid the aid to set
     */
    public void setAid(int aid) {
        this.aid = aid;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        return "Account{" + "aid=" + aid + ", customer=" + customer + ", email=" + email + ", password=" + password + ", real_payment=" + real_payment + '}';
    }
    
    

    
}
