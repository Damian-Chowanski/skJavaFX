package com.example.erpjavafx.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        exitBtn.setOnAction((x) -> {
            System.out.println("exit");
        });
    }
}
