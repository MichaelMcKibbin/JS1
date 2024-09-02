package com.michaelmckibbin.js1;
import com.michaelmckibbin.js1.MyLinkedList;

public class JewelleryItem {
    private String itemID;
    private String itemName;
    private String itemType;
    private String itemDescription;
    private String itemTargetGender;
    private String itemImage;
    private float itemPrice;
    //public DisplayCase displayCase;
    //public DisplayTray displayTray;

    // Constructor
    //public JewelleryItem(DisplayCase displayCase , DisplayTray displayTray,String itemID, String itemName, String itemType, String itemDescription, String itemTargetGender, String itemImage, float itemPrice) {
    public JewelleryItem(String itemID, String itemName, String itemType, String itemDescription, String itemTargetGender, String itemImage, float itemPrice) {
            // this.displayCase = displayCase;
       // this.displayTray = displayTray;
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemTargetGender = itemTargetGender;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
    }

    // Getters and Setters

    public String getItemID() {
        return itemID;
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


//    // Override toString() method (optional)
//    @Override
//    public String toString() {
//        return "JewelleryItem{" +
//                "displayCase=" + displayCase +
//                ", displayTray=" + displayTray +
//                "itemID=" + itemID +
//                ", itemName='" + itemName + '\'' +
//                ", itemType='" + itemType + '\'' +
//                ", itemDescription='" + itemDescription + '\'' +
//                ", itemTargetGender='" + itemTargetGender + '\'' +
//                ", itemImage='" + itemImage + '\'' +
//                ", itemPrice=" + itemPrice +
//                '}';
//    }
    @Override
    public String toString() {
        return "JewelleryItem{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemTargetGender='" + itemTargetGender + '\'' +
                ", itemImage='" + itemImage + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
