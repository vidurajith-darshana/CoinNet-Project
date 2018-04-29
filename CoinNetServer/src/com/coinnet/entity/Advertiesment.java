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
public class Advertiesment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;
    
    private String dates;
    private String times;
    private int payment;
    private String serviceType;

    public Advertiesment() {
    }

    public Advertiesment(int adId, Company company, String date, String time, int payment, String serviceType) {
        this.adId = adId;
        this.company = company;
        this.dates = date;
        this.times = time;
        this.payment = payment;
        this.serviceType = serviceType;
    }
    
    public Advertiesment(Company company, String date, String time, int payment, String serviceType) {
        
        this.company = company;
        this.dates = date;
        this.times = time;
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
        return "Advertiesment{" + "adId=" + adId + ", company=" + company + ", date=" + dates + ", time=" + times + ", payment=" + payment + ", serviceType=" + serviceType + '}';
    }
    
    
}
