/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.dto.AccountDTO;
import com.coinnet.dto.AdminDTO;
import com.coinnet.dto.DrawTicketDTO;
import com.coinnet.dto.PublishTicketDTO;
import com.coinnet.dto.TicketDTO;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
import com.coinnet.service.custom.AccountService;
import com.coinnet.service.custom.AdminService;
import com.coinnet.service.custom.CustomerService;
import com.coinnet.service.custom.DrawTicketService;
import com.coinnet.service.custom.PublishTicketService;
import com.coinnet.service.custom.TicketService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class TicketServiceController implements Initializable {

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtIntroPrice;

    @FXML
    private ImageView imgTicket;

    @FXML
    private JFXButton btnBrowse;

    @FXML
    private Button btnIntro;

    @FXML
    private JFXComboBox cmbTicket;

    @FXML
    private TextField txtTerm;

    @FXML
    private TextField txtMoney;

    @FXML
    private TextField txtPrice;

    @FXML
    private Button btnPrint;

    @FXML
    private Button btnDrawTicket;

    @FXML
    private ScrollPane ticketPane;

    @FXML
    private JFXDatePicker dtDraw;
    
    private File imgFile;
    
    private CustomerService customerService;
    private AccountService accountService;
    private TicketService ticketService;
    private PublishTicketService publishTicketService;
    private AdminService adminService;
    private DrawTicketService drawTicketService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            customerService=(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            accountService=(AccountService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ACCOUNT);
            ticketService=(TicketService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TICKET);
            publishTicketService=(PublishTicketService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PUBLISHTICKET);
            adminService=(AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
            drawTicketService=(DrawTicketService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.DRAWTICKET);
            
            loadCmbTickets();
            
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void btnBackOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/MenuPane.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Menu");
            DashBoardController.setLabel.setStyle("-fx-background-color:brown;-fx-background-radius:5px;");
        } catch (IOException ex) {
            Logger.getLogger(BankTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void btnBrowseOnAction(ActionEvent evt){
        
        try {
            FileChooser.ExtensionFilter imageFilter=new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg");
            FileChooser chooser=new FileChooser();
            chooser.getExtensionFilters().add(imageFilter);
            File file=chooser.showOpenDialog(null);
            imgFile=file;
            imgTicket.setImage(new Image(file.toURI().toURL().toString()));
        } catch (Exception ex) {
            Logger.getLogger(RegisterCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void btnPrintOnAction(ActionEvent evt){
        
        if(txtMoney.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You must give a gift price for Ticket!");
            alert.showAndWait();
        }else{
            
            Date d=new Date();
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            String date=df.format(d);
            
            try {
                List<AdminDTO> admins=adminService.getAll();
                AdminDTO adminDTO=null;
                for (AdminDTO admin : admins) {
                    if(admin.getAdminID()==UserDetail.getInstance().getUserId()){
                        adminDTO=admin;
                    }
                }
                
                String ticketName=cmbTicket.getSelectionModel().getSelectedItem().toString();
                TicketDTO ticketDTO=null;
                List<TicketDTO> tickets=ticketService.getAll();
                for (TicketDTO ticket : tickets) {
                    if(ticket.getName().equals(ticketName)){
                        ticketDTO=ticket;
                    }
                }
                
                List<PublishTicketDTO> ticketList=new ArrayList<>();
                for(int i=0;i<20;i++){
                    String numberSet="";
                    for(int j=0;j<6;j++){
                        Random rand=new Random();
                        int n=rand.nextInt(9)+1;
                        numberSet+=n;
                    }
                    ticketList.add(new PublishTicketDTO(0,ticketDTO.getTicketId(), numberSet,Integer.parseInt(txtTerm.getText()),date,Integer.parseInt(txtMoney.getText())));
                }
                
                if(publishTicketService.savePublishTicket(ticketList, ticketDTO, adminDTO)){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Ticket Printed and shared Succesfully!");
                    alert.showAndWait();
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Something went Wrong!");
                    alert.showAndWait();
                }
                
            } catch (Exception ex) {
                Logger.getLogger(TicketServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    @FXML
    private void btnDrawOnAction(ActionEvent evt){
        
        if(dtDraw.getValue().toString().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You must select date for drawing!");
            alert.showAndWait();
        }else{
            
        }
    }
    
    @FXML
    private void btnIntroOnAction(ActionEvent evt){
        if(imgFile!=null && !txtName.getText().equals("") && !txtIntroPrice.getText().equals("")){
            
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
               
                List<AdminDTO> admins=adminService.getAll();
                AdminDTO adminDTO=null;
                for (AdminDTO admin : admins) {
                    if(admin.getAdminID()==UserDetail.getInstance().getUserId()){
                        adminDTO=admin;
                    }
                }
                
                if(adminDTO!=null){
                    if(ticketService.saveImage(data,txtName.getText())){
                        if(ticketService.saveTicket(new TicketDTO(0,UserDetail.getInstance().getUserId(),txtName.getText(),Integer.parseInt(txtIntroPrice.getText()), txtName.getText()), adminDTO)){
                            Alert alert=new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText("Ticket Introducing Succesfully!");
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
    private void txtNameOnAction(ActionEvent evt){
        txtIntroPrice.requestFocus();
    }

    private void loadCmbTickets() {
        
        try {
            List<TicketDTO> tickets=ticketService.getAll();
            for (TicketDTO ticket : tickets) {
                cmbTicket.getItems().add(ticket.getName());
            }
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cmbTicketOnAction(ActionEvent evt){
        
        String ticketName=cmbTicket.getSelectionModel().getSelectedItem().toString();
        int publishId=0;
        int price=0;
        
        try {
            List<TicketDTO> tickets=ticketService.getAll();
            for (TicketDTO ticket : tickets) {
                if(ticket.getName().equals(ticketName)){
                    int ticketId=ticket.getTicketId();
                    price=ticket.getPrice();
                    
                    List<PublishTicketDTO> publish=publishTicketService.getAll();
                    for (PublishTicketDTO publishTicketDTO : publish) {
                        if(publishTicketDTO.getTicketId()==ticketId){
                            publishId=publishTicketDTO.getPublishId();
                        }
                    }
                    
                }
                
            } 
           
            txtTerm.setText(Integer.toString(publishTicketService.getNewTerm(publishId)));
            txtPrice.setText(Integer.toString(price));
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void dtOnAction(ActionEvent evt){
       String date=dtDraw.getValue().toString();
       
        try {
            List<PublishTicketDTO> tickets=publishTicketService.getAll();
            List<PublishTicketDTO> thatDayTickets=new ArrayList<>();
            for (PublishTicketDTO ticket : tickets) {
                if(ticket.getDate().equals(date)){
                    thatDayTickets.add(new PublishTicketDTO(ticket.getPublishId(),ticket.getTicketId(),ticket.getNumbers(),ticket.getTerm(),ticket.getDate(),ticket.getGiftPrice()));
                }
            }
            int count=0;
            if(!thatDayTickets.isEmpty()){
                List<DrawTicketDTO> drawTickets=drawTicketService.getAll();
                for (DrawTicketDTO drawTicket : drawTickets) {
                    for (PublishTicketDTO thatDayTicket : thatDayTickets) {
                        if(drawTicket.getPublishId()==thatDayTicket.getPublishId()){
                            count++;
                        }
                    }
                }
                if(count>0){
                    btnDrawTicket.setDisable(true);
                    loadTicketsToPane(thatDayTickets);
                }else{
                    btnDrawTicket.setDisable(false);
                    loadTicketsToPane(thatDayTickets);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void loadTicketsToPane(List<PublishTicketDTO> thatDayTickets) {
        
        AnchorPane ticketsPane=new AnchorPane();
        int x=2;
        try {
            for (PublishTicketDTO thatDayTicket : thatDayTickets) {

                AnchorPane frame=new AnchorPane();
                frame.setPrefSize(100, 93);
                frame.setLayoutX(x);
                frame.setLayoutY(3);
                frame.setStyle("-fx-background-radius:10px;-fx-background-color:white;-fx-border-color:black");

                x+=frame.getPrefWidth()+3;
                
                String title="";
                for (TicketDTO ticketDTO : ticketService.getAll()) {
                    if(thatDayTicket.getTicketId()==ticketDTO.getTicketId()){
                        title=ticketDTO.getName();
                        
                    }
                }
                Label lblTitle=new Label(title);
                lblTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
                lblTitle.setLayoutX(20);
                lblTitle.setLayoutY(10);
                
                Label lblTerm=new Label(Integer.toString(thatDayTicket.getTerm()));
                lblTerm.setLayoutX(10);
                lblTerm.setLayoutY(50);
                
                Label lblDate=new Label(thatDayTicket.getDate());
                lblDate.setLayoutX(30);
                lblDate.setLayoutY(50);
                
                frame.getChildren().add(lblTitle);
                frame.getChildren().add(lblTerm);
                frame.getChildren().add(lblDate);
                
                char[] numbers=thatDayTicket.getNumbers().toCharArray();
                int distance=14;
                for (char number : numbers) {
                    Label lblNumber=new Label(number+"");
                    lblNumber.setStyle("-fx-background-color:orange;-fx-text-fill:black;-fx-bacground-radius:5px;-fx-border-radius:5px;-fx-border-color:green");
                    lblNumber.setFont(Font.font(13));
                    lblNumber.setLayoutX(distance);
                    lblNumber.setLayoutY(80);
                    distance+=14;
                    frame.getChildren().add(lblNumber);
                }
                ticketsPane.getChildren().add(frame);

            }
            
            ticketPane.setContent(ticketsPane);
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
