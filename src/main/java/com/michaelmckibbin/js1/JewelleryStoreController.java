package com.michaelmckibbin.js1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;


public class JewelleryStoreController implements Serializable {

    @FXML
    public TextFlow stockValueTextFlow;
    @FXML
    public Button stockViewButton;
    @FXML
    public VBox storefrontHighlightVBox;
    @FXML
    private Button deleteAllStockButton;
    @FXML
    private Button loadFileButton;
    @FXML
    private Button saveFileButton;
    @FXML
    private Button makeBackupButton;
    @FXML
    private Button saveAndExitButton;
    @FXML
    private Button closeProgButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField loginUsernameField;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    private Text loginBoxActionMessage;


//    // for testing
//    @FXML
//    public Text loginBoxActionMessage;
//
//    @FXML
//    public Button loginButton;
//
//    @FXML
//    public void handleLoginButtonAction(ActionEvent actionEvent) {
//        loginBoxActionMessage.setText("Login button clicked!");
//        System.out.println("Login button clicked!");
//        System.out.println("in handleLoginButtonAction");
//        System.out.println("in JewelleryStoreController");
//        // TODO - add login function
//        // open Storefront-view
//
//    } // end of for testing

    /*
    storefront centre pic
     */
    @FXML
    private Image originalImage;

    @FXML
    private Button mikeyFaceButton;

    @FXML
    private ImageView mikeyFaceImageView;

    @FXML
    private void initialize() {
        originalImage = mikeyFaceImageView.getImage();
        fillHighlightVBox();

    }

    @FXML
    private void handleMikeyFaceButtonClick(ActionEvent event) {
        if (mikeyFaceImageView.getImage() == originalImage) {
            Image goldBarsImage = new Image(getClass().getResourceAsStream("/images/goldBars.jpg"));
            mikeyFaceImageView.setImage(goldBarsImage);
            mikeyFaceButton.setText("It's mine!\nAll mine!\n\nMuahahaha!");
            // add function here

        } else {
            mikeyFaceImageView.setImage(originalImage);
            mikeyFaceButton.setText("\u2615");
        }
    }
    /*
    end of storefront centre pic
     */

