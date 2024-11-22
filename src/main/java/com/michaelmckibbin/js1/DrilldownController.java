package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

import static com.michaelmckibbin.js1.DisplayCaseController.displayCases;


public class DrilldownController implements Serializable {

    @FXML
    private Button displayCasesButton;
    @FXML
    private Button StorefrontButton;

    @FXML
    private Button drilldownRefreshViewButton;


    @FXML
    public void initialize() {
        populateInventoryTreeView();
    }



    /*
    Navigation Buttons
     */

    @FXML
    public void handleStorefrontButtonClick(ActionEvent actionEvent) {
        System.out.println("Storefront button clicked!");
        // open Storefront-view.fxml in a new window
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Storefront-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Apply the CSS file to the scene
            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Storefront");

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
            Scene scene = new Scene(root);

            // Apply the CSS file to the scene
            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Display Cases");

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) displayCasesButton.getScene().getWindow();
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
    private TreeView<String> inventoryTreeView; // create Treeview

//
//      // TODO - fix delete button
//      // add delete button - lost item details in treeview...

//    private void populateInventoryTreeView() {
//        TreeItem<String> root = new TreeItem<>("Inventory: ");
//        root.setExpanded(true);
//
//        for (DisplayCase displayCase : displayCases) {
//            TreeItem<String> caseNode = new TreeItem<>("Display Case: " + displayCase.getCaseId());
//
//            for (DisplayTray displayTray : displayCase.getDisplayTrays()) {
//                TreeItem<String> trayNode = new TreeItem<>("Display Tray: " + displayTray.getTrayID());
//
//                for (JewelleryItem item : displayTray.getJewelleryItems()) {
//                    // Create HBox to hold item info and delete button
//                    HBox itemBox = new HBox(10); // 10 is spacing between elements
//
//                    // Create VBox for item details
//                    VBox itemDetails = new VBox(2);
//                    itemDetails.getChildren().addAll(
//                            new Label("Item ID#: " + item.getItemID()),
//                            new Label("Item Name: " + item.getItemName()),
//                            new Label("Item Type: " + item.getItemType()),
//                            new Label("Description: " + item.getItemDescription()),
//                            new Label("Target Gender: " + item.getItemTargetGender()),
//                            new Label("Price: €" + item.getItemPrice())
//                    );
//
//                    // Create delete button
//                    Button deleteButton = new Button("Delete");
//                    deleteButton.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white;");
//
//                    // Add hover effect
//                    deleteButton.setOnMouseEntered(e ->
//                            deleteButton.setStyle("-fx-background-color: #cc0000; -fx-text-fill: white;"));
//                    deleteButton.setOnMouseExited(e ->
//                            deleteButton.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white;"));
//
//                    // Add delete functionality
//                    deleteButton.setOnAction(e -> {
//                        // Confirm deletion
//                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                        alert.setTitle("Confirm Deletion");
//                        alert.setHeaderText("Delete Item");
//                        alert.setContentText("Are you sure you want to delete this item?");
//
//                        Optional<ButtonType> result = alert.showAndWait();
//                        if (result.isPresent() && result.get() == ButtonType.OK) {
//                            // Remove from the tray's jewellery items list
//                            displayTray.getJewelleryItems().remove(item);
//                            // Remove from the TreeView
//                            // Is this necessary? will refresh take care of it anyway?
//                            trayNode.getChildren().remove(item);
//
//                            // Show success message
//                            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
//                            successAlert.setTitle("Success");
//                            successAlert.setHeaderText(null);
//                            successAlert.setContentText("Item successfully deleted.");
//                            successAlert.show();
//                        }
//                    });
//
//                    // Add items to HBox
//                    itemBox.getChildren().addAll(itemDetails, deleteButton);
//                    itemBox.setAlignment(Pos.CENTER_LEFT); // Align items to the left
//
//                    TreeItem<String> itemNode = new TreeItem<>();
//                    itemNode.setGraphic(itemBox);
//
//                    for (JewelleryMaterial material : item.getJewelleryMaterials()) {
//                        TreeItem<String> materialNode = new TreeItem<>(
//                                "Materials included: \n" +
//                                        "Material ID#: " + material.getJewelleryMaterialId() +
//                                        "\nMaterial Name: " + material.getJewelleryMaterialName());
//                        itemNode.getChildren().add(materialNode);
//                    }
//
//                    trayNode.getChildren().add(itemNode);
//                }
//                caseNode.getChildren().add(trayNode);
//            }
//            root.getChildren().add(caseNode);
//        }
//
//        inventoryTreeView.setRoot(root);
//        inventoryTreeView.setShowRoot(true);
//    }


    // without delete button
    private void populateInventoryTreeView() {
        TreeItem<String> root = new TreeItem<>("Inventory: ");
        root.setExpanded(true);

        for (DisplayCase displayCase : displayCases) {
            TreeItem<String> caseNode = new TreeItem<>("Display Case: " + displayCase.getCaseId());

            for (DisplayTray displayTray : displayCase.getDisplayTrays()) {
                TreeItem<String> trayNode = new TreeItem<>("Display Tray: " + displayTray.getTrayID());

                for (JewelleryItem item : displayTray.getJewelleryItems()) {
                    TreeItem<String> itemNode = new TreeItem<>(
                            "\nItem ID#: " + item.getItemID() +
                                    "\nItem Name: " + item.getItemName() +
                                    "\nItem Type: " + item.getItemType() +
                                    "\nDescription: " + item.getItemDescription() +
                                    "\nTarget Gender: " + item.getItemTargetGender() +
                                    "\nPrice: €" + item.getItemPrice() + " ");

                    for (JewelleryMaterial material : item.getJewelleryMaterials()) {
                        TreeItem<String> materialNode = new TreeItem<>(
                                "Materials included: \n" +
                                        "Material ID#: " + material.getJewelleryMaterialId() +
                                        "\nMaterial Name: " + material.getJewelleryMaterialName() +
                                        "\nDescription: " + material.getJewelleryMaterialDescription() +
                                        "\nQty: " + material.getJewelleryMaterialQuantity() +
                                        "\nPrice: €" + material.getJewelleryMaterialPrice() + " ");

                        itemNode.getChildren().add(materialNode);
                    }
                    trayNode.getChildren().add(itemNode);
                }
                caseNode.getChildren().add(trayNode);
            }
            root.getChildren().add(caseNode);
        }

        inventoryTreeView.setRoot(root);
    }


    public void drilldownRefresh(ActionEvent actionEvent) {
        populateInventoryTreeView();
    }
} // end


