/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matrixcalculatorapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.Node;

public class DeterminantController {

    @FXML
    private Button size2x2Button;

    @FXML
    private Button size3x3Button;

    @FXML
    private Button size4x4Button;

    @FXML
    private GridPane matrixGridPane;

    @FXML
    private Text resultText;

    @FXML
    private Button calculate;


    @FXML
    void handleSize2x2ButtonClick() {
        createMatrixGrid(2);
    }


    @FXML
    void handleSize3x3ButtonClick() {
        createMatrixGrid(3);
}


    @FXML
    void handleSize4x4ButtonClick() {
        createMatrixGrid(4);
    }


    private void createMatrixGrid(int size) {
    matrixGridPane.getChildren().clear();

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            TextField textField = new TextField();
            textField.setPrefWidth(40);
            textField.setPromptText("0");
            matrixGridPane.add(textField, j, i);
        }
    }
}


    @FXML
    void calculateDeterminant() {
    int size = (int) Math.sqrt(matrixGridPane.getChildren().size()); 
    int[][] matrix = getMatrixValues(size);

    long determinant; 
    switch (size) {
        case 2:
            determinant = calculate2x2Determinant(matrix);
            break;
        case 3:
            determinant = calculate3x3Determinant(matrix);
            break;
        case 4:
            determinant = calculate4x4Determinant(matrix);
            break;
        default:
            determinant = 0; 
            break;
    }

    resultText.setText("Determinant: " + determinant);
}



    private int[][] getMatrixValues(int size) {
    int[][] matrix = new int[size][size];

    for (Node node : matrixGridPane.getChildren()) {
        if (node instanceof TextField) {
            int row = GridPane.getRowIndex(node);
            int col = GridPane.getColumnIndex(node);
            matrix[row][col] = Integer.parseInt(((TextField) node).getText());
        }
    }

    return matrix;
}

    private int calculate2x2Determinant(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    private int calculate3x3Determinant(int[][] matrix) {
    int det = 0;
    det += matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]);
    det -= matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
    det += matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    return det;
}


private int calculate4x4Determinant(int[][] matrix) {
    int det = 0;
    for (int i = 0; i < 4; i++) {
        int[][] subMatrix = new int[3][3];
        int subRowIndex = 0, subColIndex;
        for (int rowIndex = 1; rowIndex < 4; rowIndex++) {
            subColIndex = 0;
            for (int colIndex = 0; colIndex < 4; colIndex++) {
                if (colIndex == i)
                    continue;
                subMatrix[subRowIndex][subColIndex] = matrix[rowIndex][colIndex];
                subColIndex++;
            }
            subRowIndex++;
        }
        int subDet = subMatrix[0][0] * (subMatrix[1][1] * subMatrix[2][2] - subMatrix[1][2] * subMatrix[2][1])
                - subMatrix[0][1] * (subMatrix[1][0] * subMatrix[2][2] - subMatrix[1][2] * subMatrix[2][0])
                + subMatrix[0][2] * (subMatrix[1][0] * subMatrix[2][1] - subMatrix[1][1] * subMatrix[2][0]);
        det += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * subDet;
    }
    return det;
}
}