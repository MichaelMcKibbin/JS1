package com.michaelmckibbin.js1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import static com.michaelmckibbin.js1.DisplayCaseController.displayCases;


public class SearchController implements Serializable {

    public TextField searchTextField;
    public Button displayCaseViewItemSearchButton;
    @FXML
    public VBox displayChosenItemVBox;
    @FXML
    public VBox searchResultsVBox;
    @FXML
    private VBox chosenItemImageVBox;

    @FXML
    private TextField searchField;
    @FXML
    private ImageView chosenItemImageView;


    @FXML
    private void initialize() {
        // listeners are cool!
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            handleSearch(newValue);
        });

    }

    /*
      Navigation Buttons - copy to other views as required
       */
    @FXML
    private Button displayCasesButton;
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

    /*
    End of Navigation Buttons
     */

    public void handleSearch(String searchField) {
        // Clear previous search results
        searchResultsVBox.getChildren().clear();

        if (searchField == null || searchField.trim().isEmpty()) {
            return;
        }

        String searchTerm = searchField.toLowerCase().trim();

        // Search through all display cases
        for (DisplayCase displayCase : displayCases) {
            for (DisplayTray tray : displayCase.getDisplayTrays()) {
                for (JewelleryItem item : tray.getJewelleryItems()) {
                    // Search in jewellery items
                    if (matchesSearch(item, searchTerm)) {
                        addItemToSearchResults(item, displayCase, tray);
                    }

                    // Search in materials of each item
                    for (JewelleryMaterial material : item.getJewelleryMaterials()) {
                        if (matchesSearch(material, searchTerm)) {
                            addMaterialToSearchResults(material, item, displayCase, tray);
                        }
                    }
                }
            }
        }
    }

    private boolean matchesSearch(JewelleryItem item, String searchTerm) {
        return item.getItemName().toLowerCase().contains(searchTerm) ||
                item.getItemDescription().toLowerCase().contains(searchTerm) ||
                String.valueOf(item.getItemPrice()).contains(searchTerm) ||
                String.valueOf(item.getItemID()).contains(searchTerm);
    }

    private boolean matchesSearch(JewelleryMaterial material, String searchTerm) {
        return material.getJewelleryMaterialDescription().toLowerCase().contains(searchTerm) ||
                String.valueOf(material.getJewelleryMaterialPrice()).contains(searchTerm) ||
                String.valueOf(material.getJewelleryMaterialId()).contains(searchTerm) ||
                String.valueOf(material.getJewelleryMaterialQuality()).toLowerCase().contains(searchTerm);
    }

    private void addItemToSearchResults(JewelleryItem item, DisplayCase displayCase, DisplayTray tray) {
        VBox itemContainer = new VBox(5);
        itemContainer.setPadding(new Insets(10));
        itemContainer.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 5; -fx-border-color: #cccccc; -fx-border-radius: 5;");

        Label itemLabel = new Label("Jewellery Item Found:");
        itemLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        Label itemIDLabel = new Label("Item ID: " + item.getItemId());
        Label itemNameLabel = new Label("Name: " + item.getItemName());
        Label descriptionLabel = new Label("Description: " + item.getItemDescription());
        Label priceLabel = new Label(String.format("Price: €%.2f", item.getItemPrice()));
        Label locationLabel = new Label(String.format("Location: Case %s, Tray %s",
                displayCase.getCaseId(), tray.getTrayID()));

        // Add hover effect
        itemContainer.setOnMouseEntered(e -> {
            itemContainer.setStyle("-fx-background-color: #e0e0e0; -fx-background-radius: 5; -fx-border-color: #999999; -fx-border-radius: 5; -fx-cursor: hand;");
        });

        itemContainer.setOnMouseExited(e -> {
            itemContainer.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 5; -fx-border-color: #cccccc; -fx-border-radius: 5;");
        });

        // Add click handler
        itemContainer.setOnMouseClicked(e -> displayItemDetails(item, displayCase, tray));


        itemContainer.getChildren().addAll(itemLabel, itemIDLabel, itemNameLabel, descriptionLabel, priceLabel, locationLabel);


        // Add separator for visual clarity
        Separator separator = new Separator();
        separator.setPadding(new Insets(5, 0, 5, 0));

        Platform.runLater(() -> {
            searchResultsVBox.getChildren().addAll(itemContainer, separator);
        });
    }

    private void addMaterialToSearchResults(JewelleryMaterial material, JewelleryItem item,
                                            DisplayCase displayCase, DisplayTray tray) {
        VBox materialContainer = new VBox(5);
        materialContainer.setPadding(new Insets(10));
        materialContainer.setStyle("-fx-background-color: #f5f5f5; -fx-background-radius: 5; -fx-border-color: #dddddd; -fx-border-radius: 5;");

        Label materialLabel = new Label("Material Found:");
        materialLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        Label descriptionLabel = new Label("Description: " + material.getJewelleryMaterialDescription());
        Label qualityLabel = new Label("Quality: " + material.getJewelleryMaterialQuality());
        Label priceLabel = new Label(String.format("Price: €%.2f", material.getJewelleryMaterialPrice()));

        Label itemLabel = new Label("Used in item: " + item.getItemDescription());
        Label locationLabel = new Label(String.format("Location: Case %s, Tray %s",
                displayCase.getCaseId(), tray.getTrayID()));

        materialContainer.getChildren().addAll(materialLabel, descriptionLabel, qualityLabel,
                priceLabel, itemLabel, locationLabel);

        // Add hover effect
        materialContainer.setOnMouseEntered(e -> {
            materialContainer.setStyle("-fx-background-color: #e5e5e5; -fx-background-radius: 5; -fx-border-color: #999999; -fx-border-radius: 5; -fx-cursor: hand;");
        });

        materialContainer.setOnMouseExited(e -> {
            materialContainer.setStyle("-fx-background-color: #f5f5f5; -fx-background-radius: 5; -fx-border-color: #dddddd; -fx-border-radius: 5;");
        });

        // Add click handler
        materialContainer.setOnMouseClicked(e -> displayMaterialDetails(material, item, displayCase, tray));


        // Add separator for visual clarity
        Separator separator = new Separator();
        separator.setPadding(new Insets(5, 0, 5, 0));

        Platform.runLater(() -> {
            searchResultsVBox.getChildren().addAll(materialContainer, separator);

        });
    }

    private void displayItemDetails(JewelleryItem item, DisplayCase displayCase, DisplayTray tray) {
        // Clear both VBoxes
        displayChosenItemVBox.getChildren().clear();
        chosenItemImageVBox.getChildren().clear();

        // Display the image
        if (item.getItemImage() != null) {
            ImageView chosenItemImageView = new ImageView();

            // ImageView fits inside 200 x 200 box and maintains aspect ratio
            chosenItemImageView.setFitWidth(200);
            chosenItemImageView.setFitHeight(200);
            chosenItemImageView.setPreserveRatio(true);
            // Add some style!
            chosenItemImageView.setStyle("-fx-background-color: #f5f5f5; -fx-border-color: #cccccc; -fx-border-width: 1px;");
            chosenItemImageView.setSmooth(true); // for smoother scaling

            // Add the ImageView to chosenItemImageVBox
            chosenItemImageVBox.getChildren().add(chosenItemImageView);
            chosenItemImageVBox.setAlignment(Pos.CENTER); // Center the image in the VBox


            try {
                String imageUrl = item.getItemImage();

                // Handle both web URLs and local file paths
                if (imageUrl.startsWith("http://") || imageUrl.startsWith("https://")) {
                    // Web URL
                    Image image = new Image(imageUrl, true);
                    chosenItemImageView.setImage(image);

                } else {
                    // Local file or resource
                    try {
                        // Try as resource first
                        String resourcePath = imageUrl.startsWith("/") ? imageUrl : "/" + imageUrl;
                        URL resource = getClass().getResource(resourcePath);
                        if (resource != null) {
                            Image image = new Image(resource.toExternalForm(), true);
                            chosenItemImageView.setImage(image);
                        } else {
                            // Try as file path
                            File file = new File(imageUrl);
                            if (file.exists()) {
                                Image image = new Image(file.toURI().toString(), true);
                                chosenItemImageView.setImage(image);
                            } else {
                                throw new FileNotFoundException("Image not found: " + imageUrl);
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error loading image: " + e.getMessage());
                        chosenItemImageView.setImage(null);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error creating ImageView: " + e.getMessage());
                chosenItemImageVBox.getChildren().add(new Label("Image not available"));
            }
            //chosenItemImageVBox.getChildren().add(chosenItemImageView);
        }

        VBox detailsContainer = new VBox(10);
        detailsContainer.setPadding(new Insets(15));
        detailsContainer.setStyle("-fx-background-color: white; -fx-background-radius: 8; -fx-border-color: #cccccc; -fx-border-radius: 8;");

        // Header
        Label headerLabel = new Label("Jewellery Item Details");
        headerLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Item details
        VBox itemDetails = new VBox(5);
        itemDetails.getChildren().addAll(
                createDetailLabel("Item ID:", String.valueOf(item.getItemID())),
                createDetailLabel("Description:", item.getItemDescription()),
                createDetailLabel("Price:", String.format("$%.2f", item.getItemPrice())),
                createDetailLabel("Location:", String.format("Case %s, Tray %s",
                        displayCase.getCaseId(), tray.getTrayID()))
        );

        // Materials section
        Label materialsHeader = new Label("Materials Used:");
        materialsHeader.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 0 5 0;");

        VBox materialsBox = new VBox(8);
        for (JewelleryMaterial material : item.getJewelleryMaterials()) {
            VBox materialDetails = new VBox(3);
            materialDetails.getChildren().addAll(
                    createDetailLabel("Material:", material.getJewelleryMaterialDescription()),
                    createDetailLabel("Quality:", String.valueOf(material.getJewelleryMaterialQuality())),
                    createDetailLabel("Price:", String.format("$%.2f", material.getJewelleryMaterialPrice()))
            );
            materialDetails.setStyle("-fx-padding: 5; -fx-background-color: #f8f8f8; -fx-background-radius: 4;");
            materialsBox.getChildren().add(materialDetails);
        }

        detailsContainer.getChildren().addAll(headerLabel, new Separator(),
                itemDetails, materialsHeader, materialsBox);

        displayChosenItemVBox.getChildren().add(detailsContainer);
    }

    private void displayMaterialDetails(JewelleryMaterial material, JewelleryItem item,
                                        DisplayCase displayCase, DisplayTray tray) {
        // Clear both VBoxes
        displayChosenItemVBox.getChildren().clear();
        chosenItemImageVBox.getChildren().clear();
        // TODO - display materials image same as item imageview above.
        // For now, clear the imageview when showing material details


        VBox detailsContainer = new VBox(10);
        detailsContainer.setPadding(new Insets(15));
        detailsContainer.setStyle("-fx-background-color: white; -fx-background-radius: 8; -fx-border-color: #cccccc; -fx-border-radius: 8;");

        // Header
        Label headerLabel = new Label("Material Details");
        headerLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Material details
        VBox materialDetails = new VBox(5);
        materialDetails.getChildren().addAll(
                createDetailLabel("Material ID:", String.valueOf(material.getJewelleryMaterialId())),
                createDetailLabel("Description:", material.getJewelleryMaterialDescription()),
                createDetailLabel("Quality:", String.valueOf(material.getJewelleryMaterialQuality())),
                createDetailLabel("Price:", String.format("$%.2f", material.getJewelleryMaterialPrice())),
                createDetailLabel("Quantity:", String.valueOf(material.getJewelleryMaterialQuantity()))
        );

        // Used in item section
        Label usedInHeader = new Label("Used in Item:");
        usedInHeader.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 0 5 0;");

        VBox itemBox = new VBox(5);
        itemBox.getChildren().addAll(
                createDetailLabel("Item:", item.getItemDescription()),
                createDetailLabel("Item ID:", String.valueOf(item.getItemID())),
                createDetailLabel("Location:", String.format("Case %s, Tray %s",
                        displayCase.getCaseId(), tray.getTrayID()))
        );
        itemBox.setStyle("-fx-padding: 5; -fx-background-color: #f8f8f8; -fx-background-radius: 4;");

        detailsContainer.getChildren().addAll(headerLabel, new Separator(),
                materialDetails, usedInHeader, itemBox);

        displayChosenItemVBox.getChildren().add(detailsContainer);
    }

    private Label createDetailLabel(String label, String value) {
        Label detailLabel = new Label(label + " " + value);
        detailLabel.setStyle("-fx-font-size: 12px;");
        return detailLabel;
    }


}
