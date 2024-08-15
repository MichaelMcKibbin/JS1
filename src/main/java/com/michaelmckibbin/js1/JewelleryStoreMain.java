package com.michaelmckibbin.js1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class JewelleryStoreMain extends Application {

    public static Scene storefrontscene, displaycasescene, displaytrayscene, jitemscene, jmaterialscene, allstockscene;
    public static Stage mainstage;

// ** error ** fxml loader wouldn't work until changed to getClassLoader
//    @Override
//    public void start(Stage stage) throws IOException {
//        mainstage = stage;
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("hello-view.fxml"));
//        storefrontscene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(storefrontscene);
//        stage.show();
//    }

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


//    public static void showstorefrontscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("src/main/resources/com/michaelmckibbin/js1/views/hello-view.fxml"));
//        storefrontscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainstage.setScene(storefrontscene);
//    }
//
//    public static void showdisplaycasescene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("Displaycase-view.fxml"));
//        displaycasescene = new Scene(fxmlLoader.load(), 900, 400);
//        mainstage.setScene(displaycasescene);
//    }
//    public static void showdisplaytrayscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("Displaytray-view.fxml"));
//        displaytrayscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainstage.setScene(displaytrayscene);
//    }
//    public static void showjitemscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("JewelleryItem-view.fxml"));
//        jitemscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainstage.setScene(jitemscene);
//    }
//    public static void showjmaterialscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("JewelleryMaterial-view.fxml"));
//        jmaterialscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainstage.setScene(jmaterialscene);
//    }
//    public static void showallstockscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("AllStock-view.fxml"));
//        allstockscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainstage.setScene(allstockscene);
//    }
    private Image originalImage;

    @FXML
    private Button mikeyFaceButton;

    @FXML
    private ImageView mikeyFaceImageView;

    @FXML
    private void initialize() {
        originalImage = mikeyFaceImageView.getImage();
    }

    @FXML
    private void handleMikeyFaceButtonClick(ActionEvent event) {
        if (mikeyFaceImageView.getImage() == originalImage) {
            Image goldBarsImage = new Image(getClass().getResourceAsStream("/images/goldBars.jpg"));
            mikeyFaceImageView.setImage(goldBarsImage);
            mikeyFaceButton.setText("50% Off Gold Bars!");
        } else {
            mikeyFaceImageView.setImage(originalImage);
            mikeyFaceButton.setText("Ask for details!");
        }
    }


    public static void main(String[] args) {
        launch();
    }


}