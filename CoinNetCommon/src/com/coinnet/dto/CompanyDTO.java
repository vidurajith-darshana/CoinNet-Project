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
public class CompanyDTO extends SuperDTO{
    
    private int comID;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String password;
    private int payment;
    private String serviceType;
    private String pic;

    public CompanyDTO() {
    }

    public CompanyDTO(int comID, String name, String address, String contact, String email, String password, int payment, String serviceType, String pic) {
        this.comID = comID;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.payment = payment;
        this.serviceType = serviceType;
        this.pic = pic;
    }

    /**
     * @return the comID
     */
    public int getComID() {
        return comID;
    }

    /**
     * @param comID the comID to set
     */
    public void setComID(int comID) {
        this.comID = comID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
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

    /**
     * @return the pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic the pic to set
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" + "comID=" + comID + ", name=" + name + ", address=" + address + ", contact=" + contact + ", email=" + email + ", password=" + password + ", payment=" + payment + ", serviceType=" + serviceType + ", pic=" + pic + '}';
    }
    
    
    
}
