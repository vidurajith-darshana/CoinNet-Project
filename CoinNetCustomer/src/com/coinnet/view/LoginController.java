/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.AccountService;
import com.coinnet.service.custom.CustomerService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
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

    @FXML
    private ImageView imgClose;

    private AccountService accountService;
    private CustomerService customerService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            accountService=(AccountService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCOUNT);
            customerService=(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            loadProperties();
            txtMail.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    @FXML
    private void loginBtnOnAction(ActionEvent evt){
        
        if(!login(txtMail.getText(),txtPswd.getText())){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Something Went Wrong!");
            alert.showAndWait();
        }else{
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/DashBoard.fxml"));
                Stage stage=new Stage(StageStyle.UNDECORATED);
                stage.setScene(new Scene(box));
                stage.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @FXML
    private void txtMailOnAction(ActionEvent evt){
        txtPswd.requestFocus();
    }
    
    @FXML
    private void txtPswdOnAction(ActionEvent evt){
        if(!login(txtMail.getText(),txtPswd.getText())){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Something Went Wrong!");
            alert.showAndWait();
        }else{
            try {
                AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/DashBoard.fxml"));
                Stage stage=new Stage(StageStyle.UNDECORATED);
                stage.setScene(new Scene(box));
                stage.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        tcktImg.setImage(new Image("com/coinnet/assets/tickets_thd.png"));
    }
    
    private boolean login(String email,String password){
        
        if(checkLogin(email, password)){
            try {
                AccountDTO accountDTO=accountService.getAccountDetail(email, password);
                if(accountDTO!=null){
                    CustomerDTO customerDTO=customerService.getUserDetail(accountDTO.getCid());
                    if(customerDTO!=null){
                        
                        UserDetail.getInstance().setUserId(customerDTO.getCid());
                        UserDetail.getInstance().setAccountId(accountDTO.getAid());
                        UserDetail.getInstance().setContact(customerDTO.getContact());
                        UserDetail.getInstance().setEmail(accountDTO.getEmail());
                        UserDetail.getInstance().setName(customerDTO.getName());
                        UserDetail.getInstance().setPic(customerDTO.getPic());
                        
                        return true;  
                    }
                    
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }
    
}
