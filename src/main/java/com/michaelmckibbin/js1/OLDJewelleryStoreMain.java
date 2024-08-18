package com.michaelmckibbin.js1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class OLDJewelleryStoreMain extends Application {

    //public static Scene storefrontscene, displaycasescene, displaytrayscene, jitemscene, jmaterialscene, allstockscene;
//    @FXML
//    private Stage mainStage;
//
    public static Scene scene1,scene2,scene3,scene4,scene5;
    public static Stage primaryStage;
    // 10.32am
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        SceneManager.getInstance().setPrimaryStage(primaryStage);
//        SceneManager.getInstance().loadStorefrontView();
//        primaryStage.show();
//    }
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(OLDJewelleryStoreMain.class.getResource("hello-view.fxml"));
        scene1 = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Jewellery Store");
        stage.setScene(scene1);
        stage.show();

// ** error ** fxml loader wouldn't work until changed to getClassLoader
//    @Override
//    public void start(Stage stage) throws IOException {
//        mainStage = stage;
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("hello-view.fxml"));
//        storefrontscene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(storefrontscene);
//        stage.show();
//    }

//    @Override
//    public void start(Stage stage) throws IOException {
//        mainStage = stage;
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Storefront-view.fxml"));
//        storefrontscene = new Scene(fxmlLoader.load(), 900, 400);
//
//        // load the CSS file
//        storefrontscene.getStylesheets().addAll("styles.css");
//
//        stage.setTitle("Jewellery Store");
//        stage.setScene(storefrontscene);
//        stage.show();
//    }

        // 10.20 am thur 15/8
//@Override
//public void start(Stage primaryStage) throws Exception {
//    Parent root = loadStorefrontView();
//    Scene scene = new Scene(root);
//    primaryStage.setScene(scene);
//    primaryStage.show();
//}

        // 10.37am
//        private Parent loadStorefrontView () throws IOException {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Storefront-view.fxml"));
//            return loader.load();
//        }

// last version
//    public void setMainStage(Stage stage) {
//        this.mainStage = stage;
//    }


//    public static void showstorefrontscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("src/main/resources/com/michaelmckibbin/js1/views/hello-view.fxml"));
//        storefrontscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainStage.setScene(storefrontscene);
//    }

//    public void showdisplaycasescene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("DisplayCase-view.fxml"));
//        displaycasescene = new Scene(fxmlLoader.load(), 900, 400);
//        mainStage.setScene(displaycasescene);
//    }


//    public static void showdisplaytrayscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("Displaytray-view.fxml"));
//        displaytrayscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainStage.setScene(displaytrayscene);
//    }
//    public static void showjitemscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("JewelleryItem-view.fxml"));
//        jitemscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainStage.setScene(jitemscene);
//    }
//    public static void showjmaterialscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("JewelleryMaterial-view.fxml"));
//        jmaterialscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainStage.setScene(jmaterialscene);
//    }
//    public static void showallstockscene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryStoreMain.class.getResource("AllStock-view.fxml"));
//        allstockscene = new Scene(fxmlLoader.load(), 900, 400);
//        mainStage.setScene(allstockscene);
//    }
//    private Image originalImage;
//
//    @FXML
//    private Button mikeyFaceButton;
//
//    @FXML
//    private ImageView mikeyFaceImageView;
//
//    @FXML
//    private void initialize() {
//        originalImage = mikeyFaceImageView.getImage();
//       // loadDisplayCaseScene();
//    }
//
//    @FXML
//    private void handleMikeyFaceButtonClick(ActionEvent event) {
//        if (mikeyFaceImageView.getImage() == originalImage) {
//            Image goldBarsImage = new Image(getClass().getResourceAsStream("/images/goldBars.jpg"));
//            mikeyFaceImageView.setImage(goldBarsImage);
//            mikeyFaceButton.setText("50% Off Gold Bars!");
//        } else {
//            mikeyFaceImageView.setImage(originalImage);
//            mikeyFaceButton.setText("Ask for details!");
//        }
//    }


//    @FXML
//    private Parent displayCaseScene;
//
//    @FXML
//    private void loadDisplayCaseScene() {
//        try {
//            displayCaseScene = FXMLLoader.load(getClass().getResource("/DisplayCase-view.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    @FXML
//    public void handleDisplayCasesButtonClick(ActionEvent actionEvent) {
//        Scene scene = new Scene(displayCaseScene);
//        mainStage.setScene(scene);
//    }


//
    }
    public static void main(String[] args) {
        launch();
    }
//public static void main(String[] args) {
//    try {
//        // Code that might throw an exception
//        int result = 1 / 0;
//    } catch (Exception e) {
//        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element : stackTrace) {
//            System.out.println(element);
//        }
//    }
//}
}