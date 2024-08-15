package com.michaelmckibbin.js1;

public class DisplayCase {

    private int displayCaseID;
    private boolean displayCaseIsWallMounted = false; // false = floor, true = wall
    private boolean displayCaseIsLit = false;  // false = not lit, true = lit

    public MyLinkedList<DisplayTray> trays = new MyLinkedList<>();

    //private Object stage;

    public DisplayCase(int caseID, boolean dcWall, boolean dcLit) {
        displayCaseID = caseID;
        displayCaseIsWallMounted = dcWall;
        displayCaseIsLit = dcLit;
       // this.trays = new MyLinkedList<>();
    }

    public int getDisplayCaseID() {
        return displayCaseID;
    }
    public void setDisplayCaseID(int displayCaseID) {
        this.displayCaseID = displayCaseID;
    }
    public boolean isDisplayCaseIsWallMounted() {
        return displayCaseIsWallMounted;
    }
    public void setDisplayCaseIsWallMounted(boolean displayCaseIsWallMounted) {
        this.displayCaseIsWallMounted = displayCaseIsWallMounted;
    }
    public boolean isDisplayCaseIsLit() {
        return displayCaseIsLit;
    }
    public void setDisplayCaseIsLit(boolean displayCaseIsLit) {
        this.displayCaseIsLit = displayCaseIsLit;
    }
    @Override
    public String toString() {
        return "DisplayCase{" +
                "displayCaseID=" + displayCaseID +
                ", displayCaseIsWallMounted=" + displayCaseIsWallMounted +
                ", displayCaseIsLit=" + displayCaseIsLit +
                '}';
    }

    public void addTray(DisplayTray tray) {
        trays.add(tray);
    }
    public void removeTray(DisplayTray tray) {
        trays.remove(tray);
    }
    public DisplayTray getTray(int index) {
        return trays.get(index);
    }
    public int getNumberOfTrays() {
        return trays.size();
    }
    public void clearTrays() {
        trays.clear();
    }
    public boolean containsTray(DisplayTray tray) {
        return trays.contains(tray);
    }
    public int indexOfTray(DisplayTray tray) {
        return trays.indexOf(tray);
    }
    public boolean isEmpty() {
        return trays.isEmpty();
    }
    public void displayAllTrays() {
        for (int i = 0; i < trays.size(); i++) {
            System.out.println(trays.get(i));
        }
    }
    public void displayTray(int index) {
        System.out.println(trays.get(index));
    }
    public void displayTray(DisplayTray tray) {
        System.out.println(tray);
    }




}
