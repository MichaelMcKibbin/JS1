package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import static com.michaelmckibbin.js1.DisplayCaseController.displayCases;

public class AltBrowseController implements Serializable {

    @FXML
    public ImageView jewelleryViewImage1;

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
    private Button jewelleryItemsButton;
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
    public void initialize() {
        // initialise the VBox list display
        populateJewelleryItemsVBox();

    }



    public void onAddJewelleryItemBtn(ActionEvent actionEvent) {
    }

    @FXML
    private VBox jewelleryItemsVBox;

    private void populateJewelleryItemsVBox() {
        jewelleryItemsVBox.getChildren().clear();

        for (DisplayCase displayCase : displayCases) {
            VBox caseVBox = new VBox();
            caseVBox.setSpacing(10);
            caseVBox.setPadding(new Insets(10));
//            caseVBox.setStyle("-fx-border-color: black;");
//            Label caseLabel = new Label("Display Case: " + displayCase.getCaseId());
//            caseVBox.getChildren().add(caseLabel);

            for (DisplayTray tray : displayCase.getDisplayTrays()) {
                VBox trayVBox = new VBox();
                trayVBox.setSpacing(5);
                trayVBox.setPadding(new Insets(5));
//                trayVBox.setStyle("-fx-border-color: gray;");
//                Label trayLabel = new Label("Display Tray: " + tray.getTrayId());
//                trayVBox.getChildren().add(trayLabel);

                for (JewelleryItem item : tray.getJewelleryItems()) {
                    
                    // Create main HBox container
                    HBox mainHBoxContainer = new HBox(20); // 20px spacing between VBoxes
                    mainHBoxContainer.setAlignment(Pos.CENTER);
                    mainHBoxContainer.setPadding(new Insets(10));

// Left VBox for labels
                    VBox itemLabelsVBox = new VBox(3); // 10px spacing between labels
                    itemLabelsVBox.setAlignment(Pos.CENTER_LEFT);
                    itemLabelsVBox.setPadding(new Insets(5));

// Create labels for left VBox
                    Label itemLabel = new Label("Name: " + item.getItemName() + ",   RRP: €" + item.getItemPrice());
                    Label targetGenderLabel = new Label("Target Gender: " + item.getItemTargetGender());
                    Label descriptionLabel = new Label("Description: " + item.getItemDescription() + "\n");
                    Label itemTypeLabel = new Label("Type: " + item.getItemType());
                    Label imageUrlLabel = new Label("Image url: " + item.getItemImage());
                    Label itemLocationLabel = new Label("Location: " + "Case " + displayCase.getCaseId() + ", Tray " + tray.getTrayId() + ", ID#: " + item.getItemId() + "\n");

                    // Hide the specified labels initially
                    itemLocationLabel.setVisible(false);
                    itemTypeLabel.setVisible(false);
                    imageUrlLabel.setVisible(false);
                    //materialsLabel.setVisible(false);


// Make labels wrappable
                    itemLabel.setWrapText(true);
                    descriptionLabel.setWrapText(true);
                    imageUrlLabel.setWrapText(true);
                    itemTypeLabel.setWrapText(true);
                    itemLocationLabel.setWrapText(true);
                    targetGenderLabel.setWrapText(true);

                    // Style clickable labels with hand cursor and different color
                    String clickableStyle = "-fx-cursor: hand; -fx-text-fill: #0066cc;";
                    itemLabel.setStyle(clickableStyle);
                    targetGenderLabel.setStyle(clickableStyle);
                    descriptionLabel.setStyle(clickableStyle);

                    // Add click handlers to toggle hidden labels
                    itemLabel.setOnMouseClicked(event -> {
                        itemLocationLabel.setVisible(!itemLocationLabel.isVisible());
                        itemTypeLabel.setVisible(!itemTypeLabel.isVisible());
                        imageUrlLabel.setVisible(!imageUrlLabel.isVisible());
                        // materialsLabel.setVisible(!materialsLabel.isVisible());
                    });

                    descriptionLabel.setOnMouseClicked(event -> {

                        itemLocationLabel.setVisible(!itemLocationLabel.isVisible());
                        itemTypeLabel.setVisible(!itemTypeLabel.isVisible());
                        imageUrlLabel.setVisible(!imageUrlLabel.isVisible());
                        // materialsLabel.setVisible(!materialsLabel.isVisible());

                    });

                    targetGenderLabel.setOnMouseClicked(event -> {
                    itemLocationLabel.setVisible(!itemLocationLabel.isVisible());
                    itemTypeLabel.setVisible(!itemTypeLabel.isVisible());
                    imageUrlLabel.setVisible(!imageUrlLabel.isVisible());
                       // materialsLabel.setVisible(!materialsLabel.isVisible());
                    });

                    // Add hover effects
                    EventHandler<MouseEvent> hoverEffect = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Label source = (Label) event.getSource();
                            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                                source.setStyle(clickableStyle + "-fx-text-fill: #003366;");
                            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                                source.setStyle(clickableStyle);
                            }
                        }
                    };

                    // Apply hover effect to clickable labels
                    itemLabel.setOnMouseEntered(hoverEffect);
                    itemLabel.setOnMouseExited(hoverEffect);
                    targetGenderLabel.setOnMouseEntered(hoverEffect);
                    targetGenderLabel.setOnMouseExited(hoverEffect);
                    descriptionLabel.setOnMouseEntered(hoverEffect);
                    descriptionLabel.setOnMouseExited(hoverEffect);


                    // Add labels to left VBox in chosen order
                    itemLabelsVBox.getChildren().addAll(itemLabel, targetGenderLabel, descriptionLabel, itemLocationLabel, itemTypeLabel, imageUrlLabel);
                    itemLabelsVBox.getChildren().add(new Label("Materials:"));
                    for (JewelleryMaterial material : item.getJewelleryMaterials()) {
                        Label materialLabel = new Label(material.getJewelleryMaterialName());
                        materialLabel.setWrapText(true);
                        itemLabelsVBox.getChildren().add(materialLabel);
                    }

// Right VBox for ImageView
                    VBox imageVBox = new VBox(10);
                    imageVBox.setAlignment(Pos.CENTER);
                    imageVBox.setPadding(new Insets(5));

// Create and configure ImageView
                    ImageView imageView = new ImageView();
                    imageView.setFitWidth(200);
                    imageView.setFitHeight(200);
                    imageView.setPreserveRatio(true);

                    try {
                        String imageUrl = item.getItemImage();

                        // Handle both web URLs and local file paths
                        if (imageUrl.startsWith("http://") || imageUrl.startsWith("https://")) {
                            // Web URL
                            Image image = new Image(imageUrl, true);
                            imageView.setImage(image);
                        } else {
                            // Local file or resource
                            try {
                                // Try as resource first
                                String resourcePath = imageUrl.startsWith("/") ? imageUrl : "/" + imageUrl;
                                URL resource = getClass().getResource(resourcePath);
                                if (resource != null) {
                                    Image image = new Image(resource.toExternalForm(), true);
                                    imageView.setImage(image);
                                } else {
                                    // Try as file path
                                    File file = new File(imageUrl);
                                    if (file.exists()) {
                                        Image image = new Image(file.toURI().toString(), true);
                                        imageView.setImage(image);
                                    } else {
                                        throw new FileNotFoundException("Image not found: " + imageUrl);
                                    }
                                }
                            } catch (Exception e) {
                                System.err.println("Error loading image: " + e.getMessage());
                                imageView.setImage(null);
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error creating ImageView: " + e.getMessage());
                        imageVBox.getChildren().add(new Label("Image not available"));
                    }

// Add ImageView to right VBox
                    imageVBox.getChildren().add(imageView);

// Add both VBoxes to materials HBox
                    mainHBoxContainer.getChildren().addAll(itemLabelsVBox, imageVBox);

// Optional: Set minimum widths to prevent squishing
                    itemLabelsVBox.setMinWidth(300);
                    imageVBox.setMinWidth(220);

// Optional: Add styling
                    mainHBoxContainer.setStyle("-fx-background-color: white; -fx-border-color: rgba(194,207,241,0.4); -fx-border-radius: 5;");
                    itemLabelsVBox.setStyle("-fx-background-color: #fdf0f0; -fx-border-color: #ff9b9b; -fx-border-radius: 3;");
                    imageVBox.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #ff9b9b; -fx-border-radius: 3;");

// Add the mainHBoxContainer container to existing VBox container
                    VBox itemVBox = new VBox(mainHBoxContainer);

                    trayVBox.getChildren().add(itemVBox);
                }

                caseVBox.getChildren().add(trayVBox);
            }

            jewelleryItemsVBox.getChildren().add(caseVBox);
        }
    }





}
