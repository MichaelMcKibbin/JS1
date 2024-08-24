package com.michaelmckibbin.js1;


public class DisplayTray {

    private String trayID;
    private String trayColor;
    private int trayWidth;
    private int trayDepth;
    //public MyLinkedList<JewelleryItem> jewelleryItems;

    public DisplayTray(String trayID, String trayColor, int trayWidth, int trayDepth/*, JewelleryItem jewelleryItems*/) {
        this.trayID = trayID;
        this.trayColor = trayColor;
        this.trayWidth = trayWidth;
        this.trayDepth = trayDepth;
        //this.jewelleryItems = new MyLinkedList<>();
    }

    public DisplayTray() {

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
//
//    public MyLinkedList<JewelleryItem> getJewelleryItems() {
//        return jewelleryItems;
//    }
//
//    public void setJewelleryItems(MyLinkedList<JewelleryItem> jewelleryItems) {
//        this.jewelleryItems = jewelleryItems;
//    }

    @Override
    public String toString() {
        return "DisplayTray{" +
                "trayID='" + trayID + '\'' +
                ", trayColor='" + trayColor + '\'' +
                ", trayWidth=" + trayWidth +
                ", trayDepth=" + trayDepth +
                /*", jewelleryItems=" + jewelleryItems + */
                '}';
    }
}
