package com.michaelmckibbin.js1;

public class JewelleryMaterial {

    String materialName;
    String materialType;
    String materialDescription;
    String materialImage;
    int materialID;
    int materialQuantity;
    int materialWeight;
    int materialPrice;


    public JewelleryMaterial(int materialID,
                             String materialName,
                             String materialType,
                             String materialDescription,
                             String materialImage,
                             int materialQuantity,
                             int materialWeight,
                             int materialPrice) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.materialType = materialType;
        this.materialDescription = materialDescription;
        this.materialImage = materialImage;
        this.materialQuantity = materialQuantity;
        this.materialWeight = materialWeight;
        this.materialPrice = materialPrice;
    }
}
