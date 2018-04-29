/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeView;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Vidurajith
 */
public class TreeViewPaneController implements Initializable {

    @FXML
    private JFXTreeView<String> treeView;
    
    public static String ADVERTIESMENT;
    public static EconomyAdvertiesmentController ECONOMY_ADVERTIESMENT_CONTROLLER;
    
    private JFXComboBox familyCombo=new JFXComboBox();
    private JFXComboBox sizeCombo=new JFXComboBox();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for ( int i = 4; i < fonts.length; i++ ){
            familyCombo.getItems().add(fonts[i]);
        }
        
        for(int i=1;i<97;i++){
            sizeCombo.getItems().add(i);
        }
        
        ImageView backgroundIcon=new ImageView(new Image("com/coinnet/assets/icon-back.png"));
        backgroundIcon.setFitWidth(30);
        backgroundIcon.setFitHeight(30);
        
        ImageView backgroundColor=new ImageView(new Image("com/coinnet/assets/icon-color.png"));
        backgroundColor.setFitWidth(30);
        backgroundColor.setFitHeight(30);
        
        ImageView backgroundImage=new ImageView(new Image("com/coinnet/assets/icon-image.png"));
        backgroundImage.setFitWidth(30);
        backgroundImage.setFitHeight(30);
        
        ImageView fontImage=new ImageView(new Image("com/coinnet/assets/icon-font.png"));
        fontImage.setFitWidth(30);
        fontImage.setFitHeight(30);
        
        ImageView sizeImage=new ImageView(new Image("com/coinnet/assets/icon-size.png"));
        sizeImage.setFitWidth(30);
        sizeImage.setFitHeight(30);
        
        ImageView boldImage=new ImageView(new Image("com/coinnet/assets/icon-bold.png"));
        boldImage.setFitWidth(30);
        boldImage.setFitHeight(30);
        
        ImageView ItalicImage=new ImageView(new Image("com/coinnet/assets/icon-italic.png"));
        ItalicImage.setFitWidth(30);
        ItalicImage.setFitHeight(30);
        
        ImageView wordImage=new ImageView(new Image("com/coinnet/assets/icon-word.png"));
        wordImage.setFitWidth(30);
        wordImage.setFitHeight(30);
        
        ImageView familyImage=new ImageView(new Image("com/coinnet/assets/icon-family.png"));
        familyImage.setFitWidth(30);
        familyImage.setFitHeight(30);
        
        ImageView regularImage=new ImageView(new Image("com/coinnet/assets/icon-regular.png"));
        regularImage.setFitWidth(30);
        regularImage.setFitHeight(30);
        
        TreeItem<String> root=new TreeItem<>("");
        
        
        TreeItem<String> background=new TreeItem<>("Background",backgroundIcon);
        TreeItem<String> backgroundColour=new TreeItem<>("Colour",backgroundColor);
        TreeItem<String> backgroundImages=new TreeItem<>("Image",backgroundImage);
       
        background.getChildren().addAll(backgroundColour,backgroundImages);
        root.getChildren().add(background);
        
        TreeItem<String> image=new TreeItem<>("Image",backgroundImage);    
        
