package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static com.michaelmckibbin.js1.DisplayCaseController.displayCases;

public class JewelleryMaterialController implements Serializable {

    @FXML
    public Pane listAllCasesPane;
    @FXML
    public Button listAllMaterialsButton;
    @FXML
    public TextField materialsSearchField;
    @FXML
    public Button displayCaseViewItemSearchButton;
    @FXML
    public VBox materialsListVBox;
    @FXML
    public VBox materialsResultsVBox;
    @FXML
    public Button addJewelleryMaterialButton;
    @FXML
    public TextField addJewelleryMaterialDisplayCaseIdTextField;
    @FXML
    public TextField addJewelleryMaterialDisplayTrayIdTextField;
    @FXML
    public TextField addJewelleryMaterialIdTextField;
    @FXML
    public TextField addJewelleryMaterialNameTextField;
    @FXML
    public TextField addJewelleryMaterialDescriptionTextField;
    @FXML
    public TextField addJewelleryMaterialQuantityTextField;
    @FXML
    public TextField addJewelleryMaterialPriceTextField;
    @FXML
    public TextField addJewelleryMaterialImageUrlTextField;
    @FXML
    public ChoiceBox addJewelleryMaterialUnitTypeChoiceBox;
    @FXML
    public TextField addJewelleryMaterialJewelleryItemIdTextField;
    @FXML
    public TextField addJewelleryMaterialQualityTextField;
    @FXML
    public TextField materialsSearchTextField;


    @FXML
    public void initialize() {
        // initialise the VBox list display
        //populate....();

        // populate the jewelleryMaterialUnitTypeChoiceBox
        addJewelleryMaterialUnitTypeChoiceBox.getItems().addAll("Grams", "Karats", "oz", "cm", "Other");
        // Set the default value for the jewelleryMaterialUnitTypeChoiceBox
        addJewelleryMaterialUnitTypeChoiceBox.setValue("Other");

    }

    /*
         Navigation Buttons - copy to other views as required
          */
    @FXML
    private Button displayCasesButton;
    @FXML
    private Button displayTraysButton;
    @FXML
    private Button jewelleryItemsButton;
    @FXML
    private Button jewelleryMaterialsButton;
    @FXML
    private Button StorefrontButton;
    @FXML
    private Button onListAllMaterialsButton;


    @FXML
    public void handleStorefrontButtonClick(ActionEvent actionEvent) {
        System.out.println("Storefront button clicked!");
        // open Storefront-view.fxml in a new window
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Storefront-view.fxml"));
            Parent root = loader.load();


//            // option without css
//            // Create a new stage and set the scene
//            Stage stage = new Stage();
//            stage.setTitle("..."); // Set the stage title
//            stage.setScene(new Scene(root, 800, 600)); // Set the scene size
//            // option without css

            // option with css from styles.css in resources folder
            // Create the Scene object
            Scene scene = new Scene(root);

            // Apply the CSS file to the scene
            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Storefront");
            // end of option with css from styles.css in resources folder


            // Get the current stage (window) and close it
            Stage currentStage = (Stage) StorefrontButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDisplayCasesButtonClick(ActionEvent actionEvent) {
        System.out.println("Display cases button clicked!");
        // open DisplayCase-view.fxml
        try {
            // Load the view
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("DisplayCase-view.fxml"));
            Parent root = loader.load();

//            // option without css
//            // Create a new stage and set the scene
//            Stage stage = new Stage();
//            stage.setTitle("DC View"); // Set the stage title
//            stage.setScene(new Scene(root, 800, 600)); // Set the scene size
//            // option without css

            // option with css from styles.css in resources folder
            // Create the Scene object
            Scene scene = new Scene(root);

            // Apply the CSS file to the scene
            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Display Cases");
            // end of option with css from styles.css in resources folder

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) displayCasesButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleDisplayTraysButtonClick(ActionEvent actionEvent) {
        System.out.println("Display trays button clicked!");
        // open DisplayCase-view.fxml
        try {
            // Load the view
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("DisplayTray-view.fxml"));
            Parent root = loader.load();


//            // option without css
//            // Create a new stage and set the scene
//            Stage stage = new Stage();
//            stage.setTitle("..."); // Set the stage title
//            stage.setScene(new Scene(root, 800, 600)); // Set the scene size
//            // option without css

            // option with css from styles.css in resources folder
            // Create the Scene object
            Scene scene = new Scene(root);

            // Apply the CSS file to the scene
            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Display Trays");
            // end of option with css from styles.css in resources folder


            // Get the current stage (window) and close it
            Stage currentStage = (Stage) displayTraysButton.getScene().getWindow();
            currentStage.close();

            stage.show();
            //stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void handleJewelleryItemsButtonClick(ActionEvent actionEvent) {
        System.out.println("Jewellery items button clicked!");
        // open JewelleryItem-view.fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("JewelleryItem-view.fxml"));
            Parent root = loader.load();


//            // option without css
//            // Create a new stage and set the scene
//            Stage stage = new Stage();
//            stage.setTitle("..."); // Set the stage title
//            stage.setScene(new Scene(root, 800, 600)); // Set the scene size
//            // option without css

            // option with css from styles.css in resources folder
            // Create the Scene object
            Scene scene = new Scene(root);

            // Apply the CSS file to the scene
            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Jewellery Items");
            // end of option with css from styles.css in resources folder


            // Get the current stage (window) and close it
            Stage currentStage = (Stage) jewelleryItemsButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleJewelleryMaterialsButtonClick(ActionEvent actionEvent) {
        System.out.println("Jewellery materials button clicked!");
        // open JewelleryMaterial-view.fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("JewelleryMaterial-view.fxml"));
            Parent root = loader.load();


//            // option without css
//            // Create a new stage and set the scene
//            Stage stage = new Stage();
//            stage.setTitle("..."); // Set the stage title
//            stage.setScene(new Scene(root, 800, 600)); // Set the scene size
//            // option without css

            // option with css from styles.css in resources folder
            // Create the Scene object
            Scene scene = new Scene(root);

            // Apply the CSS file to the scene
            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Materials");
            // end of option with css from styles.css in resources folder

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) jewelleryMaterialsButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    End of Navigation Buttons
     */

    @FXML
    public void onListAllMaterialsButton(ActionEvent actionEvent) {
        System.out.println("List all materials button clicked!");

    }

    @FXML
    public void addJewelleryMaterialButton(ActionEvent actionEvent) {
        System.out.println("Add jewellery material button clicked!");
//TODO add functionality
    }

    @FXML
    public void handleMaterialsSearchButton(ActionEvent actionEvent) {

        System.out.println("Search materials button clicked!");

        //TODO: Implement the search functionality
        String searchQuery = materialsSearchTextField.getText();

    }


}