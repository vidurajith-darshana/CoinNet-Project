/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.AdvertiesmentDTO;
import com.coinnet.dto.EcoAdDTO;
import com.coinnet.other.EcoAdDetail;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.CompanyService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class AdPackageController implements Initializable {

    @FXML
    private JFXButton btnEco;

    @FXML
    private JFXButton btnMed;

    @FXML
    private JFXButton btnPre;

    @FXML
    private JFXDrawer AdDrawer;

    @FXML
    private JFXDrawer editorDrawer;

    @FXML
    private JFXDrawer treeViewDrawer;

    @FXML
    private JFXDrawer paymentDrawer;

    public static JFXDrawer SET_DRAWER;
    
    private CompanyService companyService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            companyService=(CompanyService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes. COMPANY);
            
            SET_DRAWER=editorDrawer;
        } catch (Exception ex) {
            Logger.getLogger(AdPackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void ecoBtnOnAction(ActionEvent evt){
        
        try {
            if(editorDrawer.isShown()){
                editorDrawer.close();
            }
            if(paymentDrawer.isShown()){
                paymentDrawer.close();
            }
            AnchorPane containPane=new AnchorPane();
            containPane.setPrefSize(264,151);
            
            ScrollPane adPane=new ScrollPane();
            adPane.setPrefSize(264,151);
            
            FXMLLoader fxml=new FXMLLoader(getClass().getResource("/com/coinnet/view/EconomyAdvertiesment.fxml"));
            AnchorPane ad=fxml.load();
            EconomyAdvertiesmentController eco=(EconomyAdvertiesmentController)fxml.getController();
            ad.setLayoutX(50);
            containPane.getChildren().add(ad);
            
            TreeViewPaneController.ADVERTIESMENT="economy";
            TreeViewPaneController.ECONOMY_ADVERTIESMENT_CONTROLLER=eco;
            AnchorPane sidePane=FXMLLoader.load(getClass().getResource("/com/coinnet/view/TreeViewPane.fxml"));
            treeViewDrawer.setSidePane(sidePane);
            treeViewDrawer.open();
            
            Button btnFinish=new Button("Finish");
            btnFinish.setLayoutY(ad.getPrefHeight()+2);
            btnFinish.setLayoutX(50);
            
            btnFinish.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    
                    EcoAdDetail.getInstance().setAreaFamily((String)eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_FAMILY));
                    EcoAdDetail.getInstance().setAreaFontColor((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_COLOR));
                    EcoAdDetail.getInstance().setAreaFontSize((double) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_SIZE));
                    EcoAdDetail.getInstance().setAreaText((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_TEXT));
                    EcoAdDetail.getInstance().setBackImgUrl((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.PANE_IMAGE));
                    EcoAdDetail.getInstance().setImageUrl((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.IMAGE));
                    EcoAdDetail.getInstance().setIsAreaBold((boolean) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_BOLD));
                    EcoAdDetail.getInstance().setIsAreaItalic((boolean) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_ITALIC));
                    EcoAdDetail.getInstance().setIsAreaRegular((boolean) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_REG));
                    EcoAdDetail.getInstance().setIsLblItalic((boolean) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_ITALIC));
                    EcoAdDetail.getInstance().setIsLblBold((boolean) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_BOLD));
                    EcoAdDetail.getInstance().setIsLblRegular((boolean) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_REG));
                    EcoAdDetail.getInstance().setLblBackground((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_BACK));
                    EcoAdDetail.getInstance().setLblFamily((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_FAMILY));
                    EcoAdDetail.getInstance().setLblFontColor((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_COLOR));
                    EcoAdDetail.getInstance().setLblFontSize((double) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_SIZE));
                    EcoAdDetail.getInstance().setLblText((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_TEXT));
                    EcoAdDetail.getInstance().setPaneBackground((String) eco.getObjectsProperties(EconomyAdvertiesmentController.AdObjects.PANE));
                    
                    if(treeViewDrawer.isShown()){
                        treeViewDrawer.close();
                    }
                    if(AdDrawer.isShown()){
                        AdDrawer.close();
                    }
                    if(editorDrawer.isShown()){
                        editorDrawer.close();
                    }
                    AnchorPane sidePane=new AnchorPane();
                    sidePane.setPrefSize(140,151);
                    sidePane.setStyle("-fx-background-color:orange");
                    
                    Label lbl=new Label("Payement");
                    lbl.setAlignment(Pos.CENTER);
                    lbl.setPrefSize(130, 30);
                    lbl.setStyle("-fx-background-color:white;-fx-background-radius:10px");
                    lbl.setFont(Font. font("Times New Roman", FontWeight.LIGHT, FontPosture.ITALIC, 16));
                    lbl.setTextFill(Paint.valueOf("black"));
                    lbl.setLayoutX(5);
                    lbl.setLayoutY(2);
                    sidePane.getChildren().add(lbl);
                    
                    Label lbl1=new Label("Economy Advertiesment");
                    lbl1.setFont(Font. font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
                    lbl1.setLayoutX(5);
                    lbl1.setLayoutY(30);
                    sidePane.getChildren().add(lbl1);
                    
                    Label lbl2=new Label("4000 Coins");
                    lbl2.setFont(Font. font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
                    lbl2.setLayoutX(40);
                    lbl2.setLayoutY(60);
                    sidePane.getChildren().add(lbl2);
                    
                    Label lbl3=new Label("Service Type");
                    lbl3.setFont(Font. font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
                    lbl3.setLayoutX(5);
                    lbl3.setLayoutY(90);
                    sidePane.getChildren().add(lbl3);
                    
                    JFXComboBox cmb=new JFXComboBox();
                    cmb.getItems().clear();
                    cmb.getItems().add("customer");
                    cmb.getItems().add("company");
                    cmb.setLayoutX(40);
                    cmb.setLayoutY(90);
                    sidePane.getChildren().add(cmb);
                    
                    Button payBtn=new Button("Pay Here");
                    payBtn.setLayoutX(40);
                    payBtn.setLayoutY(120);
                    
                    payBtn.setOnAction(ev->{
                        
                        Date d1=new Date();
                        SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
                        String date=df1.format(d1);

                        Date d2=new Date();
                        SimpleDateFormat df2=new SimpleDateFormat("HH:mm:ss");
                        String time=df2.format(d2);
                        
//                        if(companyService.saveEcoAdvertiesement(new AdvertiesmentDTO(0,UserDetail.getInstance().getUserId(), date, time,Integer.parseInt(lbl2.getText().substring(0,(lbl2.getText().indexOf("C")-1))) , cmb.getSelectionModel().getSelectedItem().toString()), new EcoAdDTO(0, 0, EcoAdDetail.getInstance().getImageUrl(), time, date, 0, true, true, true, time, date, date, date, time, 0, time, true, true, true, date), companyDTO, bankDTO)){
//                            
//                        }
                        
                    });
                    
                    sidePane.getChildren().add(payBtn);
                    
                    paymentDrawer.setSidePane(sidePane);
                    paymentDrawer.open();
                }
            });
            
            containPane.getChildren().add(btnFinish);
            
            adPane.setContent(containPane);
            AdDrawer.setSidePane(adPane);
            AdDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(AdPackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void medBtnOnAction(ActionEvent evt){
            if(editorDrawer.isShown()){
                editorDrawer.close();
            }
        try {
            TreeViewPaneController.ADVERTIESMENT="medium";
            AnchorPane sidePane=FXMLLoader.load(getClass().getResource("/com/coinnet/view/TreeViewPane.fxml"));
            treeViewDrawer.setSidePane(sidePane);
            treeViewDrawer.open();
            
            AnchorPane containPane=new AnchorPane();
            containPane.setPrefSize(264,151);
            
            ScrollPane adPane=new ScrollPane();
            adPane.setPrefSize(264,151);
            
            AnchorPane ad=FXMLLoader.load(getClass().getResource("/com/coinnet/view/MediumAdvertiesment.fxml"));
            ad.setLayoutX(50);
            containPane.getChildren().add(ad);
            
            Button btnFinish=new Button("Finish");
            btnFinish.setLayoutY(ad.getPrefHeight()+5);
            btnFinish.setLayoutX(50);
            containPane.getChildren().add(btnFinish);
            
            adPane.setContent(containPane);
            AdDrawer.setSidePane(adPane);
            AdDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(AdPackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void preBtnOnAction(ActionEvent evt){
            if(editorDrawer.isShown()){
                editorDrawer.close();
            }
        try {
            TreeViewPaneController.ADVERTIESMENT="premium";
            AnchorPane sidePane=FXMLLoader.load(getClass().getResource("/com/coinnet/view/TreeViewPane.fxml"));
            treeViewDrawer.setSidePane(sidePane);
            treeViewDrawer.open();
            
            AnchorPane containPane=new AnchorPane();
            containPane.setPrefSize(264,151);
            
            ScrollPane adPane=new ScrollPane();
            adPane.setPrefSize(264,151);
            
            AnchorPane ad=FXMLLoader.load(getClass().getResource("/com/coinnet/view/PremiumAdvertiesment.fxml"));
            containPane.getChildren().add(ad);
            
            Button btnFinish=new Button("Finish");
            btnFinish.setLayoutY(ad.getPrefHeight()+5);
 
            containPane.getChildren().add(btnFinish);
            
            adPane.setContent(containPane);
            AdDrawer.setSidePane(adPane);
            AdDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(AdPackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
