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
public class AdminCompany {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminComId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Admin admin;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;
    
    private String dates;
    private int payment;
    private int contract;

    public AdminCompany() {
    }

    public AdminCompany(int adminComId, Admin admin, Company company, String dates, int payment, int contract) {
        this.adminComId = adminComId;
        this.admin = admin;
        this.company = company;
        this.dates = dates;
        this.payment = payment;
        this.contract = contract;
    }
    
    public AdminCompany(Admin admin, Company company, String dates, int payment, int contract) {
    
        this.admin = admin;
        this.company = company;
        this.dates = dates;
        this.payment = payment;
        this.contract = contract;
    }

    /**
     * @return the adminComId
     */
    public int getAdminComId() {
        return adminComId;
    }

    /**
     * @param adminComId the adminComId to set
     */
    public void setAdminComId(int adminComId) {
        this.adminComId = adminComId;
    }

    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
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
     * @return the contract
     */
    public int getContract() {
        return contract;
    }

    /**
     * @param contract the contract to set
     */
    public void setContract(int contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "AdminCompany{" + "adminComId=" + adminComId + ", admin=" + admin + ", company=" + company + ", dates=" + dates + ", payment=" + payment + ", contract=" + contract + '}';
    }
    
    
    
    
    
}
