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
public class AdminBankCompany {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
   
    @ManyToOne(cascade = CascadeType.ALL)
    private Bank bank;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private AdminCompany adminCompany;
    
    private int amount;
    private String trasactionType;
    private String dates;
    private String times;

    public AdminBankCompany() {
    }

    public AdminBankCompany(int tid, Bank bank, AdminCompany adminCompany, int amount, String trasactionType, String dates, String times) {
        this.tid = tid;
        this.bank = bank;
        this.adminCompany = adminCompany;
        this.amount = amount;
        this.trasactionType = trasactionType;
        this.dates = dates;
        this.times = times;
    }
    
    public AdminBankCompany(Bank bank, AdminCompany adminCompany, int amount, String trasactionType, String dates, String times) {
     
        this.bank = bank;
        this.adminCompany = adminCompany;
        this.amount = amount;
        this.trasactionType = trasactionType;
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
     * @return the adminCompany
     */
    public AdminCompany getAdminCompany() {
        return adminCompany;
    }

    /**
     * @param adminCompany the adminCompany to set
     */
    public void setAdminCompany(AdminCompany adminCompany) {
        this.adminCompany = adminCompany;
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
     * @return the trasactionType
     */
    public String getTrasactionType() {
        return trasactionType;
    }

    /**
     * @param trasactionType the trasactionType to set
     */
    public void setTrasactionType(String trasactionType) {
        this.trasactionType = trasactionType;
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

    @Override
    public String toString() {
        return "AdminBankCompany{" + "tid=" + tid + ", bank=" + bank + ", adminCompany=" + adminCompany + ", amount=" + amount + ", trasactionType=" + trasactionType + ", dates=" + dates + ", times=" + times + '}';
    }
    
    
    
    
}
