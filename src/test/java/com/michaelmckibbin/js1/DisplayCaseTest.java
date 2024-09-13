package com.michaelmckibbin.js1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayCaseTest {

    @Test
    void getDisplayTrays() {
        DisplayCase displayCase = new DisplayCase(1, false, false);
        MyLinkedList<DisplayTray> displayTrays = new MyLinkedList<>();
        displayCase.displayTrays = displayTrays;
        assertEquals(displayTrays, displayCase.getDisplayTrays());
    }

    @Test
    void getCaseId() {
        DisplayCase displayCase = new DisplayCase(1, false, false);
        assertEquals(1, displayCase.getCaseId());
    }

    @Test
    void setCaseID() {
        DisplayCase displayCase = new DisplayCase(1, false, false);
        displayCase.setCaseID(2);
        assertEquals(2, displayCase.getCaseId());
    }

    @Test
    void isWall() {
        DisplayCase displayCase = new DisplayCase(1, false, false);
        assertFalse(displayCase.isWall());
    }

    @Test
    void setWall() {
        DisplayCase displayCase = new DisplayCase(1, false, false);
        displayCase.setWall(true);
        assertTrue(displayCase.isWall());
    }

    @Test
    void isLit() {
        DisplayCase displayCase = new DisplayCase(1, false, false);
        assertFalse(displayCase.isLit());
    }

    @Test
    void setLit() {
        DisplayCase displayCase = new DisplayCase(1, false, false);
        displayCase.setLit(true);
        assertTrue(displayCase.isLit());
    }

    @Test
    void testToString() {
        DisplayCase displayCase = new DisplayCase(1, false, false);
        assertEquals("DisplayCase{caseID=1, isWall=false, isLit=false}", displayCase.toString());
    }



}