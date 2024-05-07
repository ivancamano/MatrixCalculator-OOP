// AddController.java
package com.mycompany.matrixcalculatorapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddController extends MatrixBoxes {

    @FXML
    private TextField rowsTextField;

    @FXML
    private TextField columnsTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private GridPane matrixGridPane;

    @FXML
    private GridPane matrixGridPane1;

    @FXML 
    private GridPane matrixGridPane2;
    
    @FXML
    private Text sumText;
    
    @FXML 
    private Text testText;
            
    @FXML
    void handleConfirmButtonClick(ActionEvent event) {
        int rows = Integer.parseInt(rowsTextField.getText());
        int columns = Integer.parseInt(columnsTextField.getText());
        
        createMatrixBoxes(matrixGridPane, matrixGridPane1, rows, columns);
        confirmButton.setDisable(true);
    }

    @FXML
    void performMatrixAddition(ActionEvent event) {
        int rows = Integer.parseInt(rowsTextField.getText());
        int columns = Integer.parseInt(columnsTextField.getText());

        boolean anyEmpty = checkEmptyFields(matrixGridPane, matrixGridPane1, rows, columns);
        if (anyEmpty) {
            testText.setText("Make sure to fill all the boxes.");
            testText.setVisible(true);
            return;
        }

        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                TextField textField1 = (TextField) matrixGridPane.getChildren().get(i * columns + j);
                int value1 = Integer.parseInt(textField1.getText());
                TextField textField2 = (TextField) matrixGridPane1.getChildren().get(i * columns + j);
                int value2 = Integer.parseInt(textField2.getText());
                resultMatrix[i][j] = value1 + value2;
            }
        }
        displayResultMatrix(resultMatrix);
        testText.setVisible(false);
        sumText.setText(""); 
        sumText.setVisible(true);
    }

    private void displayResultMatrix(int[][] resultMatrix) {
        
        matrixGridPane.getChildren().clear();
        matrixGridPane1.getChildren().clear();

        int rows = resultMatrix.length;
        int columns = resultMatrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                TextField textField = new TextField();
                textField.setPrefWidth(40);
                textField.setText(String.valueOf(resultMatrix[i][j]));
                textField.setEditable(false); 
                matrixGridPane2.add(textField, j, i);
            }
        }
    }
}
