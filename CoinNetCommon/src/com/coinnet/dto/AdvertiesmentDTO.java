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
public class AdvertiesmentDTO extends SuperDTO{
    
    private int adId;
    private int comId;
    private String date;
    private String time;
    private int payment;
    private String serviceType;

    public AdvertiesmentDTO() {
    }

    public AdvertiesmentDTO(int adId, int comId, String date, String time, int payment, String serviceType) {
        this.adId = adId;
        this.comId = comId;
        this.date = date;
        this.time = time;
        this.payment = payment;
        this.serviceType = serviceType;
    }

    /**
     * @return the adId
     */
    public int getAdId() {
        return adId;
    }

    /**
     * @param adId the adId to set
     */
    public void setAdId(int adId) {
        this.adId = adId;
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

    /**
     * @return the serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @param serviceType the serviceType to set
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "AdvertiesmentDTO{" + "adId=" + adId + ", comId=" + comId + ", date=" + date + ", time=" + time + ", payment=" + payment + ", serviceType=" + serviceType + '}';
    }
    
    
    
}
