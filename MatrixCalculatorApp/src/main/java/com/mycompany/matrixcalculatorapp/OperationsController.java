package com.mycompany.matrixcalculatorapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class OperationsController {

    @FXML
    private Button multiplyButton;

    @FXML
    private Button addButton;

    @FXML
    private Button transposeButton;

    @FXML
    private Button subtractButton;

    @FXML
    private Button determinantButton;

    @FXML
    private Button closeButton;


    @FXML
    void handleAddButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Add.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage matrixSizeStage = new Stage();
    matrixSizeStage.setScene(scene);
    matrixSizeStage.setTitle("Add Matrix");
    matrixSizeStage.show();
}
    
    @FXML
    void handleSubtractButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Subtract.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage matrixSizeStage = new Stage();
    matrixSizeStage.setScene(scene);
    matrixSizeStage.setTitle("Subtract Matrix");
    matrixSizeStage.show();       
    }

 
    @FXML
    void handleMultiplyButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Multiply.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage matrixSizeStage = new Stage();
    matrixSizeStage.setScene(scene);
    matrixSizeStage.setTitle("Multiply Matrix");
    matrixSizeStage.show();
    }

    
    @FXML
    void handleTransposeButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Transpose.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage matrixSizeStage = new Stage();
    matrixSizeStage.setScene(scene);
    matrixSizeStage.setTitle("Transpose Matrix");
    matrixSizeStage.show();
    }

    
    @FXML
    void handleDeterminantButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Determinant.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage matrixSizeStage = new Stage();
    matrixSizeStage.setScene(scene);
    matrixSizeStage.setTitle("Matrix Determinants");
    matrixSizeStage.show();
    }

    @FXML
    void handleCloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Operation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
