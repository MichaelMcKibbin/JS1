package com.michaelmckibbin.js1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

// add css to application


//public class JewelleryStoreController implements Initializable {
public class JewelleryStoreController {


//    // for testing
//    @FXML
//    public Text loginBoxActionMessage;
//
//    @FXML
//    public Button loginButton;
//
//    @FXML
//    public void handleLoginButtonAction(ActionEvent actionEvent) {
//        loginBoxActionMessage.setText("Login button clicked!");
//        System.out.println("Login button clicked!");
//        System.out.println("in handleLoginButtonAction");
//        System.out.println("in JewelleryStoreController");
//        // TODO - add login function
//        // open Storefront-view
//
//    } // end of for testing


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
    @FXML
    private Button displayCasesButton;
    @FXML
    private Button displayTraysButton;
    @FXML
    private Button jewelleryItemsButton;
    @FXML
    private Button jewelleryMaterialsButton;


    @FXML
    public void handleDisplayCasesButtonClick(ActionEvent actionEvent) {
        System.out.println("Display cases button clicked!");
//        System.out.println("in handleDisplayCasesButtonClick");
//        System.out.println("in JewelleryStoreController");
        // open DisplayCases-view.fxml
        try {
            // Load the view
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("DisplayCase-view.fxml"));
            Parent root = loader.load();

            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("DC View"); // Set the stage title
            stage.setScene(new Scene(root, 800, 600)); // Set the scene size

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) displayCasesButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


//
//            try {
//            // Load the view
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayCase-view.fxml"));
//            Parent root = loader.load();
//
//            // Create a new stage and set the scene
//            Stage stage = new Stage();
//            stage.setTitle("*DC view*"); // Set the stage title
//            stage.setScene(new Scene(root, 800, 600)); // Set the scene size
//
////            // Get the current stage (window) and close it
////            Stage currentStage = (Stage) helloButton.getScene().getWindow();
////            currentStage.close();
//
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//


    }


    @FXML
    public void handleDisplayTraysButtonClick(ActionEvent actionEvent) {
        System.out.println("Display trays button clicked!");
    }
    @FXML
    public void handleJewelleryItemsButtonClick(ActionEvent actionEvent) {
        System.out.println("Jewellery items button clicked!");
    }
    @FXML
    public void handleJewelleryMaterialsButtonClick(ActionEvent actionEvent) {
        System.out.println("Jewellery materials button clicked!");
    }
    @FXML
    public void handleGenericButtonClick(ActionEvent actionEvent) {
        System.out.println("Generic button clicked!");
    }


}


