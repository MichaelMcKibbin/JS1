package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class OLDJewelleryStoreController {

    @FXML
    private Parent displayCaseScene;

    @FXML
    private Stage mainStage;

    @FXML
    private void initialize() {
        originalImage = mikeyFaceImageView.getImage();
//        try {
//            displayCaseScene = FXMLLoader.load(getClass().getResource("DisplayCase-view.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    private void handleDisplayCasesButtonClick(ActionEvent event) {
        switchToDisplayCaseScene();
    }

    private void switchToDisplayCaseScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayCase-view.fxml"));
            Parent displayCaseRoot = loader.load();

            Scene displayCaseScene = new Scene(displayCaseRoot);
            mainStage.setScene(displayCaseScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @FXML
//    private void handleDisplayCasesButtonClick(ActionEvent event) {
//        try {
//            displayCaseScene = FXMLLoader.load(getClass().getResource("DisplayCase-view.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    @FXML
//    private void handleDisplayCasesButtonClick(ActionEvent event) {
//        Scene scene = new Scene(displayCaseScene);
//        mainStage.setScene(scene);
//    }

//    public void setMainStage(Stage stage) {
//        this.mainStage = stage;
//    }
public void setSceneOnMainStage(Parent root) {
    Scene scene = new Scene(root);
    mainStage.setScene(scene);
}

    /*
    Image button on storefront
     */
    private Image originalImage;

    @FXML
    private Button mikeyFaceButton;

    @FXML
    private ImageView mikeyFaceImageView;

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
    /*
    end of image button on storefront
     */
}
