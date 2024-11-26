package com.michaelmckibbin.js1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayTrayTest {

    @BeforeEach
    void setUp() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
    }

    @AfterEach
    void tearDown() {
        DisplayTray displayTray = null;
    }

    @Test
    void getTrayID() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
        assertEquals("Z123", displayTray.getTrayID());
    }

    @Test
    void setTrayID() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
        displayTray.setTrayID("Z456");
        assertEquals("Z456", displayTray.getTrayID());
    }

    @Test
    void getTrayColor() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
        assertEquals("red", displayTray.getTrayColor());
    }

    @Test
    void setTrayColor() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
        displayTray.setTrayColor("blue");
        assertEquals("blue", displayTray.getTrayColor());
    }

    @Test
    void getTrayWidth() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
        assertEquals(50, displayTray.getTrayWidth());
    }

    @Test
    void setTrayWidth() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
        displayTray.setTrayWidth(60);
        assertEquals(60, displayTray.getTrayWidth());
    }

    @Test
    void getTrayDepth() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
        assertEquals(50, displayTray.getTrayDepth());
    }

    @Test
    void setTrayDepth() {
        DisplayTray displayTray = new DisplayTray("Z123", "red", 50, 50);
        displayTray.setTrayDepth(60);
        assertEquals(60, displayTray.getTrayDepth());
    }

}