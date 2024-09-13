package com.michaelmckibbin.js1;

import com.michaelmckibbin.js1.JewelleryItem;
import com.michaelmckibbin.js1.MyLinkedList;

import java.io.Serializable;


public class DisplayTray  implements Serializable {

    private String trayID;
    private String trayColor;
    private int trayWidth;
    private int trayDepth;
    private int caseId;
    public MyLinkedList<JewelleryItem> jewelleryItems;

    public DisplayTray(int caseId, String trayID, String trayColor, int trayWidth, int trayDepth/*, JewelleryItem jewelleryItems*/) {
        this.trayID = trayID;
        this.trayColor = trayColor;
        this.trayWidth = trayWidth;
        this.trayDepth = trayDepth;
        this.jewelleryItems = new MyLinkedList<>();
    }

    public DisplayTray(String trayId) {
    }


    public String getTrayID() {
        return trayID;
    }

    public void setTrayID(String trayID) {
        this.trayID = trayID;
    }

    public String getTrayColor() {
        return trayColor;
    }

    public void setTrayColor(String trayColor) {
        this.trayColor = trayColor;
    }

    public int getTrayWidth() {
        return trayWidth;
    }

    public void setTrayWidth(int trayWidth) {
        this.trayWidth = trayWidth;
    }

    public int getTrayDepth() {
        return trayDepth;
    }

    public void setTrayDepth(int trayDepth) {
        this.trayDepth = trayDepth;
    }

    public int getCaseId() {
        return caseId;
    }
    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public MyLinkedList<JewelleryItem> getJewelleryItems() {
        return jewelleryItems;
    }

    public void setJewelleryItems(MyLinkedList<JewelleryItem> jewelleryItems) {
        this.jewelleryItems = jewelleryItems;
    }

    @Override
    public String toString() {
        return "DisplayTray{" +
                "caseId= " + caseId +
                "trayID= " + trayID + '\'' +
                ", trayColor= " + trayColor + '\'' +
                ", trayWidth= " + trayWidth +
                ", trayDepth= " + trayDepth +
                ", jewelleryItems= " + jewelleryItems +
                '}';
    }

    public String getTrayId() {
        return trayID;
    }

    public void addJewelleryItem(JewelleryItem newItem) {
        this.jewelleryItems.add(newItem);
    }
// findJewelleryItemById
    public JewelleryItem findJewelleryItemById(int itemId) {
        for (JewelleryItem item : jewelleryItems) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null; // Item not found
    }


}
