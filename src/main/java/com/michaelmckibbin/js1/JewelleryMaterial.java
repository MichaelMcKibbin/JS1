package com.michaelmckibbin.js1;

import java.io.Serializable;

public class JewelleryMaterial implements Serializable {

    String jewelleryMaterialId; // number e.g. 101
    String jewelleryMaterialName; // eg silver chain, ruby, gold
    String jewelleryMaterialDescription; //
    String jewelleryMaterialUnit; // e.g grams, each, cm
    String jewelleryMaterialImage; // url to image, or placeholder
    int jewelleryMaterialQuantity; // number of units in stock
    float jewelleryMaterialPrice; // price per unit
    float jewelleryMaterialQuality; // .925, 24, 99%, etc.

    public JewelleryMaterial(String jewelleryMaterialId,
                             String jewelleryMaterialName,
                             String jewelleryMaterialDescription,
                             String jewelleryMaterialUnit,
                             String jewelleryMaterialImage,
                             int jewelleryMaterialQuantity,
                             float jewelleryMaterialPrice,
                             float jewelleryMaterialQuality) {
        this.jewelleryMaterialId = jewelleryMaterialId;
        this.jewelleryMaterialName = jewelleryMaterialName;
        this.jewelleryMaterialDescription = jewelleryMaterialDescription;
        this.jewelleryMaterialUnit = jewelleryMaterialUnit;
        this.jewelleryMaterialImage = jewelleryMaterialImage;
        this.jewelleryMaterialQuantity = jewelleryMaterialQuantity;
        this.jewelleryMaterialPrice = jewelleryMaterialPrice;
        this.jewelleryMaterialQuality = jewelleryMaterialQuality;
    }

    public float getJewelleryMaterialQuality() {
        return jewelleryMaterialQuality;
    }

    public void setJewelleryMaterialQuality(float jewelleryMaterialQuality) {
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

    public float getJewelleryMaterialPrice() {
        return jewelleryMaterialPrice;
    }

    public void setJewelleryMaterialPrice(float jewelleryMaterialPrice) {
        this.jewelleryMaterialPrice = jewelleryMaterialPrice;
    }

    @Override
    public String toString() {
        return "jewelleryMaterialId=" + jewelleryMaterialId +
                ", jewelleryMaterialName=" + jewelleryMaterialName +
                ", jewelleryMaterialDescription=" + jewelleryMaterialDescription +
                ", jewelleryMaterialUnit=" + jewelleryMaterialUnit +
                ", jewelleryMaterialImage=" + jewelleryMaterialImage +
                ", jewelleryMaterialQuantity=" + jewelleryMaterialQuantity +
                ", jewelleryMaterialPrice=" + jewelleryMaterialPrice +
                ", jewelleryMaterialQuality= " + jewelleryMaterialQuality;
    }
}
