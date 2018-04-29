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
    private JFXButton btnGoods;

    @FXML
    private JFXButton btnPackage;

    @FXML
    private JFXButton btnPreview;

    @FXML
    private JFXButton btnBusiness;

    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnTransaction;

    @FXML
    private ImageView imgGoods1;

    @FXML
    private ImageView imgPack;

    @FXML
    private ImageView imgPreview;

    @FXML
    private ImageView imgBusiness;

    @FXML
    private ImageView imgAdmin;

    @FXML
    private ImageView imgTransaction;

    @FXML
    private ImageView imgGoods2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setImageProperties();
    }    
    
    @FXML
    private void processOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/Process.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Goods Processing");
            DashBoardController.setLabel.setStyle("-fx-cbackground-color:purple;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void packageOnAction(ActionEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/Package.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Packages");
            DashBoardController.setLabel.setStyle("-fx-background-color:purple;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void previewOnAction(ActionEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/PreviewShop.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Preview of My Shop");
            DashBoardController.setLabel.setStyle("-fx-background-color:red;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void businessOnAction(ActionEvent evt){
        
    }
    
    @FXML
    private void transactionOnAction(ActionEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/BankTransaction.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Transactions");
            DashBoardController.setLabel.setStyle("-fx-background-color:blue;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(MenuPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void helpOnAction(ActionEvent evt){
        
    }

    private void setImageProperties() {
        
        imgAdmin.setImage(new Image("com/coinnet/assets/help.png"));
        imgBusiness.setImage(new Image("com/coinnet/assets/business.png"));
        imgGoods1.setImage(new Image("com/coinnet/assets/goods.png"));
        imgGoods2.setImage(new Image("com/coinnet/assets/process.png"));
        imgPack.setImage(new Image("com/coinnet/assets/season.png"));
        imgTransaction.setImage(new Image("com/coinnet/assets/tranaction.png"));
        imgPreview.setImage(new Image("com/coinnet/assets/preview.png"));
    }
    
}
