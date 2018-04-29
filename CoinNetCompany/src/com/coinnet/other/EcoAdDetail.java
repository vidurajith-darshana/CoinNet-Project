/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinnet.other;

/**
 *
 * @author Vidurajith
 */
public class EcoAdDetail {
    
    private static EcoAdDetail ecoAdDetail;
    
    private String lblText;
    private String areaText;
    
    private String lblFontColor;
    private String areaFontColor;
    
    private double lblFontSize;
    private double areaFontSize;
    
    private boolean isLblBold;
    private boolean isLblItalic;
    private boolean isLblRegular;
    private boolean isAreaBold;
    private boolean isAreaItalic;
    private boolean isAreaRegular;
    
    private String lblFamily;
    private String areaFamily;
    
    private String imageUrl;
    private String backImgUrl;
    
    private String paneBackground;
    private String lblBackground;
    
    private EcoAdDetail(){
        
    }
    
    public static EcoAdDetail getInstance(){
        if(ecoAdDetail==null){
            ecoAdDetail=new EcoAdDetail();
        }
        return ecoAdDetail;
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
     * @return the isLblRegular
     */
    public boolean isIsLblRegular() {
        return isLblRegular;
    }

    /**
     * @param isLblRegular the isLblRegular to set
     */
    public void setIsLblRegular(boolean isLblRegular) {
        this.isLblRegular = isLblRegular;
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
     * @return the isAreaRegular
     */
    public boolean isIsAreaRegular() {
        return isAreaRegular;
    }

    /**
     * @param isAreaRegular the isAreaRegular to set
     */
    public void setIsAreaRegular(boolean isAreaRegular) {
        this.isAreaRegular = isAreaRegular;
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
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return the backImgUrl
     */
    public String getBackImgUrl() {
        return backImgUrl;
    }

    /**
     * @param backImgUrl the backImgUrl to set
     */
    public void setBackImgUrl(String backImgUrl) {
        this.backImgUrl = backImgUrl;
    }

    /**
     * @return the paneBackground
     */
    public String getPaneBackground() {
        return paneBackground;
    }

    /**
     * @param paneBackground the paneBackground to set
     */
    public void setPaneBackground(String paneBackground) {
        this.paneBackground = paneBackground;
    }

    /**
     * @return the lblBackground
     */
    public String getLblBackground() {
        return lblBackground;
    }

    /**
     * @param lblBackground the lblBackground to set
     */
    public void setLblBackground(String lblBackground) {
        this.lblBackground = lblBackground;
    }
    
    
    
    
}
