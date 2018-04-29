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
public class BankCompanyDTO extends SuperDTO{
    
    private int tid;
    private int bid;
    private int comId;
    private int amount;
    private String transaction_type;
    private String date;
    private String time;

    public BankCompanyDTO() {
    }

    public BankCompanyDTO(int tid, int bid, int comId, int amount, String transaction_type, String date, String time) {
        this.tid = tid;
        this.bid = bid;
        this.comId = comId;
        this.amount = amount;
        this.transaction_type = transaction_type;
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
     * @return the comId
     */
    public int getComId() {
        return comId;
    }

    /**
     * @param comId the comId to set
     */
    public void setComId(int comId) {
        this.comId = comId;
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
        return "BankCompanyDTO{" + "tid=" + tid + ", bid=" + bid + ", comId=" + comId + ", amount=" + amount + ", transaction_type=" + transaction_type + ", date=" + date + ", time=" + time + '}';
    }
    
    
    
}
