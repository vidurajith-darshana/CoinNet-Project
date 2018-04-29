/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class CustomerServiceController implements Initializable {

     @FXML
    private JFXButton btnBack;

    @FXML
    private TabPane tbPne;

    @FXML
    private Tab tbRegCust;

    @FXML
    private AnchorPane custRegPane;

    @FXML
    private Tab tbRegCom;

    @FXML
    private AnchorPane comRegPane;

    @FXML
    private Tab tbNotify;

    @FXML
    private ScrollPane notificationPane;

    @FXML
    private ScrollPane worldPane;

    @FXML
    private Tab tbCust;

    @FXML
    private ScrollPane chatAdminsPane;

    @FXML
    private ScrollPane AdminChatPane;

    @FXML
    private Tab tbCom;

    @FXML
    private ScrollPane chatCompaniesPane;

    @FXML
    private ScrollPane companyChatPane;

    @FXML
    private Label lblMessages;

    @FXML
    private Label lblNotification;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tbRegCust.setOnSelectionChanged(evt->{
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/RegisterCustomer.fxml"));
                custRegPane.getChildren().setAll(box);
            } catch (IOException ex) {
                Logger.getLogger(CustomerServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        tbRegCom.setOnSelectionChanged(evt->{
            
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/RegisterCompany.fxml"));
                comRegPane.getChildren().setAll(box);
            } catch (IOException ex) {
                Logger.getLogger(CustomerServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }    
    
    @FXML
    private void btnBackOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/MenuPane.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Menu");
            DashBoardController.setLabel.setStyle("-fx-background-color:brown;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(CustomerServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
