/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.jfoenix.controls.JFXTabPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class ProcessController implements Initializable {

     @FXML
    private JFXTabPane tbPane;

    @FXML
    private Tab tbBuy;

    @FXML
    private AnchorPane buyPane;

    @FXML
    private Tab tbAdd;

    @FXML
    private AnchorPane addPane;

    @FXML
    private Tab tbManage;

    @FXML
    private AnchorPane managePane;

    @FXML
    private Tab tbGraph;

    @FXML
    private AnchorPane graphPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(tbPane.getSelectionModel().getSelectedIndex()==0){
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/BuyGoods.fxml"));
                buyPane.getChildren().setAll(box);
            } catch (IOException ex) {
                Logger.getLogger(ProcessController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        tbBuy.setOnSelectionChanged((Event event)->{
            
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/BuyGoods.fxml"));
                buyPane.getChildren().setAll(box);
            } catch (IOException ex) {
                Logger.getLogger(ProcessController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        tbGraph.setOnSelectionChanged((Event event)->{
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/DailyGraph.fxml"));
                graphPane.getChildren().setAll(box);
            } catch (IOException ex) {
                Logger.getLogger(ProcessController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        tbManage.setOnSelectionChanged((Event event)->{
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/ManageGoods.fxml"));
                managePane.getChildren().setAll(box);
            } catch (IOException ex) {
                Logger.getLogger(ProcessController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        tbAdd.setOnSelectionChanged((Event event)->{
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/AddGoods.fxml"));
                addPane.getChildren().setAll(box);
            } catch (IOException ex) {
                Logger.getLogger(ProcessController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }  
    
}
