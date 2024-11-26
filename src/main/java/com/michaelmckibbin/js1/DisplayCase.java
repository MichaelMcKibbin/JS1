/**
 * This class represents a display case in the store.
 * Cases are identified by a unique ID, and whether it's wall-mounted, freestanding, lit or not.
 * Each display case contains a linked list of display trays.
 *
 *
 * @author Michael McKibbin
 * @version 1.0
 */
package com.michaelmckibbin.js1;

import com.michaelmckibbin.js1.DisplayTray;
import com.michaelmckibbin.js1.MyLinkedList;

import java.io.Serializable;

import static com.michaelmckibbin.js1.DisplayCaseController.displayCases;

public class DisplayCase implements Serializable {

    public String caseID;
    public boolean isWall = false; // false = floor, true = wall
    public boolean isLit = false;  // false = not lit, true = lit
    public MyLinkedList<DisplayTray> displayTrays;
    private int caseId;

    public DisplayCase(String caseID, boolean isLit, boolean isWall) {
        this.caseID = caseID;
        this.isWall = isWall;
        this.isLit = isLit;
        this.displayTrays = new MyLinkedList<>();
    }
//      sample data for testing
//    public static void initializeDisplayTrays() {
//        DisplayTray displayTray1 = new DisplayTray("Z999", "Black", 10, 10);
//        DisplayTray displayTray2 = new DisplayTray("Z888", "White", 10, 10);
//        DisplayTray displayTray3 = new DisplayTray("Z777", "Red", 10, 10);
//        DisplayTray displayTray4 = new DisplayTray("Z666", "Green", 10, 10);
//    }

    public MyLinkedList<DisplayTray> getDisplayTrays() {
        return displayTrays;
    }

    public String getCaseId() {
        return caseID;
    }

    public void setCaseID(String caseID) {
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

//    public String getLocation() {
//        return isWall ? "Wall mounted" : "Free standing";
//    }
//
//    public void getLighting() {
//        if (isLit) {
//            System.out.println("With Display Lighting");
//        } else {
//            System.out.println("");
//        }
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
            if (displayCase.getCaseId().equals(caseId)) {
                return displayCase;
            }
        }
        return null; // Return null if no matching DisplayCase is found
    }

    public JewelleryItem findJewelleryItemById(String itemId) {
        for (DisplayTray tray : displayTrays) {
            JewelleryItem item = tray.findJewelleryItemById(Integer.parseInt(itemId));
            if (item != null) {
                return item;
            }
        }
        return null;
    }

}