    /*
MENUBAR options
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

    public void saveAndExit(ActionEvent actionEvent) {
        // saveDisplayCases
        saveDisplayCasesToFile("displayCases.ser");
        // clear all lists
        deleteAllStock();
        // exit
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public void closeProg(ActionEvent actionEvent) {
        // clear all lists
        deleteAllStock();
        // exit
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public void deleteAllStock(ActionEvent actionEvent) {
        System.out.println("Delete all stock button clicked!");
        // show confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete all stock?", ButtonType.YES, ButtonType.NO);
        // clear cases list
        // displayCases.clear();
        deleteAllStock();
    }

    public void viewAllStock(ActionEvent actionEvent) {
        System.out.println("View all stock button clicked!");


    }

    public void drillDown(ActionEvent actionEvent) {
        System.out.println("Drill down button clicked!");
    }

    public void loadTestData(ActionEvent actionEvent) {

    }

    public void viewAbout(ActionEvent actionEvent) {
        System.out.println("viewAbout button clicked!");
        // generate popup window
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle("About");
        about.setHeaderText("Mikey's Jewellery Store");
        about.setContentText("Jewellery Store is a JavaFX application that allows you to manage a jewellery store.\n\n" +
                "It contains display cases, trays, jewellery items, and materials.\n\n" +
                "Michael McKibbin\n\n" +
                "20092733");

        // Customize
        Stage stage = (Stage) about.getDialogPane().getScene().getWindow();
        about.getButtonTypes().setAll(ButtonType.OK);
        about.showAndWait();

    }

    //    public void viewReadme(ActionEvent actionEvent) {
//        System.out.println("viewReadme button clicked!");
//        // generate popup window
//        Alert readme = new Alert(Alert.AlertType.INFORMATION);
//        readme.setTitle("Readme");
//        readme.setHeaderText("Readme");
//        // show README.md file
//        String readmeText = "";
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("README.md"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                readmeText += line + "\n";
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        readme.setContentText(readmeText);
//        // Customize
//        Stage stage = (Stage) readme.getDialogPane().getScene().getWindow();
//        readme.getButtonTypes().setAll(ButtonType.OK);
//        readme.showAndWait();
//    }
    public void viewReadme(ActionEvent actionEvent) {
        System.out.println("viewReadme button clicked!");

        Alert readme = new Alert(Alert.AlertType.INFORMATION);
        readme.setTitle("Readme");
        readme.setHeaderText("Readme");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefWidth(500);
        textArea.setPrefHeight(400);

        // Add custom styling
        textArea.setStyle("-fx-font-family: 'Segoe UI', Arial, sans-serif; " +
                "-fx-font-size: 14px; " +
                "-fx-background-color: #fafafa; " +
                "-fx-border-color: #e0e0e0; " +
                "-fx-border-radius: 4px; " +
                "-fx-padding: 10px;");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("README.md"));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            textArea.setText(content.toString());

            // Scroll to top
            textArea.positionCaret(0);

        } catch (IOException e) {
            textArea.setText("Error reading README.md file: " + e.getMessage());
            textArea.setStyle(textArea.getStyle() + "-fx-text-fill: red;");
            e.printStackTrace();
        }

        readme.getDialogPane().setContent(textArea);

        // Make dialog resizable
        readme.setResizable(true);

        // Set minimum dimensions
        readme.getDialogPane().setMinWidth(450);
        readme.getDialogPane().setMinHeight(350);

        // Center on screen
        Stage stage = (Stage) readme.getDialogPane().getScene().getWindow();
        stage.centerOnScreen();

        readme.getButtonTypes().setAll(ButtonType.OK);
        readme.showAndWait();
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
    private Button stockValuesButton;
    @FXML
    private Button DrilldownButton;
    @FXML
    private Button AltBrowseButton;
    @FXML
    private Button SearchPageButton;

    @FXML
    public void handleSearchPageButtonClick(ActionEvent actionEvent) {
        System.out.println("Search Page button clicked!");
        // open Storefront-view.fxml in a new window
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Search-view.fxml"));
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
            stage.setTitle("Search");
            // end of option with css from styles.css in resources folder


            // Get the current stage (window) and close it
            Stage currentStage = (Stage) SearchPageButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
    public void handleStockValuesButtonClick(ActionEvent actionEvent) {

        // open StockValues-view.fxml
        try {
            // Load the view
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("StockValues-view.fxml"));
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
            stage.setTitle("Stock Value Lists");
            // end of option with css from styles.css in resources folder

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) stockValuesButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDrilldownButtonClick(ActionEvent actionEvent) {

        // open StockValues-view.fxml
        try {
            // Load the view
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Drilldown-view.fxml"));
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
            stage.setTitle("Drilldown view");
            // end of option with css from styles.css in resources folder

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) DrilldownButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    End of Navigation Buttons
     */


