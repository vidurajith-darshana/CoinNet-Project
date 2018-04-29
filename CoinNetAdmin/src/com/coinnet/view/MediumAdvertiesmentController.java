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
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class MediumAdvertiesmentController implements Initializable {

    @FXML
    private Circle circle;

    @FXML
    private Label lblCaption;

    @FXML
    private Label lblWord1;

    @FXML
    private Label lblWord2;

    @FXML
    private Label lblWord3;

    @FXML
    private ImageView img;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Platform.isSupported(ConditionalFeature.SHAPE_CLIP);
        ImagePattern imgPat=new ImagePattern(new Image("com/coinnet/assets/car.png"));
        circle.setFill(imgPat);
    }    
    
}
