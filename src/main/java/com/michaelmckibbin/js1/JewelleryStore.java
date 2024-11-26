/**
 * This is the main class for the Jewellery Store application.
 * It extends the Application class and implements the Serializable interface.
 * The class is responsible for setting up the main stage and scene of the application.
 * It also contains the main method which launches the JavaFX application.
 * <p>
 * Implements Serializable to support potential state saving/loading,
 * though note that JavaFX components themselves are not serializable.
 */
package com.michaelmckibbin.js1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class JewelleryStore extends Application implements Serializable {
    public static Scene scene;
    public static Stage primarystage;


// Note to self: fxml loader wouldn't work until changed to getClassLoader

    @Override
    public void start(Stage stage) throws IOException {
        primarystage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Storefront-view.fxml"));
        scene = new Scene(fxmlLoader.load());

        // load the CSS file
        scene.getStylesheets().addAll("styles.css");

        stage.setTitle("Jewellery Store");
        stage.setScene(scene);
        stage.show();
        System.out.println("JewelleryStore.start");
        
    }


//    // with error checking
//    @Override
//    public void start(Stage stage) throws IOException {
//        try {
//            primarystage = stage;
//            var resource = getClass().getClassLoader().getResource("Storefront-view.fxml");
//            if (resource == null) {
//                throw new IOException("Failed to load Storefront-view.fxml");
//            }
//            FXMLLoader fxmlLoader = new FXMLLoader(resource);
//            // ... rest of the code
//        } catch (IOException e) {
//            System.err.println("Failed to initialize application: " + e.getMessage());
//            throw e;
//        }
//    }


    public static void main(String[] args) {
        launch();
    }


}