module com.example.skjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.skjavafx to javafx.fxml;
    exports com.example.skjavafx;
}