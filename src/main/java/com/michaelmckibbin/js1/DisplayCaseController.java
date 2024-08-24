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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayCaseController {

    public static MyLinkedList<DisplayCase> displayCases = new MyLinkedList<>();

    @FXML public TextField CaseSearchBtn;
    @FXML public CheckBox CheckBoxWallMounted;
    @FXML public Button deleteAllCasesButton;
    @FXML public Pane deleteAllCasesPane;
    @FXML public Pane listAllCasesPane;
    @FXML public Button listAllCasesButton;
    @FXML public Button AddCaseBtn;
    public Button displayCaseSearchButton;
    public CheckBox CheckBoxIsLit;


    @FXML
    private ChoiceBox<DisplayCase> displayTrayChooseCaseChoiceBox;

    @FXML
    private ListView<DisplayCase> displayCasesListView;

    @FXML
    private Label nextCaseIdLabel;
    private MyLinkedList<DisplayTray> displayTrays;


    public DisplayCaseController() {
       //initializeDisplayCases();
    }

    @FXML
    public void initialize() {
        populateDisplayCasesVBox();

        // Populate the displayTrayColorChoiceBox
        displayTrayColorChoiceBox.getItems().addAll("Black", "Red", "Green", "Blue");
        // Set the default value for the displayTrayColorChoiceBox
        displayTrayColorChoiceBox.setValue("Black"); // in case user forgets to choose.

        //initializeDisplayCases();
        // Initialization code here
        //nextCaseIdLabel.setText("Next Case ID: " + getNextCaseID());
    }

    void initializeDisplayCases() {

}

    @FXML
    public Button AddTrayBtn;
    @FXML
    private TextField displayTrayIdTextField;

    @FXML
    private ChoiceBox<String> displayTrayColorChoiceBox;

    @FXML
    private TextField newTrayWidthTextField;

    @FXML
    private TextField newTrayDepthTextField;


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

        if (foundCase != null) {
            // Create a GUI element for the found case
            Label displayCaseLabel = new Label(foundCase.toString());
            displayCaseSearchResultVBox.getChildren().add(displayCaseLabel);
        } else {
            // Display a message if no case found
            Label noResultLabel = new Label("DisplayCase not found");
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

        //System.out.println("Searching for: " + caseId);
        DisplayCase foundCase = findDisplayCaseById(Integer.parseInt(input));
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

    /*
    Add Tray
     */
    private void showErrorMessage(String message) {
        // Display the error message to the user (e.g., using an Alert dialog or a Label)
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private static final Pattern TRAY_ID_PATTERN = Pattern.compile("^[a-zA-Z]\\d{1,3}$");

    @FXML
    private TextField addTrayDisplayCaseChoice;


    @FXML
    private void handleAddTrayButtonClick(ActionEvent event) {
        System.out.println("Add tray button clicked!");

        String caseIdInput = addTrayDisplayCaseChoice.getText().trim();

        if (caseIdInput.isEmpty()) {
            showErrorMessage("Please enter a display case ID.");
            return;
        }

        if (!isNumeric(caseIdInput)) {
            showErrorMessage("Invalid input. Please enter a number.");
            return;
        }

        int caseId = Integer.parseInt(caseIdInput);
        DisplayCase selectedCase = findDisplayCaseById(caseId);

        if (selectedCase != null) {
            DisplayTray newTray = new DisplayTray();
            selectedCase.addDisplayTray(newTray);
            // Update the UI to reflect the changes, if necessary
        } else {
            showErrorMessage("No display case found with ID: " + caseId);
        }

        // Get the user inputed trayID
        String trayId = displayTrayIdTextField.getText();

        // Validate the tray ID
        Matcher matcher = TRAY_ID_PATTERN.matcher(trayId);
        if (matcher.matches()) {
            // Convert the first character to uppercase if it's lowercase
            if (Character.isLowerCase(trayId.charAt(0))) {
                trayId = Character.toUpperCase(trayId.charAt(0)) + trayId.substring(1);
            }

            // Add leading zeros to the numeric part of the tray ID
            int numericPart = Integer.parseInt(trayId.substring(1));
            trayId = trayId.charAt(0) + String.format("%03d", numericPart);
        } else {
            System.out.println("Invalid tray ID format. Please enter a single letter followed by a number from 1 to 999.");
            return;
        }

        // Get the color from the ChoiceBox
        String trayColor = displayTrayColorChoiceBox.getValue();

        // Get the width and depth values from the TextFields
        // Get & validate the tray width
        int trayWidth;
        try {
            trayWidth = Integer.parseInt(newTrayWidthTextField.getText());
            if (trayWidth < 1 || trayWidth > 999) {
                System.out.println("Invalid tray width. Please enter an integer between 1 and 999.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid tray width. Please enter an integer value.");
            return;
        }

        // Get & validate the tray depth
        int trayDepth;
        try {
            trayDepth = Integer.parseInt(newTrayDepthTextField.getText());
            if (trayDepth < 1 || trayDepth > 999) {
                System.out.println("Invalid tray depth. Please enter an integer between 1 and 999.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid tray depth. Please enter an integer value.");
            return;
        }

        // Create a new DisplayTray instance with the user input
        DisplayTray newTray = new DisplayTray(trayId, trayColor, trayWidth, trayDepth );

        // Add the new DisplayTray to the displayTrays list
//        displayTrays.add(newTray);

        // Clear the input fields
        displayTrayIdTextField.clear();
        displayTrayColorChoiceBox.setValue("Black"); // clearing the value here with null allows null on subsequent additions which causes a validation error. So set it to Black to match initial default.
        newTrayWidthTextField.clear();
        newTrayDepthTextField.clear();

        // print to console
        System.out.println("New tray added: " + newTray);
    }




}