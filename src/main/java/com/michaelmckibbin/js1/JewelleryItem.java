package com.michaelmckibbin.js1;



public class JewelleryItem {
    private String itemName, itemType, itemDescription, itemMaterial, itemColour, itemTargetGender, itemImage;
    private Float itemPrice;
    private JewelleryMaterial jewelleryMaterials;
    private int itemID;
    private MyLinkedList<JewelleryMaterial> materialsList;

    public JewelleryItem(int itemID, String itemName, String itemType, String itemDescription, String itemMaterial, String itemColour, String itemTargetGender, String itemImage, float itemPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemMaterial = itemMaterial;
        this.itemColour = itemColour;
        this.itemTargetGender = itemTargetGender;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        //this.jewelleryMaterials = jewelleryMaterials;

    }
    public String getItemName() {
        return itemName;
    }
    public String getItemType() {
        return itemType;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public String getItemMaterial() {
        return itemMaterial;
    }
    public String getItemColour() {
        return itemColour;
    }
    public String getItemTargetGender() {
        return itemTargetGender;
    }
    public String getItemImage() {
        return itemImage;
    }
    public Float getItemPrice() {
        return itemPrice;
    }
    public JewelleryMaterial getJewelleryMaterials() {
        return jewelleryMaterials;
    }
    public int getItemID() {
        return itemID;
    }
    public MyLinkedList<JewelleryMaterial> getMaterials() {
        return materialsList;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    @Override
    public String toString() {
        return "JewelleryItem{" +
                "itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemMaterial='" + itemMaterial + '\'' +
                ", itemColour='" + itemColour + '\'' +
                ", itemTargetGender='" + itemTargetGender + '\'' +
                ", itemImage='" + itemImage + '\'' +
                ", itemPrice=" + itemPrice +
                ", jewelleryMaterials=" + jewelleryMaterials +
                ", itemID=" + itemID +
                ", materials=" + materialsList +
                '}';
    }
    public void setMaterials(MyLinkedList<JewelleryMaterial> materials) {
        this.materialsList = materials;
    }
    public void addMaterial(JewelleryMaterial material) {
        materialsList.add(material);
    }
    public void removeMaterial(JewelleryMaterial material) {
        materialsList.remove(material);
    }
    public void clearMaterials() {
        materialsList.clear();
    }
    public int getMaterialCount() {
        return materialsList.size();
    }
    public JewelleryMaterial getMaterial(int index) {
        return materialsList.get(index);
    }
    public void setMaterial(int index, JewelleryMaterial material) {
        materialsList.set(index, material);
    }
    public boolean containsMaterial(JewelleryMaterial material) {
        return materialsList.contains(material);
    }
    public int indexOfMaterial(JewelleryMaterial material) {
        return materialsList.indexOf(material);
    }
    public boolean isEmpty() {
        return materialsList.isEmpty();
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    public void setItemMaterial(String itemMaterial) {
        this.itemMaterial = itemMaterial;
    }
    public void setItemColour(String itemColour) {
        this.itemColour = itemColour;
    }
    public void setItemTargetGender(String itemTargetGender) {
        this.itemTargetGender = itemTargetGender;
    }
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }
    public void setJewelleryMaterials(JewelleryMaterial jewelleryMaterials) {
        this.jewelleryMaterials = jewelleryMaterials;
    }
    public void setMaterialsList(MyLinkedList<JewelleryMaterial> materialsList) {
        this.materialsList = materialsList;
    }
    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

}