    private static MyLinkedList<DisplayCase> getAllDisplayCases() {
        MyLinkedList<DisplayCase> allDisplayCases = new MyLinkedList<>();
        for (DisplayCase displayCase : DisplayCaseController.displayCases) {
            allDisplayCases.add(displayCase);
        }
        return allDisplayCases;
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

    public void onLoadSampleData(ActionEvent actionEvent) {
        // create sample data
        Random random = new Random();
        String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Pink", "Brown", "Black", "White"};
        String[] materials = {"Gold", "Silver", "Platinum", "Titanium", "Steel", "Wood", "Copper", "Brass", "Stainless Steel", "Aluminum"};
        String[] itemTypes = {"Ring", "Necklace", "Earring", "Bracelet", "Anklet", "Set of Cufflinks", "Watch", "Broach", "Handbag", "Pair of Sunglasses"};
        String[] trueFalse = {"true", "false"};
        String[] gender = {"Male", "Female", "Unisex"};
        int[] wideDeep = {10, 20, 30, 40, 50};
//        int[] quant = {1, 2, 3, 4, 5};

        String[] materialsUnits = {"Grams", "Karats", "oz", "cm", "Other"};

        for (int i = 1; i <= 5; i++) { // Create 5 display cases
            int counter = 0;
            int caseIdNum = 900 + i + counter;
            counter++;
            // Convert caseIDNum to String
            String caseId = String.valueOf(caseIdNum);
            DisplayCase displayCase = new DisplayCase(caseId, random.nextBoolean(), random.nextBoolean());

            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_UP);

            for (int j = 1; j <= 2; j++) { // Add 2 trays to each case
                String color = colors[random.nextInt(colors.length)];
                int wide = wideDeep[random.nextInt(wideDeep.length)];
                int deep = wideDeep[random.nextInt(wideDeep.length)];
                int trayNum = caseIdNum + i + j + counter;
                DisplayTray tray = new DisplayTray("Z" + trayNum, color, wide, deep);

                for (int k = 1; k <= 2; k++) { // Add 2 jewellery items to each tray
                    int itemIdNum = trayNum + i + j + k + counter;
                    counter++;
                    String itemId = String.valueOf(itemIdNum);
                    String itemType = itemTypes[random.nextInt(itemTypes.length)];
                    String itemName = "A lovely " + itemType;
                    double itemPrice = Double.parseDouble(df.format(1 + random.nextDouble() * 1000)); // Random price between 1 and 1000

                    String genderChoice = gender[random.nextInt(gender.length)];
                    JewelleryItem item = new JewelleryItem(itemId, itemName, itemType, "A beautiful " + itemType, genderChoice, "/images/jewelleryGeneral.jpg", itemPrice);

                    for (int l = 1; l <= 2; l++) { // Add 2 materials to each item
                        int materialIdNum = itemIdNum + i + j + k + l + counter;
                        counter++;
                        String materialId = String.valueOf(materialIdNum);
                        String materialName = materials[random.nextInt(materials.length)] + materialIdNum;
                        String materialDescription = "A high quality " + materialName + " material";
                        String materialUnit = materialsUnits[random.nextInt(materialsUnits.length)];
                        //int quantity = quant[random.nextInt(quant.length)];
                        // quantity = random int between 1 and 10
                        int quantity = random.nextInt(10) + 1;
                        // create a random quality attribute and convert to String. Need quality to be a string to allow for "24k", "pure", "0.925", etc.
                        // generate a random number between 0 and 100
                        double randomDouble = random.nextDouble() * 100;
                        // round the random number to three decimal places
                        double roundedDouble = Math.round(randomDouble * 1000.0) / 1000.0;
                        // convert the rounded number to a string
                        String roundedString = String.valueOf(roundedDouble);
                        String quality = roundedString;
                        // material price = random positive double between 1 and 100 rounded to two decimal places
                        double materialPrice = Double.parseDouble(df.format(1 + random.nextDouble() * 100));
                        //double materialPrice = ((Math.floor(random.nextDouble() * 20) * 100)) / 100;
                        JewelleryMaterial jewelerylMaterial = new JewelleryMaterial(materialId, materialName, materialDescription, materialUnit, "/images/jewelleryGeneral.jpg", quantity, quality, materialPrice);
                        item.addJewelleryMaterial(jewelerylMaterial);
                    }
                    tray.addJewelleryItem(item);
                }
                displayCase.addDisplayTray(tray);
            }
            DisplayCaseController.displayCases.add(displayCase);
        }
        System.out.println("Sample data created: " + DisplayCaseController.displayCases.size() + " display cases");
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

    // delete all stock
    public void onDeleteAllStock(ActionEvent actionEvent) {
        deleteAllStock();
        System.out.println("All stock deleted");
    }

    @FXML
    public Label displayAllStockTotal;

    @FXML
    public void onTotalValueOfStock(ActionEvent actionEvent) {
        double totalJewelleryValue = calculateTotalValueOfJewellery();
        double totalMaterialValue = calculateTotalValueOfMaterials();
        displayJewelleryTotal.setText("€ " + totalJewelleryValue);
        displayMaterialsTotal.setText("€ " + totalMaterialValue);
    }

    @FXML
    public Label displayJewelleryTotal;
    @FXML
    public Label displayMaterialsTotal;

    // calculate total value of jewellery
    private static double calculateTotalValueOfJewellery() {
        double totalJewelleryValue = 0;

        for (DisplayCase displayCase : DisplayCaseController.displayCases) {
            for (DisplayTray displayTray : displayCase.getDisplayTrays()) {
                for (JewelleryItem jewelleryItem : displayTray.getJewelleryItems()) {
                    totalJewelleryValue += jewelleryItem.getItemPrice();
                }
            }
        }
        // truncate to 2 decimal places
        totalJewelleryValue = Math.floor(totalJewelleryValue * 100) / 100;
        return totalJewelleryValue;
    }

    // calculate total value of materials
    private static double calculateTotalValueOfMaterials() {
        double totalMaterialValue = 0;

        for (DisplayCase displayCase : DisplayCaseController.displayCases) {
            for (DisplayTray displayTray : displayCase.getDisplayTrays()) {
                for (JewelleryItem jewelleryItem : displayTray.getJewelleryItems()) {
                    for (JewelleryMaterial jewelleryMaterial : jewelleryItem.getJewelleryMaterials()) {
                        double matVal = jewelleryMaterial.getJewelleryMaterialPrice();
                        double matQty = jewelleryMaterial.getJewelleryMaterialQuantity();
                        double materialValue = matVal * matQty;
                        totalMaterialValue += materialValue;
                        // truncate to 2 decimal places
                        totalMaterialValue = Math.floor(totalMaterialValue * 100) / 100;
                    }
                }
            }
        }
        return totalMaterialValue;

    }


    @FXML
    public void handleAltBrowseButtonClick(ActionEvent actionEvent) {
        System.out.println("AltBrowse button clicked!");
        // open AltBrowse-view.fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("AltBrowse-view.fxml"));
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
            stage.setTitle("AltBrowse");
            // end of option with css from styles.css in resources folder


            // Get the current stage (window) and close it
            Stage currentStage = (Stage) AltBrowseButton.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // storefrontHighlightVBox
    // display a clock with current time in 24 hour format
    @FXML
//    public void fillHighlightVBox() {
//        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//            storefrontHighlightVBox.getChildren().clear();
//            storefrontHighlightVBox.getChildren().add(new Label(LocalDateTime.now().format(formatter)));
//        }), new KeyFrame(Duration.seconds(1)));
//        clock.setCycleCount(Timeline.INDEFINITE);
//        clock.play();
//    }
//    public void fillHighlightVBox() {
//        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//            Label timeLabel = new Label(LocalDateTime.now().format(formatter));
//
//            // Set font size and style
//            timeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//
//            // Add some styling
//            timeLabel.setStyle("-fx-background-color: #f0f0f0; " +
//                    "-fx-padding: 10px; " +
//                    "-fx-background-radius: 5px;");
//
//            // Center the label
//            timeLabel.setAlignment(Pos.CENTER);
//            VBox.setMargin(timeLabel, new Insets(10));
//
//            // Clear and add to VBox
//            storefrontHighlightVBox.getChildren().clear();
//            storefrontHighlightVBox.getChildren().add(timeLabel);
//
//            // Center in VBox
//            storefrontHighlightVBox.setAlignment(Pos.CENTER);
//            storefrontHighlightVBox.setPadding(new Insets(10));
//
//        }), new KeyFrame(Duration.seconds(1)));
//
//        clock.setCycleCount(Timeline.INDEFINITE);
//        clock.play();
//    }
//    public void fillHighlightVBox() {
//        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//            // Create the message label
//            Label messageLabel = new Label("It's time to save!");
//            messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
//            messageLabel.setStyle("-fx-text-fill: #2c3e50; " +
//                    "-fx-padding: 5px; " +
//                    "-fx-background-color: #ecf0f1; " +
//                    "-fx-background-radius: 3px;");
//            messageLabel.setAlignment(Pos.CENTER);
//            VBox.setMargin(messageLabel, new Insets(0, 0, 5, 0));
//
//            // Create the clock label
//            Label timeLabel = new Label(LocalDateTime.now().format(formatter));
//            timeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//            timeLabel.setStyle("-fx-background-color: #f0f0f0; " +
//                    "-fx-padding: 10px; " +
//                    "-fx-background-radius: 5px; " +
//                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 3, 0, 0, 1);");
//            timeLabel.setAlignment(Pos.CENTER);
//            VBox.setMargin(timeLabel, new Insets(5));
//
//            // Clear and add both labels to VBox
//            storefrontHighlightVBox.getChildren().clear();
//            storefrontHighlightVBox.getChildren().addAll(messageLabel, timeLabel);
//
//            // Style the VBox
//            storefrontHighlightVBox.setAlignment(Pos.CENTER);
//            storefrontHighlightVBox.setPadding(new Insets(15));
//            storefrontHighlightVBox.setStyle("-fx-background-color: white; " +
//                    "-fx-background-radius: 10px; " +
//                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);");
//
//        }), new KeyFrame(Duration.seconds(1)));
//
//        clock.setCycleCount(Timeline.INDEFINITE);
//        clock.play();
//    }
    public void fillHighlightVBox() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            // Create the message label
            Label messageLabel = new Label("It's time to save!");
            messageLabel.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD, 18));
            messageLabel.setStyle("-fx-text-fill: #2c3e50; " +
                    "-fx-padding: 15px; " +
                    "-fx-background-color: #ecf0f1; " +
                    "-fx-background-radius: 3px;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 3, 0, 1, 1);");
            messageLabel.setAlignment(Pos.CENTER);
            VBox.setMargin(messageLabel, new Insets(0, 0, 5, 0));

