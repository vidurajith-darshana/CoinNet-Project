/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vidurajith
 */
@Entity
public class EcoAd {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ecoId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Advertiesment advertiesment;
    
    private String image;
    private String backImage;
    private String areaFontColor;
    private double areaFontSize;
    private boolean isAreaItalic;
    private boolean isAreaReg;
    private boolean isAreaBold;
    private String areaFamily;
    private String lblBack;
    private String lblText;
    private String areaText;
    private String lblFontColor;
    private double lblFontSize;
    private String lblFamily;
    private boolean isLblBold;
    private boolean isLblItalic;
    private boolean isLblReg;
    private String backColor;

    public EcoAd() {
    }

    public EcoAd(int ecoId, Advertiesment advertiesment, String image, String backImage, String areaFontColor, double areaFontSize, boolean isAreaItalic, boolean isAreaReg, boolean isAreaBold, String areaFamily, String lblBack, String lblText, String areaText, String lblFontColor, double lblFontSize, String lblFamily, boolean isLblBold, boolean isLblItalic, boolean isLblReg, String backColor) {
        this.ecoId = ecoId;
        this.advertiesment = advertiesment;
        this.image = image;
        this.backImage = backImage;
        this.areaFontColor = areaFontColor;
        this.areaFontSize = areaFontSize;
        this.isAreaItalic = isAreaItalic;
        this.isAreaReg = isAreaReg;
        this.isAreaBold = isAreaBold;
        this.areaFamily = areaFamily;
        this.lblBack = lblBack;
        this.lblText = lblText;
        this.areaText = areaText;
        this.lblFontColor = lblFontColor;
        this.lblFontSize = lblFontSize;
        this.lblFamily = lblFamily;
        this.isLblBold = isLblBold;
        this.isLblItalic = isLblItalic;
        this.isLblReg = isLblReg;
        this.backColor = backColor;
    }
    
    public EcoAd(Advertiesment advertiesment, String image, String backImage, String areaFontColor, double areaFontSize, boolean isAreaItalic, boolean isAreaReg, boolean isAreaBold, String areaFamily, String lblBack, String lblText, String areaText, String lblFontColor, double lblFontSize, String lblFamily, boolean isLblBold, boolean isLblItalic, boolean isLblReg, String backColor) {
     
        this.advertiesment = advertiesment;
        this.image = image;
        this.backImage = backImage;
        this.areaFontColor = areaFontColor;
        this.areaFontSize = areaFontSize;
        this.isAreaItalic = isAreaItalic;
        this.isAreaReg = isAreaReg;
        this.isAreaBold = isAreaBold;
        this.areaFamily = areaFamily;
        this.lblBack = lblBack;
        this.lblText = lblText;
        this.areaText = areaText;
        this.lblFontColor = lblFontColor;
        this.lblFontSize = lblFontSize;
        this.lblFamily = lblFamily;
        this.isLblBold = isLblBold;
        this.isLblItalic = isLblItalic;
        this.isLblReg = isLblReg;
        this.backColor = backColor;
    }

    /**
     * @return the ecoId
     */
    public int getEcoId() {
        return ecoId;
    }

    /**
     * @param ecoId the ecoId to set
     */
    public void setEcoId(int ecoId) {
        this.ecoId = ecoId;
    }

    /**
     * @return the advertiesment
     */
    public Advertiesment getAdvertiesment() {
        return advertiesment;
    }

