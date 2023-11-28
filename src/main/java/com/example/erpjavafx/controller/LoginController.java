package com.example.erpjavafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button exitBtn;

    @FXML
    private Button logInBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("login Started");
    }
}
