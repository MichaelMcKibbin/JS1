package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class JewelleryItemController implements Serializable {


    /*
MENUBAR
 */
    public void loadFile(ActionEvent actionEvent) {
        System.out.println("Load file button clicked!");
    }
    public void saveFile(ActionEvent actionEvent) {
        System.out.println("Save file button clicked!");
    }
    public void saveAndExit(ActionEvent actionEvent) {
        System.out.println("Save and exit button clicked!");
    }
    public void closeProg(ActionEvent actionEvent) {
        System.out.println("Close program button clicked!");
    }
    public void deleteAllStock(ActionEvent actionEvent) {
        System.out.println("Delete all stock button clicked!");
    }
    public void viewAllStock(ActionEvent actionEvent) {
        System.out.println("View all stock button clicked!");
    }
    public void drillDown(ActionEvent actionEvent) {
        System.out.println("Drill down button clicked!");
    }
    public void viewAbout(ActionEvent actionEvent) {
        System.out.println("viewAbout button clicked!");
    }
    public void viewReadme(ActionEvent actionEvent) {
        System.out.println("viewReadme button clicked!");
    }


    /*
    END OF MENUBAR
     */


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
    private Button genericButton;



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


    @FXML
    public void handleGenericButtonClick(ActionEvent actionEvent) {
        System.out.println("Generic button clicked!");
    }

    /*
    End of Navigation Buttons
     */




    public void onAddJewelleryItemBtn(ActionEvent actionEvent) {
    }


}
