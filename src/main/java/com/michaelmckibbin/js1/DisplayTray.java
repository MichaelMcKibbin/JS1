package com.michaelmckibbin.js1;


public class DisplayTray {

    private String trayID;
    private String trayColor;
    private int trayWidth;
    private int trayDepth;

   // public MyLinkedList<JewelleryItem> items = new MyLinkedList<>();

    public DisplayTray(){}

    public DisplayTray(String trayID, String trayColor, int trayWidth, int trayDepth) {
        this.trayID = trayID;
        this.trayColor = trayColor;
        this.trayWidth = trayWidth;
        this.trayDepth = trayDepth;
        //this.items = new MyLinkedList<>();
    }

    public String getTrayID() {
        return trayID;
    }

    public void setTrayID(String trayID) {
        this.trayID = trayID;
    }

    @Override
    public String toString() {
        return "DisplayTray{" +
                "trayID='" + trayID + '\'' +
                ", trayColor='" + trayColor + '\'' +
                ", trayWidth=" + trayWidth +
                ", trayDepth=" + trayDepth +
                '}';
    }

//    @Override
//    public String toString() {
//        return " trayID= " + trayID + ", trayColor= " + trayColor +", trayWidth=" + trayWidth + ", trayDepth= " + trayDepth;
//    }
//
//    public char[] getTrayId() {
//        return trayID.toCharArray();
//    }
//
//    public char[] getTrayColor() {
//        return trayColor.toCharArray();
//    }
//
//    public char[] getTrayWidth() {
//        return String.valueOf(trayWidth).toCharArray();
//    }
//
//    public char[] getTrayDepth() {
//        return String.valueOf(trayDepth).toCharArray();
//    }
}
