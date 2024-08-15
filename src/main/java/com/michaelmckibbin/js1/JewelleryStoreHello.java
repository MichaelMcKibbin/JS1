package com.michaelmckibbin.js1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JewelleryStoreHello {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}