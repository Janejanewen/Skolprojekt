module com.example.marstravels {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.marstravels to javafx.fxml;
    exports com.example.marstravels;
}