/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.CompanyDTO;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.CompanyService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class LoginController implements Initializable {

     @FXML
    private ImageView backgroundImg;

    @FXML
    private ImageView tcktImg;

    @FXML
    private TextField txtMail;

    @FXML
    private PasswordField txtPswd;

    @FXML
    private Button btnLogin;

    @FXML
    private JFXButton btnClose;
    
    private CompanyService companyService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
             companyService=(CompanyService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.COMPANY);
             loadProperties();
             txtMail.requestFocus();
         } catch (Exception ex) {
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
    @FXML
    private void loginBtnOnAction(ActionEvent evt){
        
        login();
        
    }
    
    @FXML
    private void txtMailOnAction(ActionEvent evt){
        txtPswd.requestFocus();
    }
    
    @FXML
    private void txtPswdOnAction(ActionEvent evt){
        login();
    }
    
    @FXML
    private void closeBtnOnAction(ActionEvent evt){
        
         ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
    }
    
    private boolean checkLogin(String email,String pswd){
        if(txtMail.getText().equals("")||txtPswd.getText().equals("")){
            return false;
        }else{
            return true;
        }
    }

    private void loadProperties() {
        
        backgroundImg.setImage(new Image("com/coinnet/assets/logo-company.jpg"));
        
    }

    private void login() {
        
        if(!checkLogin(txtMail.getText(),txtPswd.getText())){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You have missed some fields!");
            alert.showAndWait();
        }else{
            try {
                
                //List<CompanyDTO> list=companyService.getAll();
                
                CompanyDTO company=companyService.getCompany(txtMail.getText(),txtPswd.getText());
                
                if(company!=null){
                    UserDetail.getInstance().setEmail(txtMail.getText());
                    UserDetail.getInstance().setPic(company.getPic());
                    UserDetail.getInstance().setServiceType(company.getServiceType());
                    UserDetail.getInstance().setUserId(company.getComID());
                    UserDetail.getInstance().setUserName(company.getName());

                    Stage primaryStage=new Stage();
                    AnchorPane root=FXMLLoader.load(getClass().getResource("/com/coinnet/view/DashBoard.fxml"));
                    primaryStage.setScene(new Scene(root));
                    primaryStage.initStyle(StageStyle.UNDECORATED);
                    primaryStage.show();
                    
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Incorrect Combination!");
                    alert.showAndWait();
                }
               
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
