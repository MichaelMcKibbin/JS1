package com.michaelmckibbin.js1;

import java.io.Serializable;

public class JewelleryMaterial implements Serializable {

    String jewelleryMaterialId; // number e.g. 101
    String jewelleryMaterialName; // eg silver chain, ruby, gold
    String jewelleryMaterialDescription; //
    String jewelleryMaterialUnit; // e.g grams, each, cm
    String jewelleryMaterialImage; // url to image, or placeholder
    int jewelleryMaterialQuantity; // number of units in stock
    double jewelleryMaterialPrice; // price per unit
    String jewelleryMaterialQuality; // .925, 24, 99%, etc.

    public JewelleryMaterial(String jewelleryMaterialId,
                             String jewelleryMaterialName,
                             String jewelleryMaterialDescription,
                             String jewelleryMaterialUnit,
                             String jewelleryMaterialImage,
                             int jewelleryMaterialQuantity,
                             String jewelleryMaterialQuality,
                             double jewelleryMaterialPrice) {
        this.jewelleryMaterialId = jewelleryMaterialId;
        this.jewelleryMaterialName = jewelleryMaterialName;
        this.jewelleryMaterialDescription = jewelleryMaterialDescription;
        this.jewelleryMaterialUnit = jewelleryMaterialUnit;
        this.jewelleryMaterialImage = jewelleryMaterialImage;
        this.jewelleryMaterialQuantity = jewelleryMaterialQuantity;
        this.jewelleryMaterialQuality = jewelleryMaterialQuality;
        this.jewelleryMaterialPrice = jewelleryMaterialPrice;

    }

    public String getJewelleryMaterialQuality() {
        return jewelleryMaterialQuality;
    }

    public void setJewelleryMaterialQuality(String jewelleryMaterialQuality) {
        this.jewelleryMaterialQuality = jewelleryMaterialQuality;
    }

    public String getJewelleryMaterialId() {
        return jewelleryMaterialId;
    }

    public void setJewelleryMaterialId(String jewelleryMaterialId) {
        this.jewelleryMaterialId = jewelleryMaterialId;
    }

    public String getJewelleryMaterialName() {
        return jewelleryMaterialName;
    }

    public void setJewelleryMaterialName(String jewelleryMaterialName) {
        this.jewelleryMaterialName = jewelleryMaterialName;
    }

    public String getJewelleryMaterialDescription() {
        return jewelleryMaterialDescription;
    }

    public void setJewelleryMaterialDescription(String jewelleryMaterialDescription) {
        this.jewelleryMaterialDescription = jewelleryMaterialDescription;
    }

    public String getJewelleryMaterialUnit() {
        return jewelleryMaterialUnit;
    }

    public void setJewelleryMaterialUnit(String jewelleryMaterialUnit) {
        this.jewelleryMaterialUnit = jewelleryMaterialUnit;
    }

    public String getJewelleryMaterialImage() {
        return jewelleryMaterialImage;
    }

    public void setJewelleryMaterialImage(String jewelleryMaterialImage) {
        this.jewelleryMaterialImage = jewelleryMaterialImage;
    }

    public int getJewelleryMaterialQuantity() {
        return jewelleryMaterialQuantity;
    }

    public void setJewelleryMaterialQuantity(int jewelleryMaterialQuantity) {
        this.jewelleryMaterialQuantity = jewelleryMaterialQuantity;
    }

    public double getJewelleryMaterialPrice() {
        return jewelleryMaterialPrice;
    }

    public void setJewelleryMaterialPrice(double jewelleryMaterialPrice) {
        this.jewelleryMaterialPrice = jewelleryMaterialPrice;
    }

    @Override
    public String toString() {
        return "jewelleryMaterialId=" + jewelleryMaterialId + '\n' +
                ", jewelleryMaterialName=" + jewelleryMaterialName + '\n' +
                ", jewelleryMaterialDescription=" + jewelleryMaterialDescription + '\n' +
                ", jewelleryMaterialUnit=" + jewelleryMaterialUnit + '\n' +
                ", jewelleryMaterialImage=" + jewelleryMaterialImage + '\n' +
                ", jewelleryMaterialQuantity=" + jewelleryMaterialQuantity + '\n' +
                ", jewelleryMaterialQuality= " + jewelleryMaterialQuality + '\n' +
                ", jewelleryMaterialPrice=" + jewelleryMaterialPrice;

    }
}
