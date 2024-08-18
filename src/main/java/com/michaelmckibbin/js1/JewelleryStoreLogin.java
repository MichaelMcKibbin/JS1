package com.michaelmckibbin.js1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class JewelleryStoreLogin extends JewelleryStoreController {
    @FXML
    public Text loginBoxActionMessage;

    @FXML
    public Button loginButton;

    @FXML
    public void handleLoginButtonAction(ActionEvent actionEvent) {
        loginBoxActionMessage.setText("Login button clicked!");
        System.out.println("Login button clicked!");


//        System.out.println("in handleLoginButtonAction");
//        System.out.println("in JewelleryStoreLogin");
//        // TODO - add login function

        FXMLLoader fxmlLoader= new FXMLLoader(JewelleryStoreMain.class.getResource("Storefront-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //open Storefront-view.fxml




        }
    }
