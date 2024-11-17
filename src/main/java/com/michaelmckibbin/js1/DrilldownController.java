package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.Random;

import static com.michaelmckibbin.js1.DisplayCaseController.displayCases;


public class DrilldownController implements Serializable {


    @FXML public Pane refreshValuesPane;
    @FXML public Button refreshValuesButton;
    @FXML public VBox stockValuesVBox;
    @FXML public VBox caseValuesVBox;
    @FXML public VBox trayValuesVBox;
    @FXML public VBox materialsValuesVBox;
    @FXML public Button refreshAllValuesButton;
    @FXML public Button refreshCaseValuesButton;
    @FXML public Button refreshTrayValuesButton;
    @FXML private Button displayCasesButton;
    @FXML private Button StorefrontButton;


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


    // calculate total value of all stock
    static double calculateTotalValueOfStock() {
        double totalValue = 0;
        for (DisplayCase displayCase : displayCases) {
            for (DisplayTray  displayTray : displayCase.getDisplayTrays()) {
                for (JewelleryItem jewelleryItem : displayTray.getJewelleryItems()) {
                    totalValue+=jewelleryItem.getItemPrice();
                    for (JewelleryMaterial jewelleryMaterial : jewelleryItem.getJewelleryMaterials()) {
                        double matVal = jewelleryMaterial.getJewelleryMaterialPrice();
                        double matQty = jewelleryMaterial.getJewelleryMaterialQuantity();
                        double materialValue = matVal * matQty;
                        totalValue += materialValue;
                    }
                }
            }
        }
        //System.out.println("Total value of stock: " + totalValue);

        double formattedTotalValue = Double.parseDouble(String.format("%.2f", totalValue));
        //System.out.printf("Total value of stock: $%.2f%n", formattedTotalValue);
        return formattedTotalValue;
        //return totalValue;
    }


    // all stock values - items and materials.
    @FXML
    public void onRefreshAllValuesButton(ActionEvent actionEvent) {
        calculateTotalValueOfStock();
        populateJewelleryValuesVBox();
    }

    private void populateJewelleryValuesVBox() {
        stockValuesVBox.getChildren().clear();

        for (DisplayCase displayCase : displayCases) {
            VBox caseVBox = new VBox();
//            caseVBox.setSpacing(10);
//            caseVBox.setPadding(new Insets(10));
//            caseVBox.setStyle("-fx-border-color: black;");
//
//            Label caseLabel = new Label("Display Case: " + displayCase.getCaseId() + " - Is Lit?: " + displayCase.isLit() + " - Wall Mounted?: " + displayCase.isWall());
//            caseVBox.getChildren().add(caseLabel);

            for (DisplayTray tray : displayCase.getDisplayTrays()) {
                VBox trayVBox = new VBox();
//                trayVBox.setSpacing(5);
//                trayVBox.setPadding(new Insets(5));
//                trayVBox.setStyle("-fx-border-color: gray;");
//
//                Label trayLabel = new Label("Display Tray: " + tray.getTrayId() + ", " + tray.getTrayColor() + ", " + tray.getTrayWidth() + " x " + tray.getTrayDepth() + "cm");
//                trayVBox.getChildren().add(trayLabel);

                for (JewelleryItem item : tray.getJewelleryItems()) {
                    VBox itemVBox = new VBox();
                    itemVBox.setSpacing(5);
                    itemVBox.setPadding(new Insets(5));
                    itemVBox.setStyle("-fx-border-color: gray;");

                    Label itemLabel = new Label("Jewellery Item: " + item.getItemId() + ", " +item.getItemName() + ", " + item.getItemType() + ", $" + item.getItemPrice());
                    itemVBox.getChildren().add(itemLabel);

                    double materialTotalInTray = 0;

                    trayVBox.getChildren().add(itemVBox);
                }

                caseVBox.getChildren().add(trayVBox);
            }

            stockValuesVBox.getChildren().add(caseVBox);
        }
    }

    // Tray Values
    @FXML
    public void onRefreshTrayValuesButton(ActionEvent actionEvent) {
        calculateTotalValueOfStock();
        populateTrayValuesVBox();
    }

    private void populateTrayValuesVBox() {
        trayValuesVBox.getChildren().clear();

        for (DisplayCase displayCase : displayCases) { // for each display case
            for (DisplayTray tray : displayCase.getDisplayTrays()) { // for each display tray
                double trayTotalValue = 0;

                VBox trayVBox = new VBox(); // create a new VBox for the tray
                trayVBox.setSpacing(10);
                trayVBox.setSpacing(5);
                trayVBox.setPadding(new Insets(5));
                trayVBox.setStyle("-fx-border-color: blue;");

                Label trayLabel = new Label("Display Tray: " + tray.getTrayId());
                trayVBox.getChildren().add(trayLabel);

                for (JewelleryItem item : tray.getJewelleryItems()) { // for each jewellery item
                    double itemTotalValue = item.getItemPrice(); // get the item price
                    double materialTotalInItem = 0;

                    for (JewelleryMaterial jewelleryMaterial : item.getJewelleryMaterials()) { // for each jewellery material
                        double val = jewelleryMaterial.getJewelleryMaterialPrice(); // get the material price
                        double qty = jewelleryMaterial.getJewelleryMaterialQuantity(); // get the material quantity
                        double materialValue = val * qty; // calculate the material value
                        materialTotalInItem += materialValue; // add to the materials in item total
                    }

                    itemTotalValue += materialTotalInItem; // add the materials in item total to the item total value
                    trayTotalValue += itemTotalValue; // add the item total value to the tray total value
                }
                Label totalTrayValueLabel = new Label(String.format("Total Value: $%.2f", trayTotalValue));
                trayVBox.getChildren().add(totalTrayValueLabel);
                trayValuesVBox.getChildren().add(trayVBox); // display the details


            }


        }
    }

