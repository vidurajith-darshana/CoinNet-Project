/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class ShoppingDetailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void btnBackOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/MenuPane.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Menu");
            DashBoardController.setLabel.setStyle("-fx-background-color:brown;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(BankTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
