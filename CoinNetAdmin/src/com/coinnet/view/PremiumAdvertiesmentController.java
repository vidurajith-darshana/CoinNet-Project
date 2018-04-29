/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class PremiumAdvertiesmentController implements Initializable {

    @FXML
    private Circle circle1;

    @FXML
    private Circle circle2;

    @FXML
    private Circle circle3;

    @FXML
    private Label lblCaption;

    @FXML
    private Label lblWord1;

    @FXML
    private Label lblWord2;

    @FXML
    private Label lblFooter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Platform.isSupported(ConditionalFeature.SHAPE_CLIP);
        
        ImagePattern imgPat1=new ImagePattern(new Image("com/coinnet/assets/tickets.png"));
        circle1.setFill(imgPat1);
        
        ImagePattern imgPat2=new ImagePattern(new Image("com/coinnet/assets/world.png"));
        circle2.setFill(imgPat2);
        
        ImagePattern imgPat3=new ImagePattern(new Image("com/coinnet/assets/cart.png"));
        circle3.setFill(imgPat3);
        
    }   
    
    
}
