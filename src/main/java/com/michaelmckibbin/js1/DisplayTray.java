package com.michaelmckibbin.js1;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DisplayTray {

    private String displayTrayID = "";
    private String displayTrayInlayCol = "";
    private String displayTrayDimensions = "";

    public MyLinkedList<JewelleryItem> items = new MyLinkedList<>();


    public DisplayTray(String trayID, String inlayCol, String trayDimensions) {

        displayTrayID = trayID;
        displayTrayInlayCol = inlayCol;
        displayTrayDimensions = trayDimensions;
        //this.items = new MyLinkedList<>();
    }
    public String getDisplayTrayID() {
        return displayTrayID;
    }
    public String getDisplayTrayInlayCol() {
        return displayTrayInlayCol;
    }
    public String getDisplayTrayDimensions() {
        return displayTrayDimensions;
    }
    public MyLinkedList<JewelleryItem> getItems() {
        return items;
    }
    public void setDisplayTrayID(String displayTrayID) {
        this.displayTrayID = displayTrayID;
    }
    public void setDisplayTrayInlayCol(String displayTrayInlayCol) {
        this.displayTrayInlayCol = displayTrayInlayCol;
    }
    public void setDisplayTrayDimensions(String displayTrayDimensions) {
        this.displayTrayDimensions = displayTrayDimensions;
    }
    public void setItems(MyLinkedList<JewelleryItem> items) {
        this.items = items;
    }
    @Override
    public String toString() {
        return "DisplayTray{" +
                "displayTrayID='" + displayTrayID + '\'' +
                ", displayTrayInlayCol='" + displayTrayInlayCol + '\'' +
                ", displayTrayDimensions='" + displayTrayDimensions + '\'' +
                ", items=" + items +
                '}';
    }
    /*public void addItem(JewelleryItem item) {
        items.add(item);
    }*/
    public void removeItem(JewelleryItem item) {
        items.remove(item);
    }
    /*public void clearItems() {
        items.clear();
    }*/
    public int getItemCount() {
        return items.size();
    }
    public JewelleryItem getItem(int index) {
        return items.get(index);
    }
    public void setItem(int index, JewelleryItem item) {
        items.set(index, item);
    }
    public boolean containsItem(JewelleryItem item) {
        return items.contains(item);
    }
    public int indexOfItem(JewelleryItem item) {
        return items.indexOf(item);
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }



}
