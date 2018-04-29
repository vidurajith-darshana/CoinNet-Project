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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class MenuPaneController implements Initializable {

    @FXML
    private JFXButton btnTicket;

    @FXML
    private JFXButton btnCust;

    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnShoping;

    @FXML
    private JFXButton btnBank;

    @FXML
    private JFXButton btnShopingDetail;

    @FXML
    private ImageView imgTicket;

    @FXML
    private ImageView imgCust;

    @FXML
    private ImageView imgAdmin;

    @FXML
    private ImageView imgShopping;

    @FXML
    private ImageView imgTransaction;

    @FXML
    private ImageView imgDetail;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setImageProperties();
    }    
    
    @FXML
    private void ticketServiceOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/TicketService.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Ticket Service");
            DashBoardController.setLabel.setStyle("-fx-background-color:orange;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void customerServiceOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/CustomerService.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Customer Service");
            DashBoardController.setLabel.setStyle("-fx-background-color:blue;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void shoppingWorldOnAction(ActionEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/ShoppingWorld.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Shopping World");
            DashBoardController.setLabel.setStyle("-fx-background-color:violet;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void adminSocityOnAction(ActionEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/AdminSocity.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Admins World");
            DashBoardController.setLabel.setStyle("-fx-background-color:gray;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void bankTransactionOnAction(ActionEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/BankTransaction.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Transactions");
            DashBoardController.setLabel.setStyle("-fx-background-color:red;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void shoppingDetailOnAction(ActionEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/ShoppingDetail.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Shopping Detail");
            DashBoardController.setLabel.setStyle("-fx-background-color:green;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setImageProperties() {
        
        imgAdmin.setImage(new Image("com/coinnet/assets/admins.png"));
        imgDetail.setImage(new Image("com/coinnet/assets/ShoppingDetail.png"));
        imgShopping.setImage(new Image("com/coinnet/assets/ShoppingWorld.png"));
        imgCust.setImage(new Image("com/coinnet/assets/custservice.png"));
        imgTicket.setImage(new Image("com/coinnet/assets/ticketService.png"));
        imgTransaction.setImage(new Image("com/coinnet/assets/Transaction.png"));
    }
    
}
