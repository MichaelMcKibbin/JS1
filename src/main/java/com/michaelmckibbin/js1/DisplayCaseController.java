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

public class DisplayCaseController {



    @FXML
    private Button displayCasesButton;
    @FXML
    private Button displayTraysButton;
    @FXML
    private Button jewelleryItemsButton;
    @FXML
    private Button jewelleryMaterialsButton;
    @FXML
    private Button DC2Storefront;



    @FXML
    public void handleDisplayCasesButtonClick(ActionEvent actionEvent) {
        System.out.println("in DC Controller. Display cases button clicked!");
    }
    @FXML
    public void handleDisplayTraysButtonClick(ActionEvent actionEvent) {
        System.out.println("in DC Controller. Display trays button clicked!");
    }
    @FXML
    public void handleJewelleryItemsButtonClick(ActionEvent actionEvent) {
        System.out.println("in DC Controller. Jewellery items button clicked!");
    }
    @FXML
    public void handleJewelleryMaterialsButtonClick(ActionEvent actionEvent) {
        System.out.println("in DC Controller. Jewellery materials button clicked!");
    }
    @FXML
    public void handleGenericButtonClick(ActionEvent actionEvent) {
        System.out.println("Generic button clicked!");
    }
//    @FXML
//    public void handleDC2StorefrontButtonClick(ActionEvent actionEvent) {
//        System.out.println("in DC Controller. DC2 Storefront button clicked!");
//        // open Storefront-view.fxml in a new window
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Storefront-view.fxml"));
////            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/resources/Storefront-view.fxml"));
//            Parent root = loader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//
////            // Apply the CSS file to the scene
////
////            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());
////            stage.setScene(scene);
//
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
@FXML
public void handleDC2StorefrontButtonClick(ActionEvent actionEvent) {
    System.out.println("in DC Controller. DC2 Storefront button clicked!");
    // open Storefront-view.fxml in a new window
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Storefront-view.fxml"));
        Parent root = loader.load();

        // Create the Scene object
        Scene scene = new Scene(root);

        // Apply the CSS file to the scene
        scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Storefront");

        // Get the current stage (window) and close it
        Stage currentStage = (Stage) DC2Storefront.getScene().getWindow();
        currentStage.close();

        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}