        if(ADVERTIESMENT.equals("economy")){
            
            TreeItem<String> textCap=new TreeItem<>("Text",wordImage);
            TreeItem<String> fontColourCap=new TreeItem<>("Colour",backgroundColor);
            TreeItem<String> fontSizeCap=new TreeItem<>("Size",sizeImage);
            TreeItem<String> fontBoldCap=new TreeItem<>("Bold",boldImage);
            TreeItem<String> fontItalicCap=new TreeItem<>("Italic",ItalicImage);
            TreeItem<String> fontRegularCap=new TreeItem<>("Regular",regularImage);
            TreeItem<String> fontFamilyCap=new TreeItem<>("Family",familyImage);

            TreeItem<String> captionWord=new TreeItem<>("Caption",fontImage);
            TreeItem<String> captionBack=new TreeItem<>("Background",backgroundImage);
            captionWord.getChildren().addAll(textCap,fontColourCap,fontSizeCap,fontBoldCap,fontItalicCap,fontRegularCap,fontFamilyCap,captionBack);

            root.getChildren().add(captionWord);
            
            TreeItem<String> textPara=new TreeItem<>("Text",wordImage);
            TreeItem<String> fontColourPara=new TreeItem<>("Colour",backgroundColor);
            TreeItem<String> fontSizePara=new TreeItem<>("Size",sizeImage);
            TreeItem<String> fontBoldPara=new TreeItem<>("Bold",boldImage);
            TreeItem<String> fontItalicPara=new TreeItem<>("Italic",ItalicImage);
            TreeItem<String> fontRegularPara=new TreeItem<>("Regular",regularImage);
            TreeItem<String> fontFamilyPara=new TreeItem<>("Family",familyImage);
            
            TreeItem<String> paraWord=new TreeItem<>("Paragraph",fontImage);
            paraWord.getChildren().addAll(textPara,fontColourPara,fontSizePara,fontBoldPara,fontItalicPara,fontRegularPara,fontFamilyPara);
            root.getChildren().add(paraWord);
            
            TreeItem<String> image1=new TreeItem<>("Image1",backgroundImage); 
            image.getChildren().add(image1);
            
        }else if(ADVERTIESMENT.equals("medium")){
            
//            TreeItem<String> word1=new TreeItem<>("Word1",fontImage);
//            TreeItem<String> word2=new TreeItem<>("Word2",fontImage);
//            TreeItem<String> word3=new TreeItem<>("Word3",fontImage);
//            
////            words.getChildren().addAll(captionWord,word1,word2,word3);
//            
//            word1.getChildren().addAll(fontColour,fontSize,fontBold,fontItalic,fontRegular,fontFamily,captionBack);
//            word2.getChildren().addAll(fontColour,fontSize,fontBold,fontItalic,fontRegular,fontFamily,captionBack);
//            word3.getChildren().addAll(fontColour,fontSize,fontBold,fontItalic,fontRegular,fontFamily,captionBack);
//            
//            root.getChildren().add(word1);
//            root.getChildren().add(word2);
//            root.getChildren().add(word3);
//            
//            
//            TreeItem<String> image1=new TreeItem<>("Image1",backgroundImage); 
//            TreeItem<String> image2=new TreeItem<>("Image2",backgroundImage); 
//            image.getChildren().addAll(image1,image2);
            
        }else{
//            TreeItem<String> word1=new TreeItem<>("Word1",fontImage);
//            TreeItem<String> word2=new TreeItem<>("Word2",fontImage);
//            TreeItem<String> footer=new TreeItem<>("Footer",fontImage);
//            
//            
//            
////            words.getChildren().addAll(captionWord,word1,word2,footer);
//            
//            word1.getChildren().addAll(fontColour,fontSize,fontBold,fontItalic,fontRegular,fontFamily,captionBack);
//            word2.getChildren().addAll(fontColour,fontSize,fontBold,fontItalic,fontRegular,fontFamily,captionBack);
//            footer.getChildren().addAll(fontColour,fontSize,fontBold,fontItalic,fontRegular,fontFamily,captionBack);
//            
//            root.getChildren().add(captionWord);
//            root.getChildren().add(word1);
//            root.getChildren().add(word2);
//            root.getChildren().add(footer);
//            
//            TreeItem<String> image1=new TreeItem<>("Image1",backgroundImage); 
//            TreeItem<String> image2=new TreeItem<>("Image2",backgroundImage); 
//            TreeItem<String> image3=new TreeItem<>("Image3",backgroundImage); 
//            image.getChildren().addAll(image1,image2,image3);
        }
        
        root.getChildren().add(image);
        
