package com.michaelmckibbin.js1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DisplayCaseController implements Serializable {

    public static MyLinkedList<DisplayCase> displayCases = new MyLinkedList<>();

    @FXML
    public TextField CaseSearchBtn;
    @FXML
    public CheckBox CheckBoxWallMounted;
    @FXML
    public Button deleteAllCasesButton;
    @FXML
    public Pane deleteAllCasesPane;
    @FXML
    public Pane listAllCasesPane;
    @FXML
    public Button listAllCasesButton;
    @FXML
    public Button AddCaseBtn;
    @FXML
    public Button displayCaseSearchButton;
    @FXML
    public CheckBox CheckBoxIsLit;
    @FXML
    public Button displayCaseViewItemSearchButton;
    @FXML
    public TextField displayCaseViewItemSearchField;
    @FXML
    public Button addJewelleryItemButton;
    @FXML
    public TextField addItemDisplayTrayIdTextField;
    @FXML
    public TextField addItemDisplayCaseIdTextField;
    @FXML
    public TextField addItemItemIdTextField;
    @FXML
    public TextField addItemNameTextField;
    @FXML
    public TextField addItemDescriptionTextField;
    @FXML
    public ChoiceBox<String> addItemGenderChoiceBox;
    @FXML
    public TextField addItemPriceTextField;
    @FXML
    public TextField addItemImageUrlTextField;
    @FXML
    public ChoiceBox<String> addItemTypeChoiceBox;

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
    public VBox deleteJewelleryVBox;
    @FXML
    public ChoiceBox jewelleryItemChoiceBox;
    @FXML
    public TextField deleteItemUserInputTextBox;

    @FXML
    public Button deleteItemButton;
    @FXML
    public VBox editItemVbox;
    @FXML
    public TextField editItemDisplayCaseIdTextField;
    @FXML
    public TextField editItemDisplayTrayIdTextField;
    @FXML
    public TextField editItemItemIdTextField;
    @FXML
    public TextField editItemNameTextField;
    @FXML
    public TextField editItemDescriptionTextField;
    @FXML
    public ChoiceBox editItemTypeChoiceBox;
    @FXML
    public ChoiceBox editItemGenderChoiceBox;
    @FXML
    public TextField editItemImageUrlTextField;
    @FXML
    public TextField editItemPriceTextField;
    @FXML
    public Button editJewelleryItemButton;


    private Set<String> allTrayIdsSet = new HashSet<>();
    private Set<String> allCaseIdsSet = new HashSet<>();
    private Set<String> allItemIdsSet = new HashSet<>();


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
        // initialise the VBox list display
        populateDisplayCasesVBox();

        // Populate the displayTrayColorChoiceBox
        displayTrayColorChoiceBox.getItems().addAll("Black", "Red", "Green", "Blue");
        // Set the default value for the displayTrayColorChoiceBox
        displayTrayColorChoiceBox.setValue("Black"); // in case user forgets to choose.

        // populate the addItemGenderChoiceBox
        addItemGenderChoiceBox.getItems().addAll("Male", "Female", "Unisex");
        // Set the default value for the addItemGenderChoiceBox
        addItemGenderChoiceBox.setValue("Unisex");

        // populate the addItemTypeChoiceBox
        addItemTypeChoiceBox.getItems().addAll("Ring", "Necklace", "Earring", "Bracelet", "Anklet", "Cufflinks", "Watch", "Clothing", "Handbag", "Sunglasses", "Other");
        // Set the default value for the addItemTypeChoiceBox
        addItemTypeChoiceBox.setValue("Other");

        // populate the jewelleryMaterialUnitTypeChoiceBox
        addJewelleryMaterialUnitTypeChoiceBox.getItems().addAll("Grams", "Karats", "oz", "cm", "Other");
        // Set the default value for the jewelleryMaterialUnitTypeChoiceBox
        addJewelleryMaterialUnitTypeChoiceBox.setValue("Other");

        //populate


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

    private void populateDisplayCasesVBox() {
        displayCasesVBox.getChildren().clear();

        for (DisplayCase displayCase : displayCases) {
            VBox caseVBox = new VBox();
            caseVBox.setSpacing(10);
            caseVBox.setPadding(new Insets(10));
            caseVBox.setStyle("-fx-border-color: black;");

            Label caseLabel = new Label("Display Case: " + displayCase.getCaseId() + " - Is Lit?: " + displayCase.isLit() + " - Wall Mounted?: " + displayCase.isWall());
            caseVBox.getChildren().add(caseLabel);

            for (DisplayTray tray : displayCase.getDisplayTrays()) {
                VBox trayVBox = new VBox();
                trayVBox.setSpacing(5);
                trayVBox.setPadding(new Insets(5));
                trayVBox.setStyle("-fx-border-color: gray;");

                Label trayLabel = new Label("Display Tray: " + tray.getTrayId() + ", " + tray.getTrayColor() + ", " + tray.getTrayWidth() + " x " + tray.getTrayDepth() + "cm");
                trayVBox.getChildren().add(trayLabel);

                for (JewelleryItem item : tray.getJewelleryItems()) {
                    VBox itemVBox = new VBox();
                    itemVBox.setSpacing(5);
                    itemVBox.setPadding(new Insets(5));
                    itemVBox.setStyle("-fx-border-color: gray;");

                    Label itemLabel = new Label("Jewellery Item: " + item.getItemId() + ", " + item.getItemName() + ", " + item.getItemType() + ", $" + item.getItemPrice());
                    itemVBox.getChildren().add(itemLabel);

                    // Add jewellery materials for the item
                    for (JewelleryMaterial jewelleryMaterial : item.getJewelleryMaterials()) {
                        VBox jewelleryMaterialVBox = new VBox();
                        jewelleryMaterialVBox.setSpacing(5);
                        jewelleryMaterialVBox.setPadding(new Insets(5));
                        jewelleryMaterialVBox.setStyle("-fx-border-color: gray;");

                        Label jewelleryMaterialLabel = new Label("Jewellery Material: " + jewelleryMaterial.getJewelleryMaterialName() + ", $" + jewelleryMaterial.getJewelleryMaterialPrice());

                        jewelleryMaterialVBox.getChildren().add(jewelleryMaterialLabel);

                        itemVBox.getChildren().add(jewelleryMaterialVBox);
                    }


                    trayVBox.getChildren().add(itemVBox);
                }

                caseVBox.getChildren().add(trayVBox);
            }

            displayCasesVBox.getChildren().add(caseVBox);
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
        // loadDisplayCasesFromFile
        loadDisplayCasesFromFile("displayCases.ser");
    }

    public void saveFile(ActionEvent actionEvent) {
        // saveDisplayCasesToFile
        saveDisplayCasesToFile("displayCases.ser");
    }

    public void makeBackup(ActionEvent actionEvent) {
        // backupSaveFile
        backupSaveFile("displayCases.ser");
    }

    // delete all stock
    // delete materials in items, items in trays and trays in cases. then delete cases.
    private static void deleteAllStock() {
        for (DisplayCase displayCase : DisplayCaseController.displayCases) {
            for (DisplayTray displayTray : displayCase.getDisplayTrays()) {
                for (JewelleryItem jewelleryItem : displayTray.getJewelleryItems()) {
                    for (JewelleryMaterial jewelleryMaterial : jewelleryItem.getJewelleryMaterials()) {
                    }
                    jewelleryItem.getJewelleryMaterials().clear();
                }
                displayTray.getJewelleryItems().clear();
            }
            displayCase.getDisplayTrays().clear();
        }
        DisplayCaseController.displayCases.clear();
    }

    public void saveAndExit(ActionEvent actionEvent) {
        // saveDisplayCases
        saveDisplayCasesToFile("displayCases.ser");
        // clear all lists
        deleteAllStock(); // tidy up
        // exit
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public void deleteAllStock(ActionEvent actionEvent) {
        System.out.println("Delete all stock button clicked!");
        // show confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete all stock?", ButtonType.YES, ButtonType.NO);
        deleteAllStock();
    }

    public void closeProg(ActionEvent actionEvent) {
        // clear all lists
        deleteAllStock();
        // exit
        System.out.println("Goodbye!");
        System.exit(0);
    }


    // saveDisplayCasesToFile
    private static void saveDisplayCasesToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(DisplayCaseController.displayCases);
            System.out.println("Display cases saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving display cases to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // loadDisplayCasesFromFile
    private static void loadDisplayCasesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            DisplayCaseController.displayCases = (MyLinkedList<DisplayCase>) ois.readObject();
            System.out.println("Display cases loaded from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading display cases from file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // make backup of save file.
    private static void backupSaveFile(String filename) {
        try {
            Files.copy(Paths.get(filename), Paths.get(filename + ".bak"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup of save file created: " + filename + ".bak");
        } catch (IOException e) {
            System.out.println("Error creating backup of save file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void viewAllStock(ActionEvent actionEvent) {
        System.out.println("View all stock button clicked!");
        populateDisplayCasesVBox();

    }

    public void drillDown(ActionEvent actionEvent) {
        System.out.println("Drill down button clicked!");
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


    private int getNextCaseid() {
        int nextCaseid = displayCases.size() + 1;
        boolean idExists;

        do {
            idExists = false;
            for (DisplayCase displayCase : displayCases) {
                if (displayCase.getCaseId().equals(nextCaseid)) {
                    idExists = true;
                    nextCaseid++;
                    break;
                }
            }
        } while (idExists);

        return nextCaseid;
    }


    @FXML
    public void onAddCaseBtn(ActionEvent actionEvent) {
        System.out.println("Add case button clicked!");

        // generate new case number with getNextCaseid
        String newCaseid = String.valueOf(getNextCaseid());
        // get value of CheckBoxIsLit
        boolean isLit = CheckBoxIsLit.isSelected();
        // get value of CheckBoxWallMounted
        boolean isWallMounted = CheckBoxWallMounted.isSelected();
        DisplayCase newDisplayCase = new DisplayCase(newCaseid, isLit, isWallMounted);

        // add a new case to the list
        displayCases.add(newDisplayCase);
        // show confirmation message in VBox
        displayCaseSearchResult(newDisplayCase);
        System.out.println("New case added: " + newDisplayCase);

    }

//    public DisplayCase findDisplayCaseById(int caseId) {
//        for (DisplayCase displayCase : displayCases) {
//            if (displayCase.getCaseId().equals(caseId)) {
//                return displayCase;
//            }
//        }
//        return null; // Return null if no matching DisplayCase is found
//    }

    public DisplayCase findDisplayCaseById(String caseId) {
        if (caseId == null || caseId.trim().isEmpty()) {
            return null;
        }

        for (DisplayCase displayCase : displayCases) {
            if (displayCase.getCaseId().equals(caseId)) {
                return displayCase;
            }
        }
        return null; // Return null if no matching DisplayCase is found
    }


    @FXML
    private TextField displayCaseSearchField;


    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str); // Try to parse the string as a double
        } catch (NumberFormatException e) {
            return false; // Return false if the string cannot be parsed as a number
        }
        return true;
    }


    @FXML
    public void onListAllCasesButton(ActionEvent actionEvent) {
        System.out.println("List all cases button clicked!");
//        // print list of displaycases
//        System.out.println("Display cases:");
//        for (DisplayCase displayCase : displayCases) {
//            System.out.println(displayCase);
//        }

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

    private static final Pattern TRAY_id_PATTERN = Pattern.compile("^[a-zA-Z]\\d{1,3}$");

    @FXML
    private TextField addTrayDisplayCaseChoice;

    // create a set of trayIds across all displayCases. used to allow for uniqueness check.
    private void populateAllTrayIdsSet() {
        allTrayIdsSet.clear(); // Clear the set first

        for (DisplayCase displayCase : displayCases) { // iterate displayCases
            for (DisplayTray displayTray : displayCase.getDisplayTrays()) { // for each displayCase, get the list of displayTrays
                if (displayTray != null && displayTray.getTrayId() != null && !displayTray.getTrayId().isEmpty()) { // filter out any null items
                    allTrayIdsSet.add(displayTray.getTrayId()); // add each trayId to the set
                }
            }
        }
    }

    @FXML
    private void handleAddTrayButtonClick(ActionEvent event) {
        System.out.println("Add tray button clicked!");

        String caseIdInput = addTrayDisplayCaseChoice.getText().trim();

        if (caseIdInput.isEmpty()) {
            showErrorMessage("Please enter a display case id.");
            return;
        }

        DisplayCase selectedCase = findDisplayCaseById(caseIdInput);

        if (selectedCase != null) {
            // take user input from displayTrayIdTextField and create trayId
            String trayId = displayTrayIdTextField.getText();

            // Validate the tray id
            Matcher matcher = TRAY_id_PATTERN.matcher(trayId);
            if (matcher.matches()) {
                // Convert the first character to uppercase if it's lowercase
                if (Character.isLowerCase(trayId.charAt(0))) {
                    trayId = Character.toUpperCase(trayId.charAt(0)) + trayId.substring(1);
                }

                // Add leading zeros to the numeric part of the tray id
                int numericPart = Integer.parseInt(trayId.substring(1));
                trayId = trayId.charAt(0) + String.format("%03d", numericPart);
            } else {
                showErrorMessage("\"Invalid tray id format. Please enter a single letter followed by a number from 1 to 999.");
                System.out.println("Invalid tray id format. Please enter a single letter followed by a number from 1 to 999.");
                return;
            }
            // Check if the tray id already exists in the allTrayIdsList
            if (allTrayIdsSet.contains(trayId)) {
                showErrorMessage("Tray id already exists. Please enter a different id.");
                return; // Exit the method without creating a new tray
            }
            // Get the color from the ChoiceBox
            String trayColor = displayTrayColorChoiceBox.getValue();

            // Get the width and depth values from the TextFields
            // Get & validate the tray width
            int trayWidth;
            try {
                trayWidth = Integer.parseInt(newTrayWidthTextField.getText());
                if (trayWidth < 1 || trayWidth > 999) {
                    showErrorMessage("Invalid tray width. Please enter an integer between 1 and 999.");
                    System.out.println("Invalid tray width. Please enter an integer between 1 and 999.");
                    return;
                }
            } catch (NumberFormatException e) {
                showErrorMessage("Invalid tray width. Please enter an integer between 1 and 999.");
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
            DisplayTray newTray = new DisplayTray(trayId, trayColor, trayWidth, trayDepth);
            selectedCase.addDisplayTray(newTray);
            System.out.println("New tray added: " + newTray);

            // Update the allTrayIdsList
            populateAllTrayIdsSet();
            System.out.println("All tray ids: " + allTrayIdsSet);

            // Update the UI to reflect the changes, if necessary
        } else {
            showErrorMessage("Invalid case id. Please try again.");
        }

        // Clear the input fields
        displayTrayIdTextField.clear();
        displayTrayColorChoiceBox.setValue("Black"); // clearing the value here with null allows null on subsequent additions which causes a validation error. So set it to Black to match initial default.
        newTrayWidthTextField.clear();
        newTrayDepthTextField.clear();

    }


    @FXML
    private void addJewelleryItem(ActionEvent event) {
        System.out.println("Add jewellery item button clicked!");
        // get user input

        // Get user input for the case id
        String caseIdInput = addItemDisplayCaseIdTextField.getText();
        // Validate the case id input
        if (caseIdInput.isEmpty()) {
            showErrorMessage("Please enter a case id.");
            return;
        }

        // Get the user input for the tray id
        String trayIdInput = addItemDisplayTrayIdTextField.getText().trim();
        // Validate the tray id input
        if (trayIdInput.isEmpty()) {
            showErrorMessage("Please enter a tray id.");
            return;
        }

        // Get the user input for the jewellery item properties
        String itemid = addItemItemIdTextField.getText();
        // validate the item id input
        if (itemid.isEmpty()) {
            showErrorMessage("Please enter an item id.");
            return;
        }

        String itemName = addItemNameTextField.getText();
        //validate item name input
        if (itemName.isEmpty()) {
            showErrorMessage("Please enter an item name.");
            return;
        }
        String itemType = addItemTypeChoiceBox.getValue();
        String itemDescription = addItemDescriptionTextField.getText();
        String itemTargetGender = addItemGenderChoiceBox.getValue();
        String itemImage = addItemImageUrlTextField.getText();
        // if no input set default image url
        if (itemImage.isEmpty()) {
            itemImage = "./images/jewelleryGeneral.jpg";
        }


        double itemPrice;
        // Check if the addItemPriceTextField is empty, and set the default value if it is
        if (addItemPriceTextField.getText().trim().isEmpty()) {
            itemPrice = 9999.99;
        } else {
            itemPrice = Double.parseDouble(addItemPriceTextField.getText());
        }


        // Create a new JewelleryItem instance
        JewelleryItem newItem = new JewelleryItem(itemid, itemName, itemType, itemDescription, itemTargetGender, itemImage, itemPrice);


        // Add the jewellery item to the selected case and tray
        DisplayCase selectedCase = findDisplayCaseById(caseIdInput);
        if (selectedCase != null) {
            DisplayTray selectedTray = selectedCase.findDisplayTrayById(trayIdInput);
            if (selectedTray != null) {
                selectedTray.addJewelleryItem(newItem);
                System.out.println("New jewellery item added: " + newItem.getItemName());
            } else {
                System.out.println("Invalid tray id. Please try again.");
            }
        } else {
            System.out.println("Invalid case id. Please try again.");
        }


        // Clear the input fields
        addItemItemIdTextField.clear();
        addItemNameTextField.clear();
        addItemTypeChoiceBox.setValue("Necklace");
        addItemDescriptionTextField.clear();
        addItemGenderChoiceBox.setValue("Unisex");
        addItemImageUrlTextField.clear();
        addItemPriceTextField.clear();
        addItemDisplayTrayIdTextField.clear();


    }

    @FXML
    public void addJewelleryMaterial(ActionEvent actionEvent) {
        System.out.println("Add jewellery material button clicked!");
        // get user input

//        // Get user input for the case
//        int addJewelleryMaterialCaseIdInput = Integer.parseInt(addJewelleryMaterialDisplayCaseIdTextField.getText());
//        // Validate the case id input
//        if (addJewelleryMaterialCaseIdInput == 0) {
//            showErrorMessage("Please enter a case id.");
//            return;
//        }
//
// Get user input for the case
        String addJewelleryMaterialCaseIdInput = addJewelleryMaterialDisplayCaseIdTextField.getText();
// Validate the case id input
        if (addJewelleryMaterialCaseIdInput.isEmpty() || addJewelleryMaterialCaseIdInput.trim().isEmpty()) {
            showErrorMessage("Please enter a case id.");
            return;
        }

        // Get the user input for the tray id
        String addJewelleryMaterialTrayIdInput = addJewelleryMaterialDisplayTrayIdTextField.getText();
        // Validate the tray id input
        if (addJewelleryMaterialTrayIdInput.isEmpty()) {
            showErrorMessage("Please enter a tray id.");
            return;
        }
        // Get the user input for the jewellery item id
        int addJewelleryMaterialJewelleryIdInput = Integer.parseInt(addJewelleryMaterialJewelleryItemIdTextField.getText());
        // validate the item id input
        if (addJewelleryMaterialJewelleryIdInput == 0) {
            showErrorMessage("Please enter an item id.");
            return;
        }

        // Get the user input for the jewellery material
        String jewelleryMaterialId = addJewelleryMaterialIdTextField.getText();
        // validate jewellery material id input
        if (jewelleryMaterialId.isEmpty()) {
            showErrorMessage("Please enter a jewellery material id.");
            return;
        }
        String jewelleryMaterialName = addJewelleryMaterialNameTextField.getText();
        //validate jewellery material name input
        if (jewelleryMaterialName.isEmpty()) {
            showErrorMessage("Please enter a jewellery material name.");
            return;
        }
        String jewelleryMaterialType = (String) addJewelleryMaterialUnitTypeChoiceBox.getValue();
        String jewelleryMaterialDescription = addJewelleryMaterialDescriptionTextField.getText();
        String jewelleryMaterialImage = addJewelleryMaterialImageUrlTextField.getText();
        // if no input set default image url
        if (jewelleryMaterialImage.isEmpty()) {
            jewelleryMaterialImage = "./images/jewelleryGeneral.jpg";
        }
        double jewelleryMaterialPrice;
        // Check if the addJewelleryMaterialPriceTextField is empty, and set the default value if it is
        if (addJewelleryMaterialPriceTextField.getText().trim().isEmpty()) {
            jewelleryMaterialPrice = 9999.99;
        } else {
            jewelleryMaterialPrice = Double.parseDouble(addJewelleryMaterialPriceTextField.getText());
        }

        int jewelleryMaterialQuantity = Integer.parseInt(addJewelleryMaterialQuantityTextField.getText());
        String jewelleryMaterialQuality = (String) addJewelleryMaterialQualityTextField.getText();
        String jewelleryMaterialUnitType = (String) addJewelleryMaterialUnitTypeChoiceBox.getValue();

        // create a new jewellery material instance
        JewelleryMaterial jewelleryMaterial = new JewelleryMaterial(jewelleryMaterialId, jewelleryMaterialName, jewelleryMaterialDescription, jewelleryMaterialUnitType, jewelleryMaterialImage, jewelleryMaterialQuantity, jewelleryMaterialQuality, jewelleryMaterialPrice);

        // add the jewellery material to the selected jewellery item. add the jewellery item the tray and case as before.
        DisplayCase selectedCase = findDisplayCaseById(addJewelleryMaterialCaseIdInput);
        if (selectedCase != null) {
            DisplayTray selectedTray = selectedCase.findDisplayTrayById(addJewelleryMaterialTrayIdInput);
            if (selectedTray != null) {
                JewelleryItem selectedItem = selectedTray.findJewelleryItemById(Integer.parseInt(String.valueOf(addJewelleryMaterialJewelleryIdInput)));
                if (selectedItem != null) {
                    selectedItem.addJewelleryMaterial(new JewelleryMaterial(jewelleryMaterialId, jewelleryMaterialName, jewelleryMaterialDescription, jewelleryMaterialUnitType, jewelleryMaterialImage, jewelleryMaterialQuantity, jewelleryMaterialQuality, jewelleryMaterialPrice));
                    System.out.println("New jewellery material added: " + jewelleryMaterial);
                } else {
                    System.out.println("Invalid item id. Please try again.");
                }
            } else {
                System.out.println("Invalid tray id. Please try again.");
            }
        } else {
            System.out.println("Invalid case id. Please try again.");
        }

        // Clear the input fields
        addJewelleryMaterialIdTextField.clear();
        addJewelleryMaterialNameTextField.clear();


    }



    /*
    Delete a jewellery item from a tray in a case.
    Linked lists are not like arrays.
    Need to create a new list without the 'deleted' item by copying the original list and excluding the item to be deleted.
    Then, update the original list with the new list.
     */

    @FXML
    public TextField deleteJewelleryItemCaseIdTextField;
    @FXML
    public TextField deleteJewelleryItemTrayIdTextField;
    @FXML
    public TextField deleteJewelleryItemTextField;
    @FXML
    public Button deleteJewelleryItemButton;

    @FXML
    public void handleDeleteJewelleryItem(ActionEvent actionEvent) {
        System.out.println("Delete jewellery item button clicked!");

        // Get user input
        String caseId = deleteJewelleryItemCaseIdTextField.getText().trim();
        String trayId = deleteJewelleryItemTrayIdTextField.getText().trim();
        String itemId = deleteJewelleryItemTextField.getText().trim();

        // Validate inputs
        if (caseId.isEmpty() || trayId.isEmpty() || itemId.isEmpty()) {
            System.out.println("Please fill in all fields (Case ID, Tray ID, and Item ID)");
            return;
        }

        try {
            // Find the specific case
            for (DisplayCase displayCase : displayCases) {
                if (displayCase.getCaseId().equals(caseId)) {
                    // Find the specific tray
                    for (DisplayTray tray : displayCase.getDisplayTrays()) {
                        if (tray.getTrayID().equals(trayId)) {
                            // Create a new MyLinkedList
                            MyLinkedList<JewelleryItem> newItems = new MyLinkedList<>();
                            // Copy all items except the one to be deleted
                            for (JewelleryItem item : tray.getJewelleryItems()) {
                                if (!item.getItemID().equals(itemId)) {
                                    newItems.add(item);
                                }
                            }

                            // If sizes are the same, item wasn't found
                            if (newItems.size() == tray.getJewelleryItems().size()) {
                                System.out.println("Item " + itemId + " not found in specified tray");
                                return;
                            }

                            // Update the tray with the new list
                            tray.setJewelleryItems(newItems);
                            System.out.println("Successfully deleted item " + itemId +
                                    " from tray " + trayId +
                                    " in case " + caseId);

                            // Clear the input fields
                            deleteJewelleryItemCaseIdTextField.clear();
                            deleteJewelleryItemTrayIdTextField.clear();
                            deleteJewelleryItemTextField.clear();
                            return;
                        }
                    }
                    System.out.println("Tray " + trayId + " not found in specified case");
                    return;
                }
            }
            System.out.println("Case " + caseId + " not found");

        } catch (Exception e) {
            System.out.println("Error occurred while deleting item: " + e.getMessage());
            e.printStackTrace();
        }
    } // end of delete jewellery item


    @FXML
    public void handleDeleteItemButton(ActionEvent actionEvent) {
        // search display cases, display trays, and jewellery items lists for jewellery item by itemId
        for (DisplayCase displayCase : displayCases) {
            for (DisplayTray displayTray : displayCase.getDisplayTrays()) {
                for (JewelleryItem jewelleryItem : displayTray.getJewelleryItems()) {
                    if (jewelleryItem.getItemID().equals(deleteItemUserInputTextBox.getText())) {
                        displayTray.getJewelleryItems().remove(jewelleryItem); // see MyLinkedList 'remove' method
                        System.out.println("Jewellery item deleted");
                        return;
                    }
                }
            }
        }
    }

    @FXML
    public void editJewelleryItem(ActionEvent actionEvent) {
    }
}