/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.ChatAccountDTO;
import com.coinnet.dto.ChatDTO;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.AccountService;
import com.coinnet.service.custom.ChatAccountService;
import com.coinnet.service.custom.ChatService;
import com.coinnet.service.custom.CustomerService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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
public class FriendBoxController implements Initializable {

    @FXML
    private Circle imgCircle;

    @FXML
    private Label lblName;
    
    @FXML
    private Label lblEmail;

    @FXML
    private Label lblSignal;

    @FXML
    private Label lblSignalText;

    @FXML
    private AnchorPane pane;
    
    public static String name;
    public static String pic;
    public static String email;
    
    private CustomerService customerService;
    private ChatService chatService;
    private ChatAccountService chatAccountService;
    private AccountService accountService;
    
    private int height;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           
            customerService=(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            chatAccountService=(ChatAccountService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CHATACCOUNT);
            chatService=(ChatService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CHAT);
            accountService=(AccountService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCOUNT);
            
            lblName.setText(name);
            lblEmail.setText(email);
            
            BufferedImage img=ImageIO.read(new ByteArrayInputStream(customerService.getImage(pic)));
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(img,"png",baos);
            InputStream is=new ByteArrayInputStream(baos.toByteArray());
            
            Platform.isSupported(ConditionalFeature.SHAPE_CLIP);
            ImagePattern imgPat=new ImagePattern(new Image(is));
            imgCircle.setFill(imgPat);
       
        } catch (Exception ex) {
            Logger.getLogger(FriendBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void anchorOnMouseClicked(MouseEvent evt){
      
        try {
            
            AccountDTO account=accountService.getAccountDetail(lblEmail.getText());
            setClickBackground();
            UserDetail.getInstance().getMessagePaneController().setOppositeId(account.getAid());
            UserDetail.getInstance().getMessagePaneController().setLastClicked(account.getAid());
            
        } catch (Exception ex) {
            Logger.getLogger(FriendBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void setForOnline(){
        
        pane.setStyle("-fx-background-color:#F3675C;-fx-border-color:white;-fx-cursor:hand");
        lblSignal.setVisible(true);
        lblSignal.setStyle("-fx-background-color:lime;-fx-background-radius:20px;-fx-border-radius:20px;-fx-border-color:white");
        lblSignalText.setText("OnLine");
        lblEmail.setStyle("-fx-text-fill:white");
        lblName.setStyle("-fx-text-fill:white");
        lblSignalText.setStyle("-fx-text-fill:white");
        
    }
    
    public void setForOffline(){
        
        pane.setStyle("-fx-background-color:white;-fx-border-color:black;-fx-cursor:hand");
        lblSignal.setVisible(false);
        lblSignalText.setText("OffLine");
        lblEmail.setStyle("-fx-text-fill:black");
        lblName.setStyle("-fx-text-fill:black");
        lblSignalText.setStyle("-fx-text-fill:black");
        
    }
    
    public String getEmail(){
        return lblEmail.getText();
    }
    
    public void setAnotherClickBackground(){
        pane.setStyle("-fx-background-color:white;-fx-border-color:black;-fx-cursor:hand");
    }
    
    public void setClickBackground(){
        pane.setStyle("-fx-background-color:orange;-fx-border-color:black;-fx-cursor:hand");
    }
    
}
