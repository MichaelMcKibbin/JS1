package com.michaelmckibbin.js1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static SceneManager instance;
    private Stage primaryStage;

    private SceneManager() {}

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void loadStorefrontView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Storefront-view.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    // Add methods to load other views as needed
}