            // Create the clock label
            Label timeLabel = new Label(LocalDateTime.now().format(formatter));
            timeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            timeLabel.setStyle("-fx-background-color: #f0f0f0; " +
                    "-fx-padding: 15px; " +
                    "-fx-background-radius: 5px; " +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 3, 0, 1, 1);");
            timeLabel.setAlignment(Pos.CENTER);
            VBox.setMargin(timeLabel, new Insets(5));

            // Calculate days until Christmas
            LocalDate today = LocalDate.now();
            LocalDate christmas = LocalDate.of(today.getYear(), 12, 25);
            if (today.isAfter(christmas)) {
                christmas = LocalDate.of(today.getYear() + 1, 12, 25);
            }
            long daysUntilChristmas = ChronoUnit.DAYS.between(today, christmas);
            long secondsUntilChristmas = ChronoUnit.SECONDS.between(LocalDateTime.now(), christmas.atStartOfDay());

            // Create the countdown label with custom message
            String countdownText = daysUntilChristmas == 0 ? "🎄\n" + "Merry Christmas!\n" + "🎄" :
                    daysUntilChristmas == 1 ? "🎅\n" + "Christmas is tomorrow!\n" + "🎅" :
                            "🎄\n" + daysUntilChristmas + " days \n until \n Christmas!\n" + "🎄" + "\n\n\nSeconds 'til Santa!\n" + secondsUntilChristmas;

