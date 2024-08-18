package com.michaelmckibbin.js1;

public class DisplayCase {

    public int displayCaseID;
    public boolean displayCaseIsWallMounted = false; // false = floor, true = wall
    public boolean displayCaseIsLit = false;  // false = not lit, true = lit


    //public MyLinkedList<DisplayTray> trays = new MyLinkedList<>();

    public DisplayCase(int caseID, boolean dcWall, boolean dcLit) {
        displayCaseID = caseID;
        displayCaseIsWallMounted = dcWall;
        displayCaseIsLit = dcLit;
       // this.trays = new MyLinkedList<>();
    }





}
