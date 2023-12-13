module com.example.erpjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires spring.web;


    opens com.example.erpjavafx to javafx.fxml;
    exports com.example.erpjavafx;
    exports com.example.erpjavafx.controller;
    opens com.example.erpjavafx.controller to javafx.fxml;
}