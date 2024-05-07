package com.mycompany.matrixcalculatorapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MultiplicationController extends MatrixBoxes{

    @FXML
    private TextField rowsTextFieldA;

    @FXML
    private TextField columnsTextFieldA;

    @FXML
    private TextField rowsTextFieldB;

    @FXML
    private TextField columnsTextFieldB;

    @FXML
    private Button confirmButton;

    @FXML
    private GridPane matrixGridPaneA;

    @FXML
    private GridPane matrixGridPaneB;

    @FXML
    private GridPane matrixGridPaneC;

    @FXML
    private Text resultText;
    
    @FXML 
    private Text validationText;

    @FXML
    void handleConfirmButtonClick(ActionEvent event) {
        int rowsA = Integer.parseInt(rowsTextFieldA.getText());
        int columnsA = Integer.parseInt(columnsTextFieldA.getText());
        int rowsB = Integer.parseInt(rowsTextFieldB.getText());
        int columnsB = Integer.parseInt(columnsTextFieldB.getText());

        if (columnsA != rowsB) {
            validationText.setText("Cannot multiply matrices: dimensions mismatch.");
            return;
        }
        validationText.setText("");
        createMatrixBoxes(rowsA, columnsA, matrixGridPaneA);
        createMatrixBoxes(rowsB, columnsB, matrixGridPaneB);
        confirmButton.setDisable(true);
    }


    private void createMatrixBoxes(int rows, int columns, GridPane gridPane) {
        gridPane.getChildren().clear(); 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                TextField textField = new TextField();
                textField.setPrefWidth(40); 
                textField.setPromptText("0"); 
                gridPane.add(textField, j, i); 
            }
        }
    }

    @FXML
    void performMatrixMultiplication(ActionEvent event) {
        int rowsA = Integer.parseInt(rowsTextFieldA.getText());
        int columnsA = Integer.parseInt(columnsTextFieldA.getText());
        int rowsB = Integer.parseInt(rowsTextFieldB.getText());
        int columnsB = Integer.parseInt(columnsTextFieldB.getText());

        int[][] matrixA = getMatrixValues(rowsA, columnsA, matrixGridPaneA);
        int[][] matrixB = getMatrixValues(rowsB, columnsB, matrixGridPaneB);

        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);

        displayResultMatrix(resultMatrix);
        resultText.setText("PRODUCT");
    }


    private int[][] getMatrixValues(int rows, int columns, GridPane gridPane) {
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                TextField textField = (TextField) gridPane.getChildren().get(i * columns + j);
                matrix[i][j] = Integer.parseInt(textField.getText());
            }
        }

        return matrix;
    }


    private int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int columnsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int columnsB = matrixB[0].length;

        int[][] resultMatrix = new int[rowsA][columnsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }


    private void displayResultMatrix(int[][] resultMatrix) {
        matrixGridPaneA.getChildren().clear();
        matrixGridPaneB.getChildren().clear();

        int rows = resultMatrix.length;
        int columns = resultMatrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                TextField textField = new TextField();
                textField.setPrefWidth(40);
                textField.setText(String.valueOf(resultMatrix[i][j]));
                textField.setEditable(false);
                matrixGridPaneC.add(textField, j, i);
                resultText.setText("PRODUCT");
            }
        }
    }
}
