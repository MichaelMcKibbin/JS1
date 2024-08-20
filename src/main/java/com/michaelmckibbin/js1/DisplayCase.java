package com.michaelmckibbin.js1;

public class DisplayCase {

    public int caseID;
    public boolean isWall = false; // false = floor, true = wall
    public boolean isLit = false;  // false = not lit, true = lit


    //public MyLinkedList<DisplayTray> trays = new MyLinkedList<>();

    public DisplayCase(){}

    public DisplayCase(int caseID, boolean isWall, boolean isLit) {
        this.caseID = caseID;
        this.isWall = isWall;
        this.isLit = isLit;

       // this.trays = new MyLinkedList<>();
    }

    public int getCaseID() {
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
    @Override
    public String toString() {
        return "DisplayCase{" +
                "caseID=" + caseID +
                ", isWall=" + isWall +
                ", isLit=" + isLit +
                '}';
    }






}
