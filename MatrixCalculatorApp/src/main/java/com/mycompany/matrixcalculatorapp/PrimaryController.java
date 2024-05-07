package com.mycompany.matrixcalculatorapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PrimaryController {

    @FXML
    private Button operationsButton;

    @FXML
    private Button closeButton;

    @FXML
    void handleOperationsButtonClick(ActionEvent event) throws IOException {       
    Stage currentStage = (Stage) operationsButton.getScene().getWindow();
    currentStage.close();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Operations.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage operationsStage = new Stage();
    operationsStage.setScene(scene);
    operationsStage.setTitle("Matrix Operations");
    operationsStage.show();
}


    @FXML
    void handleCloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
