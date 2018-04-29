/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class BuyGoodsController implements Initializable {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXButton btnBack;

    @FXML
    private ScrollPane cmpnyScrlPane;

    @FXML
    private ScrollPane goodsScrlpane;

    @FXML
    private ScrollPane cartScrlPane;

    @FXML
    private TextField txtTotal;

    @FXML
    private JFXTextField txtSrchCmpny;

    @FXML
    private JFXTextField txtSrchGoods;

    @FXML
    private Button btnPayment;
    
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
            Logger.getLogger(DailyGraphController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void paymentBtnOnAction(ActionEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/Payment.fxml"));

            FadeTransition fade=new FadeTransition(Duration.millis(2000), box);
            fade.setFromValue(0);
            fade.setToValue(0.95);
            fade.setCycleCount(1);
            fade.play();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {

                    Stage stage=new Stage();
                    stage.initStyle(StageStyle.TRANSPARENT);
                    box.setBackground(Background.EMPTY);
                    Scene scene=new Scene(box);
                    scene.setFill(Color.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();
                    mainPane.setDisable(true);
                    DashBoardController.setMainPane.setDisable(true);
                }
            });

        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
