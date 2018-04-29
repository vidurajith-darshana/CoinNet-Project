/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CustomerBankDTO;
import com.coinnet.dto.CustomerDTO;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.AccountService;
import com.coinnet.service.custom.BankService;
import com.coinnet.service.custom.CustomerService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class RegisterCustomerController implements Initializable {

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtBdy;

    @FXML
    private Label lblCid;

    @FXML
    private Label lblAid;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtPayment;

    @FXML
    private Button btnReg;

    @FXML
    private TextField txtUpload;

    @FXML
    private Button btnUpdate;

    @FXML
    private ImageView imgPic;

    @FXML
    private JFXButton btnSelect;
    
    private File imgFile;
    
    private CustomerService customerService;
    private AccountService accountService;
    private BankService bankService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        try {
            bankService=(BankService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BANK);
            customerService=(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            accountService=(AccountService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCOUNT);
        } catch (Exception ex) {
            Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void txtContactOnAction(ActionEvent evt){
        txtEmail.requestFocus();
    }
    
    @FXML
    private void txtNameOnAction(ActionEvent evt){
        txtAddress.requestFocus();
    }
    
    @FXML
    private void txtAddressOnAction(ActionEvent evt){
        txtBdy.requestFocus();
    }
    
    @FXML
    private void txtBdayOnAction(ActionEvent evt){
        txtContact.requestFocus();
    }
    
    @FXML
    private void txtMailOnAction(ActionEvent evt){
        txtPassword.requestFocus();
    }
    
    @FXML
    private void txtPasswordOnAction(ActionEvent evt){
        txtPayment.requestFocus();
    }
    
    @FXML
    private void txtPaymentOnAction(ActionEvent evt){
        registerCustomer();
    }
    
    @FXML
    private void regBtnOnAction(ActionEvent evt){
        
        registerCustomer();
        
    }

    private void registerCustomer() {
        
        Date d1=new Date();
        SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        String date=df1.format(d1);
        
        Date d2=new Date();
        SimpleDateFormat df2=new SimpleDateFormat("HH:mm:ss");
        String time=df2.format(d2);
        
        try {
            BankDTO bankDTO=null;
            List<BankDTO> banks=bankService.getAll();
            for (BankDTO bank : banks) {
                if(bank.getBid()==1){
                    bankDTO=bank;
                }
            }
            if(customerService.saveCustomer(new CustomerDTO(1, txtName.getText(),txtAddress.getText(),txtBdy.getText(),txtContact.getText(),""), new AccountDTO(0, 0,txtEmail.getText(),txtPassword.getText(), Integer.parseInt(txtPayment.getText())), new CustomerBankDTO(0, 0, 1,Integer.parseInt(txtPayment.getText())*5, "deposite", date, time),bankDTO)){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Customer Registered Successfully!");
                alert.showAndWait();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Customer Registered Failed!");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnUploadOnAction(ActionEvent evt){
        
        if(imgFile!=null){
            
            try {
                String path=imgFile.getAbsolutePath();
                BufferedImage img=ImageIO.read(new File(path));
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                ImageIO.write(img,"jpg", baos);
                baos.flush();
                byte[] imgq=baos.toByteArray();
                //baos.close();
                
                FileOutputStream out=new FileOutputStream(imgFile);
                byte[] data=imgq;
                
                out.write(data);
                out.flush();
                out.close();
               
                AccountDTO account=accountService.getAccountDetail(txtUpload.getText());
                if(account!=null){
                    if(customerService.saveImage(data,txtUpload.getText())){
                        if(customerService.updateImage(txtUpload.getText(),account.getCid())){
                            Alert alert=new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText("Image uploaded Succesfully!");
                            alert.showAndWait();
                        }
                    }
                }
              
            } catch (Exception ex) {
                ex.printStackTrace();
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Something went wrong..Try Again!");
                alert.showAndWait();
            }
            
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You must select an image file");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void btnSelectOnAction(ActionEvent evt){
        
        try {
            FileChooser.ExtensionFilter imageFilter=new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg");
            FileChooser chooser=new FileChooser();
            chooser.getExtensionFilters().add(imageFilter);
            File file=chooser.showOpenDialog(null);
            imgFile=file;
            imgPic.setImage(new Image(file.toURI().toURL().toString()));
        } catch (Exception ex) {
            Logger.getLogger(RegisterCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
