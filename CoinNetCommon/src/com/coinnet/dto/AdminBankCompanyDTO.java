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
public class AdminBankCompanyDTO extends SuperDTO{
    
    private int tid;
    private int bid;
    private int acid;
    private int amount;
    private String trasactionType;
    private String date;
    private String time;

    public AdminBankCompanyDTO() {
    }

    public AdminBankCompanyDTO(int tid, int bid, int acid, int amount, String trasactionType, String date, String time) {
        this.tid = tid;
        this.bid = bid;
        this.acid = acid;
        this.amount = amount;
        this.trasactionType = trasactionType;
        this.date = date;
        this.time = time;
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
     * @return the acid
     */
    public int getAcid() {
        return acid;
    }

    /**
     * @param acid the acid to set
     */
    public void setAcid(int acid) {
        this.acid = acid;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AdminBankCompany{" + "tid=" + tid + ", bid=" + bid + ", acid=" + acid + ", amount=" + amount + ", trasactionType=" + trasactionType + ", date=" + date + ", time=" + time + '}';
    }
    
    
    
}
