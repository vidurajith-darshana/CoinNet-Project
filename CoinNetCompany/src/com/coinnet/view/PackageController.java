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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class PackageController implements Initializable {

    @FXML
    private JFXTabPane tbPane;

    @FXML
    private Tab tbBuy;

    @FXML
    private AnchorPane adPane;

    @FXML
    private Tab tbAdd;

    @FXML
    private AnchorPane seasonPane;

    @FXML
    private Tab tbManage;

    @FXML
    private AnchorPane managePane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
                AnchorPane addPane=FXMLLoader.load(getClass().getResource("/com/coinnet/view/AdPackage.fxml"));
                adPane.getChildren().setAll(addPane);
            } catch (IOException ex) {
                Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        tbAdd.setOnSelectionChanged(e->{
            
            try {
                AnchorPane addPane=FXMLLoader.load(getClass().getResource("/com/coinnet/view/AdPackage.fxml"));
                adPane.getChildren().setAll(addPane);
            } catch (IOException ex) {
                Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }    
    
}
