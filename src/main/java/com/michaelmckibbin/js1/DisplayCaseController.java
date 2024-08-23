package com.michaelmckibbin.js1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class DisplayCaseController {

    public static MyLinkedList<DisplayCase> displayCases = new MyLinkedList<>();

    @FXML public TextField CaseSearchBtn;
    @FXML public CheckBox CheckBoxWallMounted;
    @FXML public Button deleteAllCasesButton;
    @FXML public Pane deleteAllCasesPane;
    @FXML public Pane listAllCasesPane;
    @FXML public Button listAllCasesButton;
    @FXML public Button AddCaseBtn;

    @FXML
    private ListView<DisplayCase> displayCasesListView;

    @FXML
    private Label nextCaseIdLabel;


    public DisplayCaseController() {
       //initializeDisplayCases();
    }

    @FXML
    public void initialize() {
        populateDisplayCasesVBox();
        //initializeDisplayCases();
        // Initialization code here
        //nextCaseIdLabel.setText("Next Case ID: " + getNextCaseID());
    }

    void initializeDisplayCases() {
        // Add initial test data.
        //System.out.println("To add some test data, uncomment the code in initializeDisplayCases(), in DisplayCaseController.java");
//        DisplayCase displayCase1 = new DisplayCase(999, false, false);
//        displayCase1.addDisplayTray(new DisplayTray("Z999", "Red", 10, 20));
//        displayCases.add(displayCase1);
//
//        DisplayCase displayCase2 = new DisplayCase(998, true, true);
//        displayCase2.addDisplayTray(new DisplayTray("Z998", "Blue", 15, 25));
//        displayCases.add(displayCase2);
//
//        DisplayCase displayCase3 = new DisplayCase(997, false, true);
//        displayCase3.addDisplayTray(new DisplayTray("Z997", "Green", 8, 18));
//        displayCases.add(displayCase3);
//
//        DisplayCase displayCase4 = new DisplayCase(996, true, false);
//        displayCase4.addDisplayTray(new DisplayTray("Z996", "Yellow", 12, 22));
//        displayCases.add(displayCase4);

//        // Populate the displayTrays list in the DisplayTrayController
//        for (DisplayCase displayCase : displayCases) {
//            displayTrays.addAll(displayCase.getDisplayTrays());
//        }

//        for (DisplayCase displayCase : displayCases) {
//            System.out.println("CaseID : " + displayCase.getCaseId());
//            for (DisplayTray displayTray : displayCase.getDisplayTrays()) {
//                System.out.println(displayTray);
//            }
//            System.out.println();
//        }
}

    @FXML
    private VBox displayCasesVBox;

    public void populateDisplayCasesVBox() {
        displayCasesVBox.getChildren().clear(); // Clear the VBox first
        for (DisplayCase displayCase : displayCases) {
            // Create a UI element for each display case (e.g., a Label or a custom control)
            Label displayCaseLabel = new Label(displayCase.toString());
            displayCasesVBox.getChildren().add(displayCaseLabel);
        }
    }

    @FXML
    private VBox displayCaseSearchResultVBox;

    public void displayCaseSearchResult(DisplayCase foundCase) {
        displayCaseSearchResultVBox.getChildren().clear(); // Clear the VBox first

//        for (DisplayCase displayCase : displayCases) {
//            // Create a UI element for each display case (e.g., a Label or a custom control)
//            Label displayCaseSearchResultLabel = new Label(displayCase.toString());
//            displayCaseSearchResultVBox.getChildren().add(displayCaseSearchResultLabel);
//        }
        if (foundCase != null) {
            // Create a UI element for the found display case (e.g., a Label or a custom control)
            Label displayCaseLabel = new Label(foundCase.toString());
            displayCaseSearchResultVBox.getChildren().add(displayCaseLabel);
        } else {
            // Display a message when no case is found
            Label noResultLabel = new Label("No DisplayCase found");
            displayCaseSearchResultVBox.getChildren().add(noResultLabel);
        }

    }


    public void populateDisplayCasesList() {
        displayCasesListView.getItems().clear(); // Clear the list first

        // Convert MyLinkedList to an ObservableList
        ObservableList<DisplayCase> observableDisplayCases = FXCollections.observableList((List<DisplayCase>) displayCases);

        displayCasesListView.setItems(observableDisplayCases); // Set the ObservableList to the ListView
    }


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

        // add a new case to the list
        displayCases.add(newDisplayCase);
        System.out.println("New case added: " + newDisplayCase);

    }
    public DisplayCase findDisplayCaseById(int caseId) {
        for (DisplayCase displayCase : displayCases) {
            if (displayCase.getCaseId()==(caseId)) {
                return displayCase;
            }
        }
        return null; // Return null if no matching DisplayCase is found
    }
    @FXML
    private TextField displayCaseSearchField;

    @FXML
    private void handleDisplayCaseSearchButton() {
        String input = displayCaseSearchField.getText().trim(); // get input and remove any leading or trailing whitespace

//        // before input validation
//        DisplayCase foundCase = findDisplayCaseById(Integer.parseInt(caseId));
//        if (foundCase != null) {
//            // Display the found DisplayCase or perform other actions
//            System.out.println("Found DisplayCase: " + foundCase);
//            displayCaseSearchResult(foundCase);
//
//        } else {
//            System.out.println("No DisplayCase found with caseId: " + caseId);
//        }

        // with input validation
        if (input.isEmpty()) {
            //System.out.println("Please enter a caseId to search.");
            displayCaseSearchResult(null); // Clear the search result if the input is empty
            showErrorMessage("Invalid input. Please enter a number.");
            return;
        }
        // Check if the input is a valid number
        if (!isNumeric(input)) {
            displayCaseSearchResult(null); // Clear the search result
            showErrorMessage("Invalid input. Please enter a number.");
            return;
        }

        String caseId = input;
        //System.out.println("Searching for: " + caseId);
        DisplayCase foundCase = findDisplayCaseById(Integer.parseInt(caseId));
        displayCaseSearchResult(foundCase);
        //System.out.println("Found DisplayCase: " + foundCase);

    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str); // Try to parse the string as a double
        } catch (NumberFormatException e) {
            return false; // Return false if the string cannot be parsed as a number
        }
        return true;
    }
    private void showErrorMessage(String message) {
        // Display the error message to the user (e.g., using an Alert dialog or a Label)
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void onDeleteAllCasesButton(ActionEvent actionEvent) {
        System.out.println("Delete all cases button clicked!");
//        displayCases.clear(); // short & immediate!
        showConfirmationDialog(); // a better way. confirm choice.
    }
    @FXML
    public void onListAllCasesButton(ActionEvent actionEvent) {
        System.out.println("List all cases button clicked!");
        // print list of displaycases
        System.out.println("Display cases:");
        for (DisplayCase displayCase : displayCases) {
            System.out.println(displayCase);
        }

        populateDisplayCasesVBox();
    }

    public void listAllCases() {
        System.out.println("Display cases:");
        for (DisplayCase displayCase : displayCases) {
            System.out.println(displayCase);
        }
    }

    public void viewAllCases() {
        System.out.println("Display cases:");
        // add each case to a table view
        for (DisplayCase displayCase : displayCases) {

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