/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.BankAccountDTO;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.BankAccountService;
import com.coinnet.service.custom.CustomerService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class DashBoardController implements Initializable {

    @FXML
    private JFXDrawer ecnmyDrwr;

    @FXML
    private Label lblName;

    @FXML
    private JFXDrawer mdiumDrwr;

    @FXML
    private JFXDrawer premiumDrwr;

    @FXML
    private AnchorPane containPane;
    
    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnMnmz;

    @FXML
    private Circle imgCircle;

    @FXML
    private Label lblCid;

    @FXML
    private Label lblCustName;

    @FXML
    private Label lblCoin;

    @FXML
    private Label lblSignal;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;
    
    public static AnchorPane setContainPane;
    public static AnchorPane setMainPane;
    public static Label setLabel;
    
    private CustomerService customerService;
    private BankAccountService bankAccountService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            customerService=(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            bankAccountService=(BankAccountService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCOUNTBANK);
        } catch (Exception ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setMenuPropertie();
        setDashBoard();
        setDate();
        setTime();
        
        Thread t1=new Thread(()->{
            
            setAdvertiesment1();
            
        });
        t1.start();
        
        Thread t2=new Thread(()->{
            
            setAdvertiesment2();
            
        });
        t2.start();
        
        Thread t3=new Thread(()->{
            
            setAdvertiesment3();
            
        });
        t3.start();
        
        setContainPane=containPane;
        setMainPane=mainPane;
        setLabel=lblName;
        
    }    
    @FXML
    private void closeBtnOnAction(ActionEvent evt){
        
         ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
    }
    

    private void setDate() {
        
        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(df.format(d));
    }

    private void setTime() {
        
        Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Calendar time = Calendar.getInstance();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                                    lblTime.setText(simpleDateFormat.format(time.getTime()));
                                }
                            }
                    ),
                    new KeyFrame(Duration.seconds(1))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
    }

    private void setMenuPropertie() {
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/MenuPane.fxml"));
            containPane.getChildren().addAll(box);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void minimizeBtnOnAction(ActionEvent evt){
        
        ((Stage)((JFXButton)evt.getSource()).getScene().getWindow()).setIconified(true);
    }

    private void setAdvertiesment1() {
        
        for(int i=0;i<10;i++){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        try {
                            AnchorPane sidePane1=FXMLLoader.load(getClass().getResource("/com/coinnet/view/EconomyAdvertiesment.fxml"));
                            ecnmyDrwr.setSidePane(sidePane1);
                            ecnmyDrwr.open();
                        } catch (IOException ex) {
                            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                Thread.sleep(8000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setAdvertiesment2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<10;i++){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        try {
                            AnchorPane sidePane2=FXMLLoader.load(getClass().getResource("/com/coinnet/view/PremiumAdvertiesment.fxml"));
                            premiumDrwr.setSidePane(sidePane2);
                            premiumDrwr.open();
                        } catch (IOException ex) {
                            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                Thread.sleep(8000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setAdvertiesment3() {
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<10;i++){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        try {
                            AnchorPane sidePane3=FXMLLoader.load(getClass().getResource("/com/coinnet/view/MediumAdvertiesment.fxml"));
                            mdiumDrwr.setSidePane(sidePane3);
                            mdiumDrwr.open();
                        } catch (IOException ex) {
                            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                Thread.sleep(8000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setDashBoard() {
        
        try {
            lblCid.setText(Integer.toString(UserDetail.getInstance().getUserId()));
            lblCustName.setText(UserDetail.getInstance().getName());
            
            BufferedImage img=ImageIO.read(new ByteArrayInputStream(customerService.getImage(UserDetail.getInstance().getPic())));
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(img,"png",baos);
            InputStream is=new ByteArrayInputStream(baos.toByteArray());
            
            Platform.isSupported(ConditionalFeature.SHAPE_CLIP);
            ImagePattern imgPat=new ImagePattern(new Image(is));
            imgCircle.setFill(imgPat);
            
            int coins=0;
            List<BankAccountDTO> list=bankAccountService.getAll();
            for (BankAccountDTO bankAccountDTO : list) {
                if(bankAccountDTO.getAid()==UserDetail.getInstance().getAccountId()){
                    if(bankAccountDTO.getTransaction_type().equals("deposite")){
                        coins+=bankAccountDTO.getAmount();
                    }else{
                        coins-=bankAccountDTO.getAmount();
                    }
                }
            }
            
            lblCoin.setText(Integer.toString(coins));
            
        } catch (Exception ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
