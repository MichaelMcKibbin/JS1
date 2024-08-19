package com.michaelmckibbin.js1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class JewelleryStore extends Application {
    public static Scene storefrontscene, displaycasescene, displaytrayscene, jitemscene, jmaterialscene, allstockscene;
    public static Stage mainstage;


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
        mainstage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Storefront-view.fxml"));
        storefrontscene = new Scene(fxmlLoader.load(), 900, 400);

        // load the CSS file
        storefrontscene.getStylesheets().addAll("styles.css");

        stage.setTitle("Jewellery Store");
        stage.setScene(storefrontscene);
        stage.show();
    }

    // scene.getStylesheets().addAll("styles.css");
    // stage.setTitle("Jewellery*Store");


    public static void main(String[] args) {
        launch();
    }


}