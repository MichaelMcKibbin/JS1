package com.michaelmckibbin.js1;

import java.util.HashSet;
import java.util.Set;

public class TrayManager {
    private static Set<String> existingTrayIds = new HashSet<>();

    public static boolean createTray(DisplayCase selectedCase, String userInput) {
        // Generate the tray ID based on the user input
        String trayId = generateTrayId(userInput);

        // Check if the tray ID is valid and unique
        if (trayId != null && !existingTrayIds.contains(trayId)) {
            DisplayTray newTray = new DisplayTray(trayId);
            selectedCase.addDisplayTray(newTray);
            existingTrayIds.add(trayId); // Add the new tray ID to the set
            return true; // Tray creation successful
        } else if (trayId == null) {
            showErrorMessage("Invalid tray ID format. Please try again.");
        } else {
            showErrorMessage("Tray ID already exists. Please enter a different ID.");
        }
        return false; // Tray creation failed
    }

    // Other methods for managing trays and cases
    // ...
}

