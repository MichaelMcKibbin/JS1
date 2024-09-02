package com.michaelmckibbin.js1;

import static com.michaelmckibbin.js1.DisplayCaseController.displayCases;

public class DisplayCase {

    public int caseID;
    public boolean isWall = false; // false = floor, true = wall
    public boolean isLit = false;  // false = not lit, true = lit
    public MyLinkedList<DisplayTray> displayTrays;
    private int caseId;

    public DisplayCase(int caseID, boolean isWall, boolean isLit) {
        this.caseID = caseID;
        this.isWall = isWall;
        this.isLit = isLit;
        this.displayTrays = new MyLinkedList<>();
    }

//    public static void initializeDisplayTrays() {
//        DisplayTray displayTray1 = new DisplayTray("Z999", "Black", 10, 10);
//        DisplayTray displayTray2 = new DisplayTray("Z888", "White", 10, 10);
//        DisplayTray displayTray3 = new DisplayTray("Z777", "Red", 10, 10);
//        DisplayTray displayTray4 = new DisplayTray("Z666", "Green", 10, 10);
//    }

    public MyLinkedList<DisplayTray> getDisplayTrays() {
        return displayTrays;
    }

    public int getCaseId() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }
    public boolean isWall() {
        return isWall;
    }
    public void setWall(boolean wall) {
        isWall = wall;
    }
    public boolean isLit() {
        return isLit;
    }
    public void setLit(boolean lit) {
        isLit = lit;
    }
//    public MyLinkedList<DisplayTray> getDisplayTrays() {
//        return displayTrays;
//    }
//    public void setDisplayTrays(MyLinkedList<DisplayTray> displayTrays) {
//        this.displayTrays = displayTrays;
//    }
//    public void addDisplayTray(DisplayTray displayTray) {
//        displayTrays.add(displayTray);
//    }
//    public void removeDisplayTray(DisplayTray displayTray) {
//        displayTrays.remove(displayTray);
//    }




    @Override
    public String toString() {
        return "DisplayCase{" +
                "caseID=" + caseID +
                ", isWall=" + isWall +
                ", isLit=" + isLit +
                '}';
    }


    public void addDisplayTray(DisplayTray newTray) {
        displayTrays.add(newTray);
    }

    public DisplayTray findDisplayTrayById(String trayId) {
        for (DisplayTray tray : displayTrays) {
            if (tray.getTrayId().equals(trayId) && tray.getCaseId() == this.caseId) {
                return tray;
            }
        }
        return null;
    }

    public DisplayCase findDisplayCaseById(int caseId) {
        for (DisplayCase displayCase : displayCases) {
            if (displayCase.getCaseId()==(caseId)) {
                return displayCase;
            }
        }
        return null; // Return null if no matching DisplayCase is found
    }
}
