/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.view;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class EconomyAdvertiesmentController implements Initializable {

    @FXML
    private AnchorPane containPane;

    @FXML
    private ImageView image;
    
    @FXML
    private ImageView backImg;

    @FXML
    private JFXTextArea txtArea;

    @FXML
    private Label lblText;
    
    private String backImgPath;
    private String imgPath;
    
    private boolean isBold_TextArea;
    private boolean isItalic_TextArea;
    private boolean isRegular_TextArea;
    
    private boolean isBold_Label;
    private boolean isItalic_Label;
    private boolean isRegular_Label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public enum AdObjects{
        PANE,PANE_IMAGE,TEXTAREA_FONT_COLOR,TEXTAREA_FONT_REG,TEXTAREA_TEXT,TEXTAREA_FONT_ITALIC,TEXTAREA_FONT_BOLD,TEXTAREA_FONT_SIZE,TEXTAREA_FONT_FAMILY,LABEL_TEXT,LABEL_BACK,LABEL_FONT_COLOR,LABEL_FONT_BOLD,LABEL_FONT_ITALIC,LABEL_FONT_REG,LABEL_FONT_SIZE,LABEL_FONT_FAMILY,IMAGE
    }
    
    public void setObjectsProperties(AdObjects adObjects,Object[] changes){
        switch(adObjects){
            
            case PANE:
                setBackground(containPane,null,(String) changes[0]);break;
            case PANE_IMAGE:
                setBackgroundImage((String) changes[0]);break;
            case TEXTAREA_FONT_BOLD:
                setFontBold(txtArea, null, (String) changes[0], (double) changes[1]);break;
            case LABEL_FONT_BOLD:
                setFontBold(null, lblText, (String) changes[0], (double) changes[1]);break;
            case TEXTAREA_FONT_COLOR:
                setFontColour(txtArea,null, (String) changes[0]);break;
            case LABEL_FONT_COLOR:
                setFontColour(null, lblText, (String) changes[0]);break;
            case TEXTAREA_FONT_FAMILY:
                setFontFamily(txtArea,null, (String) changes[0], (double) changes[1]);break;
            case LABEL_FONT_FAMILY:
                setFontFamily(null,lblText, (String) changes[0], (double) changes[1]);break;
            case TEXTAREA_FONT_ITALIC:
                setFontItalic(txtArea, null, (String) changes[0], (double) changes[1]);break;
            case LABEL_FONT_ITALIC:
                setFontItalic(null, lblText, (String) changes[0], (double) changes[1]);break;
            case TEXTAREA_FONT_REG:
                setFontRegular(txtArea, null, (String) changes[0],(double) changes[1]);break;
            case LABEL_FONT_REG:
                setFontRegular(null,lblText, (String) changes[0],(double) changes[1]);break;
            case TEXTAREA_FONT_SIZE:
                setFontSize(txtArea,null, (double) changes[0]);break;
            case LABEL_FONT_SIZE:
                setFontSize(null, lblText, (double) changes[0]);break;
            case LABEL_BACK:
                setBackground(null, lblText, (String) changes[0]);break;
            case IMAGE:
                setImage((String) changes[0]);break;
            case LABEL_TEXT:
                setText(null, lblText, (String)changes[0]);break;
            case TEXTAREA_TEXT:
                setText(txtArea,null, (String)changes[0]);break;
                
        }
    }
    
    public Object getObjectsProperties(AdObjects adObjects){
        switch(adObjects){
            
            case PANE:
                return getBackground(containPane,null);
            case PANE_IMAGE:
                return getBackgroundImage();
            case TEXTAREA_FONT_BOLD:
                return isFontBold(txtArea, null);
            case LABEL_FONT_BOLD:
                return isFontBold(null, lblText);
            case TEXTAREA_FONT_COLOR:
                return getFontColour(txtArea,null);
            case LABEL_FONT_COLOR:
                return getFontColour(null, lblText);
            case TEXTAREA_FONT_FAMILY:
                return getFontFamily(txtArea,null);
            case LABEL_FONT_FAMILY:
                return getFontFamily(null,lblText);
            case TEXTAREA_FONT_ITALIC:
                return isFontItalic(txtArea, null);
            case LABEL_FONT_ITALIC:
                return isFontItalic(null, lblText);
            case TEXTAREA_FONT_REG:
                return isFontRegular(txtArea, null);
            case LABEL_FONT_REG:
                return isFontRegular(null,lblText);
            case TEXTAREA_FONT_SIZE:
                return getFontSize(txtArea,null);
            case LABEL_FONT_SIZE:
                return getFontSize(null, lblText);
            case LABEL_BACK:
                return getBackground(null, lblText);
            case IMAGE:
                return getImage();
            case LABEL_TEXT:
                return getText(null,lblText);
            case TEXTAREA_TEXT:
                return getText(txtArea,null);
            default:
                return null;
        }
    }
    
    private void setText(JFXTextArea area,Label lbl,String text){
        if(area!=null){
            area.setText(text);
        }else{
            lbl.setText(text);
        }
        
    }
    
    private void setImage(String url){
       
        this.image.setImage(new Image(url));
        this.imgPath=url;
    }
    
    private void setBackground(AnchorPane anchor,Label lbl,String color){
        
        if(anchor!=null){
            try{
                if(backImg.getImage()!=null){
                    backImg.setImage(null);
                    anchor.setStyle("-fx-background-color:"+color);
                    txtArea.setFocusColor(Paint.valueOf(color));
                    txtArea.setUnFocusColor(Paint.valueOf(color));
                }else{
                    anchor.setStyle("-fx-background-color:"+color);
                    txtArea.setFocusColor(Paint.valueOf(color));
                    txtArea.setUnFocusColor(Paint.valueOf(color));
                }
            }catch(Exception ex){
                
            }
            
        }else{
            lbl.setStyle("-fx-background-color:"+color);
        }
        
    }
    
    private void setBackgroundImage(String url){
        
        this.backImg.setImage(new Image(url));
        this.backImgPath=url;
        
    }
    
    private void setFontFamily(JFXTextArea area,Label lbl,String family,double size){
        
        if(area!=null){
            area.setFont(new Font(family, size));
        }else{
            lbl.setFont(new Font(family, size));
        }
        
    }
    
    private void setFontSize(JFXTextArea area,Label lbl,double size){
        if(area!=null){
            area.setFont(new Font(size));
        }else{
            lbl.setFont(new Font(size));
        }
        
    }
    
    private void setFontColour(JFXTextArea area,Label lbl,String color){
        
        if(area!=null){
            area.setStyle("-fx-text-fill:"+color);
        }else{
            lbl.setStyle("-fx-text-fill:"+color);
        }
        
    }
    
    private void setFontBold(JFXTextArea area,Label lbl,String family,double size){
       
        if(area!=null){
            area.setFont(Font.font(family, FontWeight.BOLD, size));
            isItalic_TextArea=false;
            isRegular_TextArea=false;
            isBold_TextArea=true;
        }else{
            lbl.setFont(Font.font(family, FontWeight.BOLD, size));
            isBold_Label=true;
            isItalic_Label=false;
            isRegular_Label=false;
        }
        
    }
    
    private void setFontItalic(JFXTextArea area,Label lbl,String family,double size){
        
        if(area!=null){
            area.setFont(Font.font(family, FontPosture.ITALIC, size));
            isItalic_TextArea=true;
            isRegular_TextArea=false;
            isBold_TextArea=false;
        }else{
            lbl.setFont(Font.font(family, FontPosture.ITALIC, size));
            isBold_Label=false;
            isItalic_Label=true;
            isRegular_Label=false;
        }
        
    }
    
    private void setFontRegular(JFXTextArea area,Label lbl,String family,double size){
     
        if(area!=null){
            area.setFont(Font.font(family, FontPosture.REGULAR, size));
            isItalic_TextArea=false;
            isRegular_TextArea=true;
            isBold_TextArea=false;
        }else{
            lbl.setFont(Font.font(family, FontPosture.REGULAR, size));
            isBold_Label=false;
            isItalic_Label=false;
            isRegular_Label=true;
        }
        
    }
    
    private String getImage(){
        
        if(image.getImage()!=null){
            return imgPath;
        }else{
            return null;
        }
    }
    
    private String getBackground(AnchorPane anchor,Label lbl){
        
        if(anchor!=null){
            return anchor.getStyle();
        }else{
            return lbl.getStyle();
        }
        
    }
    
    private String getBackgroundImage(){
        
        if(backImg.getImage()!=null){
            return backImgPath;
        }else{
            return null;
        }
        
    }
    
    private String getFontFamily(JFXTextArea area,Label lbl){
        
        if(area!=null){
            return area.getFont().getFamily();
        }else{
            return lbl.getFont().getFamily();
        }
        
    }
    
    private double getFontSize(JFXTextArea area,Label lbl){
        if(area!=null){
            return area.getFont().getSize();
        }else{
            return lbl.getFont().getSize();
        }
        
    }
    
    private String getFontColour(JFXTextArea area,Label lbl){
        
        if(area!=null){
            System.out.println(area.getStyle());
            return area.getStyle();
        }else{
            return lbl.getStyle();
        }
        
    }
    
    private boolean isFontBold(JFXTextArea area,Label lbl){
       
        if(area!=null){
            return isBold_TextArea;
        }else{
            return isBold_Label;
        }
        
    }
    
    private boolean isFontItalic(JFXTextArea area,Label lbl){
        
        if(area!=null){
            return isItalic_TextArea;
        }else{
            return isItalic_Label;
        }
    }
    
    private boolean isFontRegular(JFXTextArea area,Label lbl){
     
        if(area!=null){
            return isRegular_TextArea;
        }else{
            return isRegular_Label;
        }
        
    }
    private String getText(JFXTextArea area,Label lbl){
        
        if(area!=null){
            return area.getText();
        }else{
            return lbl.getText();
        }
        
    }
    
}
