module com.michaelmckibbin.js1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.michaelmckibbin.js1 to javafx.fxml;
    exports com.michaelmckibbin.js1;
}