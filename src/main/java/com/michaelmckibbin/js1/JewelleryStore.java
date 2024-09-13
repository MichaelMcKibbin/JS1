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


// ** error ** fxml loader wouldn't work until changed to getClassLoader
//    @Override
//    public void start(Stage stage) throws IOException {
//        mainstage = stage;
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStore.class.getResource("hello-view.fxml"));
//        storefrontscene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(storefrontscene);
//        stage.show();
//    }
//    public static DisplayCase firstCase;
//    public static Stage primaryStage;

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
    }


    public static void main(String[] args) {
        launch();
    }


}