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
public class BankCompany {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Bank bank;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;
    
    private int amount;
    private String transaction_type;
    private String dates;
    private String times;

    public BankCompany() {
    }

    public BankCompany(int tid, Bank bank, Company company, int amount, String transaction_type, String dates, String times) {
        this.tid = tid;
        this.bank = bank;
        this.company = company;
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.dates = dates;
        this.times = times;
    }

    public BankCompany(Bank bank, Company company, int amount, String transaction_type, String dates, String times) {
        
        this.bank = bank;
        this.company = company;
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.dates = dates;
        this.times = times;
    }

    /**
     * @return the tid
     */
    public int getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(int tid) {
        this.tid = tid;
    }

    /**
     * @return the bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /**
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the transaction_type
     */
    public String getTransaction_type() {
        return transaction_type;
    }

    /**
     * @param transaction_type the transaction_type to set
     */
    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
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
     * @return the times
     */
    public String getTimes() {
        return times;
    }

    /**
     * @param times the times to set
     */
    public void setTimes(String times) {
        this.times = times;
    }
    
    
}
