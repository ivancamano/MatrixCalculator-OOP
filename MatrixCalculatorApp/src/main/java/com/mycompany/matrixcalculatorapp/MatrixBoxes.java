// MatrixOperation.java
package com.mycompany.matrixcalculatorapp;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public abstract class MatrixBoxes {
    protected void createMatrixBoxes(GridPane matrixGridPane, GridPane matrixGridPane1, int rows, int columns) {
        matrixGridPane.getChildren().clear(); 
        matrixGridPane1.getChildren().clear(); 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                TextField textField1 = new TextField();
                textField1.setPrefWidth(40); 
                textField1.setPromptText("0"); 
                matrixGridPane.add(textField1, j, i); 

                TextField textField2 = new TextField();
                textField2.setPrefWidth(40); 
                textField2.setPromptText("0");
                matrixGridPane1.add(textField2, j, i); 
            }
        }
    }

    protected boolean checkEmptyFields(GridPane matrixGridPane, GridPane matrixGridPane1, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                TextField textField1 = (TextField) matrixGridPane.getChildren().get(i * columns + j);
                TextField textField2 = (TextField) matrixGridPane1.getChildren().get(i * columns + j);
                if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
                    return true; 
                }
            }
        }
        return false; 
    }
}
