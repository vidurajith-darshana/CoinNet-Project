/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.AdminDTO;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.AdminService;
import com.jfoenix.controls.JFXButton;
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
    private ImageView imgAdmin;

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
    
    private AdminService adminService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            loadProperties();
            txtMail.requestFocus();
            adminService=(AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    @FXML
    private void loginBtnOnAction(ActionEvent evt){
        
        if(!checkLogin(txtMail.getText(),txtPswd.getText())){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Incorrect Combination.Try Again!");
            alert.showAndWait();
        }else{
            try {
                
                AdminDTO adminDTO=adminService.getAdminDetail(txtMail.getText(),txtPswd.getText());
                UserDetail.getInstance().setEmail(adminDTO.getEmail());
                UserDetail.getInstance().setName(adminDTO.getName());
                UserDetail.getInstance().setPic(adminDTO.getPic());
                UserDetail.getInstance().setUserId(adminDTO.getAdminID());
                
                FXMLLoader fxml=new FXMLLoader(getClass().getResource("/com/coinnet/view/DashBoard.fxml"));
                AnchorPane root=fxml.load();
                Stage stage=new Stage();
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.showAndWait();
            } catch (Exception ex) {
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
        loginBtnOnAction(evt);
    }
    
    @FXML
    private void closeBtnOnAction(ActionEvent evt){
        
         ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
    }
    
    private boolean checkLogin(String email,String pswd){
        if(txtMail.getText().equals("")||txtPswd.getText().equals("")){
            return false;
        }else{
            boolean result=false;
            try {
                result= adminService.checkLogin(email, pswd);
                
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
    }

    private void loadProperties() {
        
        backgroundImg.setImage(new Image("com/coinnet/assets/logo-company.jpg"));
        tcktImg.setImage(new Image("com/coinnet/assets/tickets_thd.png"));
        imgAdmin.setImage(new Image("com/coinnet/assets/admin.png"));
    }
    
}
