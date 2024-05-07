package com.mycompany.matrixcalculatorapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TransposeController {
    
    @FXML
    private TextField rowsTextField;
    
    @FXML
    private TextField columnsTextField;
    
    @FXML
    private GridPane matrixGridPane;
    
    @FXML
    private Button confirmButton;
    
    @FXML
    private Text resultText;
    
    @FXML
    private void handleConfirmButtonClick(ActionEvent event) {
        int rows = Integer.parseInt(rowsTextField.getText());
        int columns = Integer.parseInt(columnsTextField.getText());
        
        matrixGridPane.getChildren().clear();
        

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                TextField textField = new TextField();
                textField.setPrefWidth(40);
                matrixGridPane.add(textField, j, i);
            }
        }
    }
@FXML
private void performMatrixTranspose(ActionEvent event) {
    int rows = Integer.parseInt(rowsTextField.getText());
    int columns = Integer.parseInt(columnsTextField.getText());

    int[][] matrix = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            TextField textField = (TextField) matrixGridPane.getChildren().get(i * columns + j);
            matrix[i][j] = Integer.parseInt(textField.getText());
        }
    }


    int[][] transpose = transposeMatrix(matrix);


    matrixGridPane.getChildren().clear();


    int transposedRows = transpose.length;
    int transposedColumns = transpose[0].length;
    for (int i = 0; i < transposedRows; i++) {
        for (int j = 0; j < transposedColumns; j++) {
            TextField textField = new TextField();
            textField.setPrefWidth(40);
            textField.setText(Integer.toString(transpose[i][j]));
            matrixGridPane.add(textField, j, i);
        }
    }


    resultText.setText("Transposed Matrix");
    resultText.setVisible(true);
}



private int[][] transposeMatrix(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    int[][] transpose = new int[columns][rows]; 
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            transpose[j][i] = matrix[i][j];
        }
    }
    return transpose;
}}
