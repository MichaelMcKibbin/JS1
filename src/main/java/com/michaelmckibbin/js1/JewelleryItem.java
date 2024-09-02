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
    private MyLinkedList<JewelleryMaterial> materials;

    // Constructor
    public JewelleryItem(String itemID, String itemName, String itemType, String itemDescription, String itemTargetGender, String itemImage, float itemPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemTargetGender = itemTargetGender;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        this.materials = new MyLinkedList<>();
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

    public MyLinkedList<JewelleryMaterial> getMaterials() {
        return materials;
    }

    public void addMaterial(JewelleryMaterial material) {
        materials.add(material);
    }

    public void removeMaterial(JewelleryMaterial material) {
        materials.remove(material);
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
                ", materials=" + materials + '\n' +
                '}';
    }
}
