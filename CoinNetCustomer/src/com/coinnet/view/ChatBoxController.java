/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.CustomerService;
import static com.coinnet.view.FriendBoxController.pic;
import com.jfoenix.controls.JFXTextArea;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class ChatBoxController implements Initializable {

    @FXML
    private AnchorPane chatPane;

    @FXML
    private AnchorPane msgPane;

    @FXML
    private JFXTextArea msgArea;

    @FXML
    private Label lblTime;

    @FXML
    private Circle imgCircle;

    public static String setText;
    public static String background;
    public static String setTime;
    public static String setPic;
   
    private CustomerService customerService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            customerService=(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            
            if(setText!=null){
                setMessage();
                
                BufferedImage img=ImageIO.read(new ByteArrayInputStream(customerService.getImage(pic)));
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                ImageIO.write(img,"png",baos);
                InputStream is=new ByteArrayInputStream(baos.toByteArray());
                
                Platform.isSupported(ConditionalFeature.SHAPE_CLIP);
                ImagePattern imgPat=new ImagePattern(new Image(is));
                imgCircle.setFill(imgPat);
                
                if(background!=null){
                    msgPane.setStyle("-fx-background-color:"+background+";-fx-background-radius:10px;");
                    msgArea.setFocusColor(Paint.valueOf(background));
                    msgArea.setUnFocusColor(Paint.valueOf(background));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ChatBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void setMessage(){
        
        msgArea.setText(setText);
        lblTime.setText(setTime);
//        int rowCount=msgArea.getPrefRowCount();
//        if(rowCount>6){
//            msgArea.setPrefHeight(rowCount*21.5);
//            msgPane.setPrefHeight(msgPane.getPrefHeight()+(rowCount*21.5-127));
//            chatPane.setPrefHeight(chatPane.getPrefHeight()+(msgPane.getPrefHeight()+3));
//        }else{
//            msgArea.setPrefHeight(rowCount*21.5);
//            msgPane.setPrefHeight((rowCount*21.5-127));
//            chatPane.setPrefHeight((msgPane.getPrefHeight()+3));
//        }
        
    }
    
}