    /**
     * @param advertiesment the advertiesment to set
     */
    public void setAdvertiesment(Advertiesment advertiesment) {
        this.advertiesment = advertiesment;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the backImage
     */
    public String getBackImage() {
        return backImage;
    }

    /**
     * @param backImage the backImage to set
     */
    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    /**
     * @return the areaFontColor
     */
    public String getAreaFontColor() {
        return areaFontColor;
    }

    /**
     * @param areaFontColor the areaFontColor to set
     */
    public void setAreaFontColor(String areaFontColor) {
        this.areaFontColor = areaFontColor;
    }

    /**
     * @return the areaFontSize
     */
    public double getAreaFontSize() {
        return areaFontSize;
    }

    /**
     * @param areaFontSize the areaFontSize to set
     */
    public void setAreaFontSize(double areaFontSize) {
        this.areaFontSize = areaFontSize;
    }

    /**
     * @return the isAreaItalic
     */
    public boolean isIsAreaItalic() {
        return isAreaItalic;
    }

    /**
     * @param isAreaItalic the isAreaItalic to set
     */
    public void setIsAreaItalic(boolean isAreaItalic) {
        this.isAreaItalic = isAreaItalic;
    }

    /**
     * @return the isAreaReg
     */
    public boolean isIsAreaReg() {
        return isAreaReg;
    }

    /**
     * @param isAreaReg the isAreaReg to set
     */
    public void setIsAreaReg(boolean isAreaReg) {
        this.isAreaReg = isAreaReg;
    }

    /**
     * @return the isAreaBold
     */
    public boolean isIsAreaBold() {
        return isAreaBold;
    }

    /**
     * @param isAreaBold the isAreaBold to set
     */
    public void setIsAreaBold(boolean isAreaBold) {
        this.isAreaBold = isAreaBold;
    }

    /**
     * @return the areaFamily
     */
    public String getAreaFamily() {
        return areaFamily;
    }

    /**
     * @param areaFamily the areaFamily to set
     */
    public void setAreaFamily(String areaFamily) {
        this.areaFamily = areaFamily;
    }

    /**
     * @return the lblBack
     */
    public String getLblBack() {
        return lblBack;
    }

    /**
     * @param lblBack the lblBack to set
     */
    public void setLblBack(String lblBack) {
        this.lblBack = lblBack;
    }

    /**
     * @return the lblText
     */
    public String getLblText() {
        return lblText;
    }

    /**
     * @param lblText the lblText to set
     */
    public void setLblText(String lblText) {
        this.lblText = lblText;
    }

    /**
     * @return the areaText
     */
    public String getAreaText() {
        return areaText;
    }

    /**
     * @param areaText the areaText to set
     */
    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    /**
     * @return the lblFontColor
     */
    public String getLblFontColor() {
        return lblFontColor;
    }

    /**
     * @param lblFontColor the lblFontColor to set
     */
    public void setLblFontColor(String lblFontColor) {
        this.lblFontColor = lblFontColor;
    }

    /**
     * @return the lblFontSize
     */
    public double getLblFontSize() {
        return lblFontSize;
    }

    /**
     * @param lblFontSize the lblFontSize to set
     */
    public void setLblFontSize(double lblFontSize) {
        this.lblFontSize = lblFontSize;
    }

    /**
     * @return the lblFamily
     */
    public String getLblFamily() {
        return lblFamily;
    }

    /**
     * @param lblFamily the lblFamily to set
     */
    public void setLblFamily(String lblFamily) {
        this.lblFamily = lblFamily;
    }

    /**
     * @return the isLblBold
     */
    public boolean isIsLblBold() {
        return isLblBold;
    }

    /**
     * @param isLblBold the isLblBold to set
     */
    public void setIsLblBold(boolean isLblBold) {
        this.isLblBold = isLblBold;
    }

    /**
     * @return the isLblItalic
     */
    public boolean isIsLblItalic() {
        return isLblItalic;
    }

    /**
     * @param isLblItalic the isLblItalic to set
     */
    public void setIsLblItalic(boolean isLblItalic) {
        this.isLblItalic = isLblItalic;
    }

    /**
     * @return the isLblReg
     */
    public boolean isIsLblReg() {
        return isLblReg;
    }

    /**
     * @param isLblReg the isLblReg to set
     */
    public void setIsLblReg(boolean isLblReg) {
        this.isLblReg = isLblReg;
    }

    /**
     * @return the backColor
     */
    public String getBackColor() {
        return backColor;
    }

    /**
     * @param backColor the backColor to set
     */
    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    @Override
    public String toString() {
        return "EcoAd{" + "ecoId=" + ecoId + ", advertiesment=" + advertiesment + ", image=" + image + ", backImage=" + backImage + ", areaFontColor=" + areaFontColor + ", areaFontSize=" + areaFontSize + ", isAreaItalic=" + isAreaItalic + ", isAreaReg=" + isAreaReg + ", isAreaBold=" + isAreaBold + ", areaFamily=" + areaFamily + ", lblBack=" + lblBack + ", lblText=" + lblText + ", areaText=" + areaText + ", lblFontColor=" + lblFontColor + ", lblFontSize=" + lblFontSize + ", lblFamily=" + lblFamily + ", isLblBold=" + isLblBold + ", isLblItalic=" + isLblItalic + ", isLblReg=" + isLblReg + ", backColor=" + backColor + '}';
    }
    
    
    
    
    
}