            Label countdownLabel = new Label(countdownText);
            countdownLabel.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD, 16));
            countdownLabel.setStyle("-fx-text-fill: #066408; " +
                    "-fx-padding: 8px 15px; " +
                    "-fx-background-color: linear-gradient(to bottom right, #fcc0c9, #a0d784); " +
                    "-fx-background-radius: 4px; " +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 2, 0, 1, 1);");
            countdownLabel.setMaxWidth(Double.MAX_VALUE);
            countdownLabel.setAlignment(Pos.CENTER);
            countdownLabel.setTextAlignment(TextAlignment.CENTER);  // Add this for text alignment
            VBox.setMargin(countdownLabel, new Insets(10, 0, 0, 0));

            // Clear and add all labels to VBox
            storefrontHighlightVBox.getChildren().clear();
            storefrontHighlightVBox.getChildren().addAll(messageLabel, timeLabel, countdownLabel);

            // Style the VBox
            storefrontHighlightVBox.setAlignment(Pos.CENTER);
            storefrontHighlightVBox.setPadding(new Insets(15));
            storefrontHighlightVBox.setStyle("-fx-background-color: white; " +
                    "-fx-background-radius: 10px; " +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);");

        }), new KeyFrame(Duration.seconds(1)));

        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();
    }


} // end JewelleryStoreController


