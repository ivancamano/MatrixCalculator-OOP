module com.mycompany.matrixcalculatorapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.matrixcalculatorapp to javafx.fxml;
    exports com.mycompany.matrixcalculatorapp;
}
