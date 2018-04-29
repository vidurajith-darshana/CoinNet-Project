/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.coinnet.observable.custom.ChatObservable;
import com.coinnet.observer.custom.ChatObserver;
import com.coinnet.other.UserDetail;
import com.coinnet.proxy.ProxyHandler;
import com.coinnet.service.ServiceFactory;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class CoinNetSocityController implements Initializable {

    @FXML
    private JFXButton btnBack;

    @FXML
    private TabPane tbPne;

    @FXML
    private Tab tbFriend;

    @FXML
    private AnchorPane friendPane;

    @FXML
    private ScrollPane friendDetailPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private Tab tbFriendChat;

    @FXML
    private AnchorPane friendChatPane;

    @FXML
    private Tab tbNotify;

    @FXML
    private AnchorPane notifiPane;

    @FXML
    private ScrollPane notificationPane;

    @FXML
    private Tab tbWorld;

    @FXML
    private AnchorPane worldPane;

    @FXML
    private ScrollPane worldDetailPane;

    @FXML
    private Tab tbAdmin;

    @FXML
    private AnchorPane adminPane;

    @FXML
    private ScrollPane chatAdminsPane;

    @FXML
    private ScrollPane AdminChatPane;

    @FXML
    private Tab tbCompany;

    @FXML
    private AnchorPane companyPane;

    @FXML
    private ScrollPane chatCompaniesPane;

    @FXML
    private ScrollPane companyChatPane;

    @FXML
    private Label lblMessages;

    @FXML
    private Label lblNotification;
    
    private ChatObservable chatObservable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            chatObservable=(ChatObservable) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CHAT);
            
            tbFriendChat.setOnSelectionChanged(e->{
                try {
                    FXMLLoader fxml=new FXMLLoader(getClass().getResource("/com/coinnet/view/MessagePane.fxml"));
                    AnchorPane box=fxml.load();
                    UserDetail.getInstance().setMessagePaneController(fxml.getController());
                    friendChatPane.getChildren().setAll(box);
                } catch (IOException ex) {
                    Logger.getLogger(CoinNetSocityController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(CoinNetSocityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    @FXML
    private void btnBackOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/coinnet/view/MenuPane.fxml"));
            DashBoardController.setContainPane.getChildren().setAll(box);
            DashBoardController.setLabel.setText("Menu");
            DashBoardController.setLabel.setStyle("-fx-background-color:brown;-fx-background-radius:5px;");
            
            chatObservable.unRegisterObserver(UserDetail.getInstance().getAccountId());
        } catch (Exception ex) {
            Logger.getLogger(BankTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
