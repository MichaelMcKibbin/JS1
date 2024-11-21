package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.*;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.Random;


public class JewelleryStoreController implements Serializable {

    @FXML
    public TextFlow stockValueTextFlow;
    @FXML
    public Button stockViewButton;
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
    sPECIAL oFFER bUTTON
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
    end of SPECIAL oFFER bUTTON
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
            stage.setTitle("Display Cases");
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
            DisplayCase displayCase = new DisplayCase(caseIdNum, random.nextBoolean(), random.nextBoolean());

            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_UP);

            for (int j = 1; j <= 2; j++) { // Add 2 trays to each case
                String color = colors[random.nextInt(colors.length)];
                int wide = wideDeep[random.nextInt(wideDeep.length)];
                int deep = wideDeep[random.nextInt(wideDeep.length)];
                int trayNum = caseIdNum + i + j + counter;
                DisplayTray tray = new DisplayTray(caseIdNum, "Z" + trayNum, color, wide, deep);

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


} // end JewelleryStoreController


