package com.michaelmckibbin.js1;

public class JewelleryMaterial {

    int materialID; // number e.g. 101
    String materialName; // eg silver chain, ruby, gold
    // String materialDescription; //
    String materialUnit; // e.g grams, each, cm
    String materialImage; // url to image, or placeholder
    int materialQuantity; // number of units in stock
    int materialPrice; // price per unit


    public JewelleryMaterial(int materialID,
                             String materialName,
                             String materialUnit,
                             String materialImage,
                             int materialQuantity,
                             int materialPrice) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.materialUnit = materialUnit;
        this.materialImage = materialImage;
        this.materialQuantity = materialQuantity;
        this.materialPrice = materialPrice;
    }

    /*
    Getters & Setters
     */

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public String getMaterialImage() {
        return materialImage;
    }

    public void setMaterialImage(String materialImage) {
        this.materialImage = materialImage;
    }

    public int getMaterialQuantity() {
        return materialQuantity;
    }

    public void setMaterialQuantity(int materialQuantity) {
        this.materialQuantity = materialQuantity;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(int materialPrice) {
        this.materialPrice = materialPrice;
    }

    @Override
    public String toString() {
        return "JewelleryMaterial{" +
                "materialID=" + materialID +
                ", materialName='" + materialName + '\'' +
                ", materialUnit='" + materialUnit + '\'' +
                ", materialImage='" + materialImage + '\'' +
                ", materialQuantity=" + materialQuantity +
                ", materialPrice=" + materialPrice +
                '}';
    }

}