        treeView.setRoot(root);
        treeView.setShowRoot(false);
        
    }    
    
    @FXML
    private void treeViewOnMouseClick(MouseEvent evt){
        if(ADVERTIESMENT.equals("economy")){
            try{
                if(treeView.getSelectionModel().getSelectedItem().getParent().getValue().equals("Background")){
                    if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Colour")){
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");

                        ColorPicker colorPick=new ColorPicker();
                        colorPick.setLayoutX(35);
                        colorPick.setLayoutY(55);

                        colorPick.setOnAction(e->{
                            String colorVal=colorPick.getValue().toString();
                            char[] colorContent=colorVal.substring(2).toCharArray();
                            String color="#";
                            for(int i=0;i<colorContent.length-2;i++){
                                color+=colorContent[i];
                            }
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.PANE, new Object[]{color});

                        });

                        sidePane.getChildren().add(colorPick);

                        Label lbl=new Label("Select Background Color");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                    }else{
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");

                        Button btn=new Button("Choose");
                        btn.setLayoutX(65);
                        btn.setLayoutY(55);
                        
                        btn.setOnAction(e->{
                            
                            try {
                                FileChooser.ExtensionFilter imageFilter=new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg");
                                FileChooser chooser=new FileChooser();
                                chooser.getExtensionFilters().add(imageFilter);
                                File file=chooser.showOpenDialog(null);
                               
                                ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.PANE_IMAGE, new Object[]{file.toURI().toURL().toString()});

                            } catch (Exception ex) {
                               // Logger.getLogger(TreeViewPaneController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        });

                        sidePane.getChildren().add(btn);

                        Label lbl=new Label("Select Image From Your PC");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                    }
                }else if(treeView.getSelectionModel().getSelectedItem().getParent().getValue().equals("Caption")){
                    if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Colour")){
                        
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");

                        ColorPicker colorPick=new ColorPicker();
                        colorPick.setLayoutX(35);
                        colorPick.setLayoutY(55);

                        colorPick.setOnAction(e->{
                            String colorVal=colorPick.getValue().toString();
                            char[] colorContent=colorVal.substring(2).toCharArray();
                            String color="#";
                            for(int i=0;i<colorContent.length-2;i++){
                                color+=colorContent[i];
                            }
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_COLOR, new Object[]{color});

                        });

                        sidePane.getChildren().add(colorPick);

                        Label lbl=new Label("Select Background Color");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                        
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Size")){
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                        sizeCombo.setLayoutX(35);
                        sizeCombo.setLayoutY(55);
                        sizeCombo.setStyle("-fx-base-color:white");
                        sizeCombo.setPromptText("Select Size");
                        sizeCombo.setOnAction(e->{
                            double size=Double.parseDouble(sizeCombo.getSelectionModel().getSelectedItem().toString());
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_SIZE, new Object[]{size});
                        });
                        
                        sidePane.getChildren().add(sizeCombo);
                        
                        Label lbl=new Label("Select Font Size");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Bold")){
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                        Button btn=new Button("B");
                        btn.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 18));
                        btn.setLayoutX(75);
                        btn.setLayoutY(55);
                        
                        btn.setOnAction(e->{
                            
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_BOLD, new Object[]{"Times New Roman",18.0});
                        });
                        
                        sidePane.getChildren().add(btn);
                        
                        Label lbl=new Label("Select Font Bold");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Italic")){
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                        Button btn=new Button("I");
                        btn.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 18));
                        btn.setLayoutX(75);
                        btn.setLayoutY(55);
                        
                        btn.setOnAction(e->{
                            
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_ITALIC, new Object[]{"Times New Roman",18.0});
                        });
                        
                        sidePane.getChildren().add(btn);
                        
                        Label lbl=new Label("Select Font Italic");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Regular")){
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                        Button btn=new Button("R");
                        btn.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 18));
                        btn.setLayoutX(75);
                        btn.setLayoutY(55);
                        
                        btn.setOnAction(e->{
                            
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_REG, new Object[]{"Times New Roman",18.0});
                        });
                        
                        sidePane.getChildren().add(btn);
                        
                        Label lbl=new Label("Select Font Regular");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Family")){
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                       
                        familyCombo.setLayoutX(1);
                        familyCombo.setLayoutY(55);
                        familyCombo.setStyle("-fx-base-color:white");
                        familyCombo.setPromptText("Select Family");
                        familyCombo.setOnAction(e->{
                            String family=familyCombo.getSelectionModel().getSelectedItem().toString();
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_FONT_FAMILY, new Object[]{family,18.0});
                        });
                        
                        sidePane.getChildren().add(familyCombo);
                        
                        Label lbl=new Label("Select Font Family");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Background")){
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");

                        ColorPicker colorPick=new ColorPicker();
                        colorPick.setLayoutX(35);
                        colorPick.setLayoutY(55);

                        colorPick.setOnAction(e->{
                            String colorVal=colorPick.getValue().toString();
                            char[] colorContent=colorVal.substring(2).toCharArray();
                            String color="#";
                            for(int i=0;i<colorContent.length-2;i++){
                                color+=colorContent[i];
                            }
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_BACK, new Object[]{color});

                        });

                        sidePane.getChildren().add(colorPick);

                        Label lbl=new Label("Select Background Color");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Text")){
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                       
                        TextField text=new TextField();
                        text.setLayoutX(0);
                        text.setLayoutY(35);
                        text.setPrefSize(187,20);
                        
                        sidePane.getChildren().add(text);
                        
                        Label lbl=new Label("Write Caption");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(4);
                        sidePane.getChildren().add(lbl);
                        
                        Button btn=new Button("OK");
                        btn.setLayoutX(65);
                        btn.setLayoutY(73);
                        sidePane.getChildren().add(btn);
                        
                        btn.setOnAction(e->{
                            String text1=text.getText();
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.LABEL_TEXT, new Object[]{text1});
                        });

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                       
                    }
                }else if(treeView.getSelectionModel().getSelectedItem().getParent().getValue().equals("Paragraph")){
                    if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Colour")){
                        
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");

                        ColorPicker colorPick=new ColorPicker();
                        colorPick.setLayoutX(35);
                        colorPick.setLayoutY(55);

                        colorPick.setOnAction(e->{
                            String colorVal=colorPick.getValue().toString();
                            char[] colorContent=colorVal.substring(2).toCharArray();
                            String color="#";
                            for(int i=0;i<colorContent.length-2;i++){
                                color+=colorContent[i];
                            }
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_COLOR, new Object[]{color});

                        });

                        sidePane.getChildren().add(colorPick);

                        Label lbl=new Label("Select Background Color");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                        
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Size")){
                        
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                        sizeCombo.setLayoutX(35);
                        sizeCombo.setLayoutY(55);
                        sizeCombo.setStyle("-fx-base-color:white");
                        sizeCombo.setPromptText("Select Size");
                        sizeCombo.setOnAction(e->{
                            double size=Double.parseDouble(sizeCombo.getSelectionModel().getSelectedItem().toString());
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_SIZE, new Object[]{size});
                        });
                        
                        sidePane.getChildren().add(sizeCombo);
                        
                        Label lbl=new Label("Select Font Size");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                        
                        
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Bold")){
                        
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                        Button btn=new Button("B");
                        btn.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 18));
                        btn.setLayoutX(75);
                        btn.setLayoutY(55);
                        
                        btn.setOnAction(e->{
                            
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_BOLD, new Object[]{"Times New Roman",18.0});
                        });
                        
                        sidePane.getChildren().add(btn);
                        
                        Label lbl=new Label("Select Font Bold");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                        
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Italic")){
                        
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                        Button btn=new Button("I");
                        btn.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 18));
                        btn.setLayoutX(75);
                        btn.setLayoutY(55);
                        
                        btn.setOnAction(e->{
                            
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_ITALIC, new Object[]{"Times New Roman",18.0});
                        });
                        
                        sidePane.getChildren().add(btn);
                        
                        Label lbl=new Label("Select Font Italic");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                        
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Regular")){
                        
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                        Button btn=new Button("R");
                        btn.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 18));
                        btn.setLayoutX(75);
                        btn.setLayoutY(55);
                        
                        btn.setOnAction(e->{
                            
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_REG, new Object[]{"Times New Roman",18.0});
                        });
                        
                        sidePane.getChildren().add(btn);
                        
                        Label lbl=new Label("Select Font Regular");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                        
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Family")){
                        
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                       
                        familyCombo.setLayoutX(1);
                        familyCombo.setLayoutY(55);
                        familyCombo.setStyle("-fx-base-color:white");
                        familyCombo.setPromptText("Select Family");
                        familyCombo.setOnAction(e->{
                            String family=familyCombo.getSelectionModel().getSelectedItem().toString();
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_FONT_FAMILY, new Object[]{family,18.0});
                        });
                        
                        sidePane.getChildren().add(familyCombo);
                        
                        Label lbl=new Label("Select Font Family");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(10);
                        sidePane.getChildren().add(lbl);

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                        
                    }else if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Text")){
                        
                        AnchorPane sidePane=new AnchorPane();
                        sidePane.setPrefHeight(102);
                        sidePane.setPrefWidth(187);
                        sidePane.setStyle("-fx-background-color:gray");
                        
                       
                        TextArea text=new TextArea();
                        text.setLayoutX(0);
                        text.setLayoutY(35);
                        text.setPrefSize(187,30);
                        
                        sidePane.getChildren().add(text);
                        
                        Label lbl=new Label("Write Paragraph");
                        lbl.setFont(Font.font(14));
                        lbl.setPrefSize(170, 20);
                        lbl.setAlignment(Pos.CENTER);
                        lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                        lbl.setLayoutX(10);
                        lbl.setLayoutY(4);
                        sidePane.getChildren().add(lbl);
                        
                        Button btn=new Button("OK");
                        btn.setLayoutX(65);
                        btn.setLayoutY(73);
                        sidePane.getChildren().add(btn);
                        
                        btn.setOnAction(e->{
                            String text1=text.getText();
                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.TEXTAREA_TEXT, new Object[]{text1});
                        });

                        AdPackageController.SET_DRAWER.setSidePane(sidePane);
                        AdPackageController.SET_DRAWER.open();
                        
                    }
                }else if(treeView.getSelectionModel().getSelectedItem().getParent().getValue().equals("Image")){
                    AnchorPane sidePane=new AnchorPane();
                    sidePane.setPrefHeight(102);
                    sidePane.setPrefWidth(187);
                    sidePane.setStyle("-fx-background-color:gray");

                    Button btn=new Button("Choose");
                    btn.setLayoutX(65);
                    btn.setLayoutY(55);

                    btn.setOnAction(e->{

                        try {
                            FileChooser.ExtensionFilter imageFilter=new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg");
                            FileChooser chooser=new FileChooser();
                            chooser.getExtensionFilters().add(imageFilter);
                            File file=chooser.showOpenDialog(null);

                            ECONOMY_ADVERTIESMENT_CONTROLLER.setObjectsProperties(EconomyAdvertiesmentController.AdObjects.IMAGE, new Object[]{file.toURI().toURL().toString()});

                        } catch (MalformedURLException ex) {
                           // Logger.getLogger(TreeViewPaneController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });

                    sidePane.getChildren().add(btn);

                    Label lbl=new Label("Select Image From Your PC");
                    lbl.setFont(Font.font(14));
                    lbl.setPrefSize(170, 20);
                    lbl.setAlignment(Pos.CENTER);
                    lbl.setStyle("-fx-text-fill:black;-fx-background-color:orange;-fx-background-radius:5");
                    lbl.setLayoutX(10);
                    lbl.setLayoutY(10);
                    sidePane.getChildren().add(lbl);

                    AdPackageController.SET_DRAWER.setSidePane(sidePane);
                    AdPackageController.SET_DRAWER.open();
                }
            }catch(Exception ex){
                
            }
        }
    }
    
}
