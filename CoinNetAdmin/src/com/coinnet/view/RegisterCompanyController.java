/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.BankCompanyDTO;
import com.coinnet.dto.BankDTO;
import com.coinnet.dto.CompanyDTO;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.AdminService;
import com.coinnet.service.custom.BankService;
import com.coinnet.service.custom.CompanyService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
public class RegisterCompanyController implements Initializable {

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private Label lblCid;

    @FXML
    private Label lblAid;

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
    private Button btnUpload;

    @FXML
    private ImageView imgPic;

    @FXML
    private JFXButton btnSelect;

    @FXML
    private JFXComboBox cmbService;
    
    private File imgFile;
    
    private CompanyService companyService;
    private BankService bankService;
    private AdminService adminService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cmbService.getItems().clear();
        cmbService.getItems().add("Customer");
        cmbService.getItems().add("Company");
        try {
            companyService= (CompanyService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.COMPANY);
            adminService=(AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
            bankService=(BankService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BANK);
        
        } catch (Exception ex) {
            Logger.getLogger(RegisterCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void comNameOnAction(ActionEvent evt){
        txtAddress.requestFocus();
    }
    
    @FXML
    private void addressOnAction(ActionEvent evt){
        txtContact.requestFocus();
    }
    
    @FXML
    private void contactOnAction(ActionEvent evt){
        cmbService.requestFocus();
    }
    
    @FXML
    private void cmbOnAction(ActionEvent evt){
        txtEmail.requestFocus();
    }
    @FXML
    private void emailOnAction(ActionEvent evt){
        txtPassword.requestFocus();
    }
    
    @FXML
    private void passwordOnAction(ActionEvent evt){
        txtPayment.requestFocus();
    }
    
    @FXML
    private void txtPaymentOnAction(ActionEvent evt){
        registerCompany();
    }
    
    @FXML
    private void registerBtnOnAction(ActionEvent evt){
        
        registerCompany();
    }

    private void registerCompany() {
        
        Date d1=new Date();
        SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        String date=df1.format(d1);
        
        Date d2=new Date();
        SimpleDateFormat df2=new SimpleDateFormat("HH:mm:ss");
        String time=df2.format(d2);
        
        if(txtAddress.getText().equals("") ||txtContact.getText().equals("") ||txtEmail.getText().equals("") ||txtName.getText().equals("") ||txtPassword.getText().equals("") ||txtPayment.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed some fields");
            alert.showAndWait();
        }else{
            CompanyDTO companyDTO=new CompanyDTO(0,txtName.getText(),txtAddress.getText(),txtContact.getText(),txtEmail.getText(),txtPassword.getText(),Integer.parseInt(txtPayment.getText())*5, cmbService.getSelectionModel().getSelectedItem().toString(),"");
            BankCompanyDTO bankCompanyDTO=new BankCompanyDTO(0,1, 0, companyDTO.getPayment(),"Deposit", date, time);
            
            try {
                
                BankDTO bankDTO=null;
                for (BankDTO bankDTO1 : bankService.getAll()) {
                    if(bankDTO1.getBid()==1){
                        bankDTO=bankDTO1;
                    }
                }
                
                List<AdminDTO> adminList=adminService.getAll();
                
                if(companyService.saveCompany(companyDTO, bankCompanyDTO,bankDTO,adminList)){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Company Registration Successfully!");
                    alert.showAndWait();
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Company Registration Failed!");
                    alert.showAndWait();
                }
            } catch (Exception ex) {
                Logger.getLogger(RegisterCompanyController.class.getName()).log(Level.SEVERE, null, ex);
            }
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

                CompanyDTO company=companyService.getUserDetail(txtUpload.getText());
                if(company!=null){
                    companyService.saveImage(data,txtUpload.getText());
                    if(companyService.updateImage(txtUpload.getText(),company.getComID())){
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Image uploaded Succesfully!");
                        alert.showAndWait();
                    }

                }
                
            } catch (Exception ex) {
               
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
