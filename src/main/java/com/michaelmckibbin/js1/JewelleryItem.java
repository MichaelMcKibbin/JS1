package com.michaelmckibbin.js1;
import com.michaelmckibbin.js1.MyLinkedList;

import java.io.Serializable;

public class JewelleryItem implements Serializable {
    private String itemID;
    private String itemName;
    private String itemType;
    private String itemDescription;
    private String itemTargetGender;
    private String itemImage;
    private float itemPrice;
    private MyLinkedList<JewelleryMaterial> jewelleryMaterials;

    // Constructor
    public JewelleryItem(String itemID, String itemName, String itemType, String itemDescription, String itemTargetGender, String itemImage, float itemPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemTargetGender = itemTargetGender;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        this.jewelleryMaterials = new MyLinkedList<>();
    }

    // Getters and Setters

    public String getItemID() {
        return itemID;
    }
    public int getItemId() {
        return Integer.parseInt(itemID);
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemTargetGender() {
        return itemTargetGender;
    }

    public void setItemTargetGender(String itemTargetGender) {
        this.itemTargetGender = itemTargetGender;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public MyLinkedList<JewelleryMaterial> getJewelleryMaterials() {
        return jewelleryMaterials;
    }

    public void addJewelleryMaterial(JewelleryMaterial jewelleryMaterial) {
        jewelleryMaterials.add(jewelleryMaterial);
    }

    public void removeJewelleryMaterial(JewelleryMaterial jewelleryMaterial) {
        jewelleryMaterials.remove(jewelleryMaterial);
    }


    @Override
    public String toString() {
        return "JewelleryItem{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\n' +
                ", itemType='" + itemType + '\n' +
                ", itemDescription='" + itemDescription + '\n' +
                ", itemTargetGender='" + itemTargetGender + '\n' +
                ", itemImage='" + itemImage + '\n' +
                ", itemPrice=" + itemPrice +
                '\n' +
                ", jewelleryMaterials=" + jewelleryMaterials + '\n' +
                '}';
    }


    public void addJewelleryMaterial() {
    }
}
