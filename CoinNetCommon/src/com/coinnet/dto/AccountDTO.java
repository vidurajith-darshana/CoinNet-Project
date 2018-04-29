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
public class AccountDTO extends SuperDTO{
    
    private int aid;
    private int cid;
    private String email;
    private String password;
    private int payment;

    public AccountDTO() {
    }

    public AccountDTO(int aid, int cid, String email, String password, int payment) {
        this.aid = aid;
        this.cid = cid;
        this.email = email;
        this.password = password;
        this.payment = payment;
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
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
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
        return "AccountDTO{" + "aid=" + aid + ", cid=" + cid + ", email=" + email + ", password=" + password + ", payment=" + payment + '}';
    }
    
    
}
