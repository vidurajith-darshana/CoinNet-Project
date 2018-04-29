/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.tableModel;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Vidurajith
 */
public class ItemTableModel {
    
    private SimpleStringProperty ItemName=new SimpleStringProperty("");
    private SimpleStringProperty Qty=new SimpleStringProperty("");
    private SimpleStringProperty UnitPrice=new SimpleStringProperty("");
    private SimpleStringProperty LastPrice=new SimpleStringProperty("");
    
    public void setItemName(String ItemName){
        this.ItemName.set(ItemName);
    }
    public String getItemName(){
        return ItemName.get();
    }
    public void setQty(String Qty){
        this.Qty.set(Qty);
    }
    public String getQty(){
        return Qty.get();
    }
    public void setUnitPrice(String UnitPrice){
        this.UnitPrice.set(UnitPrice);
    }
    public String getUnitPrice(){
        return UnitPrice.get();
    }
    public void setLastPrice(String LastPrice){
        this.LastPrice.set(LastPrice);
    }
    public String getLastPrice(){
        return LastPrice.get();
    }
    
}
