package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DisplayCaseController {
    public static MyLinkedList<DisplayCase> displayCases = new MyLinkedList<>();
    public TextField CaseSearchBtn;
    public CheckBox CheckBoxWallMounted;
    public Button deleteAllCasesButton;
    public Pane deleteAllCasesPane;
    public Pane listAllCasesPane;
    public Button listAllCasesButton;

    public DisplayCaseController() {
       // initializeDisplayCases();
    }

    void initializeDisplayCases() {
        // Add initial display cases to the list
        System.out.println("To add some test data, uncomment the code in initializeDisplayCases(), in DisplayCaseController.java");
//        displayCases.add(new DisplayCase(901, false, false));
//        displayCases.add(new DisplayCase(902, true, true));
//        displayCases.add(new DisplayCase(903, false, true));
//        displayCases.add(new DisplayCase(904, true, false));
        // Add more display cases as needed
    }


    public Button AddCaseBtn;

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
    public void loadTestData(ActionEvent actionEvent) {
        System.out.println("loadTestData button clicked!");
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


    private int getNextCaseID() {
        int nextCaseID = displayCases.size() + 1;
        boolean idExists;

        do {
            idExists = false;
            for (DisplayCase displayCase : displayCases) {
                if (displayCase.getCaseId() == nextCaseID) {
                    idExists = true;
                    nextCaseID++;
                    break;
                }
            }
        } while (idExists);

        return nextCaseID;
    }
    @FXML
    public void onAddCaseBtn(ActionEvent actionEvent) {
        System.out.println("Add case button clicked!");
        // get next caseID using (displayCases.size() + 1)
        DisplayCase newDisplayCase = new DisplayCase(getNextCaseID(), false, false);
        displayCases.add(newDisplayCase);

        
        // add a new case to the list
       // displayCases.add(new DisplayCase(getNextCaseID(), false, false));
    }


    public void onDeleteAllCasesButton(ActionEvent actionEvent) {
        System.out.println("Delete all cases button clicked!");
//        displayCases.clear(); // short & immediate!
        showConfirmationDialog(); // a better way. confirm choice.
    }

    public void onListAllCasesButton(ActionEvent actionEvent) {
        System.out.println("List all cases button clicked!");
        // print list of displaycases
        System.out.println("Display cases:");
        for (DisplayCase displayCase : displayCases) {
            System.out.println(displayCase);
        }
    }

    private void showConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete All Display Cases!");
        alert.setHeaderText("Are you sure you want to delete all display cases?");
        alert.setContentText("This action cannot be undone!");

        ButtonType confirmButton = new ButtonType("Delete");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(confirmButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == confirmButton) {
            deleteAllCases();
        }
    }

    private void deleteAllCases() {
        displayCases.clear();
    }
}