    // onRefreshCaseValuesButton
    @FXML
    public void onRefreshCaseValuesButton(ActionEvent actionEvent) {
        calculateTotalValueOfStock();
        populateCaseValuesVBox();
    }

    private void populateCaseValuesVBox() {
        caseValuesVBox.getChildren().clear();

        for (DisplayCase displayCase : displayCases) {
            VBox caseVBox = new VBox();
            caseVBox.setSpacing(10);
            caseVBox.setPadding(new Insets(10));
            caseVBox.setStyle("-fx-border-color: green;");

            Label caseLabel = new Label("Display Case: " + displayCase.getCaseId());
            caseVBox.getChildren().add(caseLabel);

            double caseTotalValue = 0;

            for (DisplayTray tray : displayCase.getDisplayTrays()) {
                double trayTotalValue = 0;

                for (JewelleryItem item : tray.getJewelleryItems()) {
                    double itemTotalValue = item.getItemPrice();
                    double materialTotalInItem = 0;

                    for (JewelleryMaterial jewelleryMaterial : item.getJewelleryMaterials()) {
                        double val = jewelleryMaterial.getJewelleryMaterialPrice();
                        double qty = jewelleryMaterial.getJewelleryMaterialQuantity();
                        double materialValue = val * qty;
                        materialTotalInItem += materialValue;
                    }

                    itemTotalValue += materialTotalInItem;
                    trayTotalValue += itemTotalValue;
                }

                caseTotalValue += trayTotalValue;
            }

            Label totalValueLabel = new Label(String.format("Total Value: $%.2f", caseTotalValue));
            caseVBox.getChildren().add(totalValueLabel);

            caseValuesVBox.getChildren().add(caseVBox);
        }
    }

    @FXML public void onCaseValuesTab(Event event) {
        populateCaseValuesVBox();
    }

    @FXML public void onTrayValuesTab(Event event) {
        populateTrayValuesVBox();
    }
    @FXML public void onJewelleryValuesTab(Event event) {
        populateJewelleryValuesVBox();
    }
    @FXML public void onMaterialsValuesTab(Event event) {
        populateMaterialsValuesVBox();
    }

    private void populateMaterialsValuesVBox() {
        materialsValuesVBox.getChildren().clear();

        for (DisplayCase displayCase : displayCases) {
            VBox caseVBox = new VBox();
            caseVBox.setSpacing(10);
            caseVBox.setPadding(new Insets(10));
            caseVBox.setStyle("-fx-border-color: green;");

            Label caseLabel = new Label("Display Case: " + displayCase.getCaseId());
            caseVBox.getChildren().add(caseLabel);

            materialsValuesVBox.getChildren().add(caseVBox);
            for (DisplayTray tray : displayCase.getDisplayTrays()) {
                VBox trayVBox = new VBox();
                trayVBox.setSpacing(5);
                trayVBox.setPadding(new Insets(5));
                trayVBox.setStyle("-fx-border-color: gray;");

                Label trayLabel = new Label("Display Tray: " + tray.getTrayId());
                trayVBox.getChildren().add(trayLabel);

                materialsValuesVBox.getChildren().add(trayVBox);
                for (JewelleryItem item : tray.getJewelleryItems()) {
                    VBox itemVBox = new VBox();
                    itemVBox.setSpacing(5);
                    itemVBox.setPadding(new Insets(5));
                    itemVBox.setStyle("-fx-border-color: gray;");

                    Label itemLabel = new Label("Jewellery Item: " + item.getItemId() + ", " +item.getItemName() + ", " + item.getItemType() + ", $" + item.getItemPrice());
                    itemVBox.getChildren().add(itemLabel);

                    materialsValuesVBox.getChildren().add(itemVBox);
                    for (JewelleryMaterial material : item.getJewelleryMaterials()) {
                        VBox materialVBox = new VBox();
                        materialVBox.setSpacing(5);
                        materialVBox.setPadding(new Insets(5));
                        materialVBox.setStyle("-fx-border-color: gray;");

                        Label materialLabel = new Label("Jewellery Material: " + material.getJewelleryMaterialName() + ", ID# " + material.getJewelleryMaterialId() + ", Qty: " + material.getJewelleryMaterialQuantity() + " @ " + material.getJewelleryMaterialPrice());
                        materialVBox.getChildren().add(materialLabel);

                        materialsValuesVBox.getChildren().add(materialVBox);
                    }
                }
            }
        }
    }
} // end


