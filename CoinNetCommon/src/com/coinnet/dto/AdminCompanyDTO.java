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
public class AdminCompanyDTO extends SuperDTO{
    
    private int adminComId;
    private int adminId;
    private int comId;
    private String date;
    private int payment;
    private int contract;

    public AdminCompanyDTO() {
    }

    public AdminCompanyDTO(int adminComId, int adminId, int comId, String date, int payment, int contract) {
        this.adminComId = adminComId;
        this.adminId = adminId;
        this.comId = comId;
        this.date = date;
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
        return "AdminCompanyDTO{" + "adminComId=" + adminComId + ", adminId=" + adminId + ", comId=" + comId + ", date=" + date + ", payment=" + payment + ", contract=" + contract + '}';
    }
    
    

    
}
