package com.michaelmckibbin.js1;
import com.michaelmckibbin.js1.MyLinkedList;


public class JewelleryItem {
    private int itemID; // ID number
    private String itemName;
    private String itemType; // ring, watch, etc.
    private String itemDescription;
    private String itemColour;
    private String itemTargetGender; // male, female, any
    private String itemImage; // url or placeholder image
    private Float itemPrice;
    private MyLinkedList<JewelleryMaterial> materials;

    public JewelleryItem(int itemID,
                         String itemName,
                         String itemType,
                         String itemDescription,
                         String itemColour,
                         String itemTargetGender,
                         String itemImage,
                         float itemPrice
                         ) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemColour = itemColour;
        this.itemTargetGender = itemTargetGender;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        this.materials = new MyLinkedList<>();
    }

    public void addMaterial(JewelleryMaterial material) {
        materials.insert(material);
    }
    public MyLinkedList<JewelleryMaterial> getMaterials() {
        return materials;
    }

    /* examples
    JewelleryItem necklace = new JewelleryItem(101, "Gold Necklace", "Necklace", "A beautiful gold necklace", "Gold", "Any", "https://example.com/gold-necklace.jpg", 499.99);
    JewelleryMaterial diamond2Karat = new JewelleryMaterial("501, "Diamond, 2 Karat", "karat", "https://example.com/diamond.jpg", 2, 2000);
    JewelleryMaterial goldChain = new JewelleryMaterial("502, "Gold Chain", "cm", "https://example.com/gold.jpg", 60, 1500);

    necklace.addMaterial(goldChain);
    necklace.addMaterial(diamond2Karat);
    */

    @Override
    public String toString() {
        return "Item ID: " + itemID + "\nName: " + itemName + "\nType: " + itemType + "\nDescription: " + itemDescription + "\nColour: " + itemColour + "\nTarget Gender: " + itemTargetGender + "\nImage: " + itemImage + "\nPrice: " + itemPrice;
    }

    /*
    Getters and Setters
     */
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
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

    public String getItemColour() {
        return itemColour;
    }

    public void setItemColour(String itemColour) {
        this.itemColour = itemColour;
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

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setMaterials(MyLinkedList<JewelleryMaterial> materials) {
        this.materials = materials;
    }
}
