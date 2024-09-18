package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
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


public class StockValuesController implements Serializable {


    @FXML public Pane refreshValuesPane;
    @FXML public Button refreshValuesButton;
    @FXML public VBox stockValuesVBox;
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
    private static double calculateTotalValueOfStock() {
        double totalValue = 0;
        for (DisplayCase displayCase : displayCases) {
            for (DisplayTray  displayTray : displayCase.getDisplayTrays()) {
                for (JewelleryItem jewelleryItem : displayTray.getJewelleryItems()) {
                    totalValue+=jewelleryItem.getItemPrice();
                    for (JewelleryMaterial jewelleryMaterial : jewelleryItem.getJewelleryMaterials()) {
                        totalValue += jewelleryMaterial.getJewelleryMaterialPrice();
                    }
                }
            }
        }
        System.out.println("Total value of stock: " + totalValue);
        return totalValue;
    }


    public void onRefreshValuesButton(ActionEvent actionEvent) {
        calculateTotalValueOfStock();
        populateStockValuesVBox();
    }

    private void populateStockValuesVBox() {
        stockValuesVBox.getChildren().clear();

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

                    Label itemLabel = new Label("Jewellery Item: " + item.getItemId() + ", " +item.getItemName() + ", " + item.getItemType() + ", $" + item.getItemPrice());
                    itemVBox.getChildren().add(itemLabel);

                    double materialTotalInTray = 0;

                    // Add jewellery materials
                    for (JewelleryMaterial jewelleryMaterial : item.getJewelleryMaterials()) {
                        VBox jewelleryMaterialVBox = new VBox();
                        jewelleryMaterialVBox.setSpacing(5);
                        jewelleryMaterialVBox.setPadding(new Insets(5));
                        jewelleryMaterialVBox.setStyle("-fx-border-color: gray;");
                        double val = jewelleryMaterial.getJewelleryMaterialPrice();
                        double qty = jewelleryMaterial.getJewelleryMaterialQuantity();
                        double materialValue = val * qty;
                        String formattedValue = String.format("%.2f", materialValue);

                        Label jewelleryMaterialLabel = new Label("Jewellery Material: " + jewelleryMaterial.getJewelleryMaterialName()+", ID# " +jewelleryMaterial.getJewelleryMaterialId() + ", Qty: " + jewelleryMaterial.getJewelleryMaterialQuantity()+" @ "+jewelleryMaterial.getJewelleryMaterialPrice());
                        Label jewelleryMaterialLabel2 = new Label("Total value: €" + formattedValue);
                        materialTotalInTray += materialValue;

                        jewelleryMaterialVBox.getChildren().add(jewelleryMaterialLabel);
                        jewelleryMaterialVBox.getChildren().add(jewelleryMaterialLabel2);

                        itemVBox.getChildren().add(jewelleryMaterialVBox);
                    }
                    String formattedMaterialTotalInTrayValue = String.format("%.2f", materialTotalInTray);
                    Label materialTotalLabel = new Label("Total value of materials in item: €" + formattedMaterialTotalInTrayValue  );
                    itemVBox.getChildren().add(materialTotalLabel);


                    trayVBox.getChildren().add(itemVBox);
                }

                caseVBox.getChildren().add(trayVBox);
            }

            stockValuesVBox.getChildren().add(caseVBox);
        }
    }

} // end 


