package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.michaelmckibbin.js1.MyLinkedList;

//private MyLinkedList<DisplayTray> displayTrays;

public class DisplayTrayController implements Serializable {

    private MyLinkedList<JewelleryItem> jewelleryItems = new MyLinkedList<>();

    @FXML
    private void initialize() {

        //displayTrays = new MyLinkedList<>();

        //moved to display case controller
//        // Populate the displayTrayColorChoiceBox
//        displayTrayColorChoiceBox.getItems().addAll("Black", "Red", "Green", "Blue");
//        // Set the default value for the displayTrayColorChoiceBox
//        displayTrayColorChoiceBox.setValue("Black"); // in case user forgets to choose.

    }







    @FXML
    public Button listAllTraysButton;

    @FXML
    public Button deleteAllTraysButton;

//    @FXML
//    public Button AddTrayBtn;
//    @FXML
//    private TextField displayTrayIdTextField;
//
//    @FXML
//    private ChoiceBox<String> displayTrayColorChoiceBox;
//
//    @FXML
//    private TextField newTrayWidthTextField;
//
//    @FXML
//    private TextField newTrayDepthTextField;

    @FXML
    private ListView<DisplayTray> trayListView;






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
            stage.setTitle("Display Trays");
            // end of option with css from styles.css in resources folder

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) displayTraysButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleDisplayTraysButtonClick(ActionEvent actionEvent) {
        System.out.println("Display trays button clicked!");
        // open DisplayTray-view.fxml
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




    @FXML
    public void onListAllTraysButton(ActionEvent actionEvent) {
        System.out.println("List all trays button clicked!");
    }
    //
    // moved to display case controller
//
//    private static final Pattern TRAY_ID_PATTERN = Pattern.compile("^[a-zA-Z]\\d{1,3}$");
//
//
//    @FXML
//    private void handleAddTrayButtonClick(ActionEvent event) {
//        System.out.println("Add tray button clicked!");
//
//        // Get the user inputed trayID
//        String trayId = displayTrayIdTextField.getText();
//
//        // Validate the tray ID
//        Matcher matcher = TRAY_ID_PATTERN.matcher(trayId);
//        if (matcher.matches()) {
//            // Convert the first character to uppercase if it's lowercase
//            if (Character.isLowerCase(trayId.charAt(0))) {
//                trayId = Character.toUpperCase(trayId.charAt(0)) + trayId.substring(1);
//            }
//
//            // Add leading zeros to the numeric part of the tray ID
//            int numericPart = Integer.parseInt(trayId.substring(1));
//            trayId = trayId.charAt(0) + String.format("%03d", numericPart);
//        } else {
//            System.out.println("Invalid tray ID format. Please enter a single letter followed by a number from 1 to 999.");
//            return;
//        }
//
//        // Get the color from the ChoiceBox
//        String trayColor = displayTrayColorChoiceBox.getValue();
//
//        // Get the width and depth values from the TextFields
//        // Get & validate the tray width
//        int trayWidth;
//        try {
//            trayWidth = Integer.parseInt(newTrayWidthTextField.getText());
//            if (trayWidth < 1 || trayWidth > 999) {
//                System.out.println("Invalid tray width. Please enter an integer between 1 and 999.");
//                return;
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid tray width. Please enter an integer value.");
//            return;
//        }
//
//        // Get & validate the tray depth
//        int trayDepth;
//        try {
//            trayDepth = Integer.parseInt(newTrayDepthTextField.getText());
//            if (trayDepth < 1 || trayDepth > 999) {
//                System.out.println("Invalid tray depth. Please enter an integer between 1 and 999.");
//                return;
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid tray depth. Please enter an integer value.");
//            return;
//        }
//
//        // Create a new DisplayTray instance with the user input
//        DisplayTray newTray = new DisplayTray(trayId, trayColor, trayWidth, trayDepth );
//
//        // Add the new DisplayTray to the displayTrays list
//        displayTrays.add(newTray);
//
//        // Clear the input fields
//        displayTrayIdTextField.clear();
//        displayTrayColorChoiceBox.setValue("Black"); // clearing the value here with null allows null on subsequent additions which causes a validation error. So set it to Black to match initial default.
//        newTrayWidthTextField.clear();
//        newTrayDepthTextField.clear();
//
//        // print to console
//        System.out.println("New tray added: " + newTray);
//    }
/*
HANDLE LIST ALL TRAYS BUTTON
 */

//    @FXML
//    private void handleListAllTraysButtonClick(ActionEvent event) {
//        // Check if trayListTextArea is not null
//        if (trayListTextArea != null) {
//            // Clear the existing text in the trayListTextArea
//            trayListTextArea.clear();
//
//            // Iterate over the displayTrays list and append each DisplayTray's information to the trayListTextArea
//            StringBuilder sb = new StringBuilder();
//            for (DisplayTray displayTray : displayTrays) {
//                sb.append("Tray ID: ").append(displayTray.getTrayId()).append("\n");
//                sb.append("Tray Color: ").append(displayTray.getTrayColor()).append("\n");
//                sb.append("Tray Width: ").append(displayTray.getTrayWidth()).append("\n");
//                sb.append("Tray Depth: ").append(displayTray.getTrayDepth()).append("\n\n");
//            }
//            trayListTextArea.setText(sb.toString());
//        } else {
//            System.out.println("trayListTextArea is null. Unable to display tray information.");
//        }
//    }
//
//



    // OUTPUT TO CONSOLE OPTION
    @FXML
    private void handleListAllTraysButtonClick(ActionEvent event) {
        System.out.println("List all trays button clicked!");
        // print list of trays to System.out
        System.out.println("Display trays:");
//        for (DisplayTray displayTray : displayTrays) {
//            System.out.println(displayTray);
//        }

//
        // TODO listview not working
//        // Clear the existing items in the trayListView
//        trayListView.getItems().clear();
//
//        // Add all the DisplayTray objects from the displayTrays list to the trayListView
//        trayListView.getItems().addAll((Collection<? extends DisplayTray>) displayTrays);
    }

//
//    // OUTPUT TO TEXTAREA OPTION
//    @FXML
//    private TextArea trayListTextArea;
//    @FXML
//    private TextArea getTrayListTextArea;
//    @FXML
//    private void updateTrayListTextArea() {
//        StringBuilder trayList = new StringBuilder();
//        for (DisplayTray displayTray : displayTrays) {
//            trayList.append(displayTray).append("\n");
//        }
//        getTrayListTextArea.setText(trayList.toString());
//    }
//
//    @FXML
//    private void handleListAllTraysButtonClick(ActionEvent event) {
//        updateTrayListTextArea();
//    }

//      // TRAYLIST OPTION
//    @FXML
//    private void handleListAllTraysButtonClick(ActionEvent event) {
//        // Clear the existing text in the trayListTextArea
//        trayListTextArea.clear();
//
//        // Iterate over the displayTrays list and append each DisplayTray's information to the trayListTextArea
//        StringBuilder sb = new StringBuilder();
//        for (DisplayTray displayTray : displayTrays) {
//            sb.append("Tray ID: ").append(displayTray.getTrayId()).append("\n");
//            sb.append("Tray Color: ").append(displayTray.getTrayColor()).append("\n");
//            sb.append("Tray Width: ").append(displayTray.getTrayWidth()).append("\n");
//            sb.append("Tray Depth: ").append(displayTray.getTrayDepth()).append("\n\n");
//        }
//        trayListTextArea.setText(sb.toString());
//    }


        /*
    END OF HANDLE LIST ALL TRAYS BUTTON
     */

    // DELETE ALL TRAYS CONFIRMATION DIALOG
    @FXML
    private void showDeleteAllTraysConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete All Display Trays!");
        alert.setHeaderText("Are you sure you want to delete all display trays?");
        alert.setContentText("This action cannot be undone!");

        ButtonType confirmButton = new ButtonType("Delete");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(confirmButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == confirmButton) {
            deleteAllTrays();
        }
    }







    @FXML
    public void onDeleteAllTraysButton(ActionEvent actionEvent) {
        System.out.println("Delete all trays button clicked!");
//        displayTrays.clear(); // short & immediate!
        showDeleteAllTraysConfirmationDialog(); // a better way. confirm choice.
    }

    private void deleteAllTrays() {
//        displayTrays.clear();
    }



}
