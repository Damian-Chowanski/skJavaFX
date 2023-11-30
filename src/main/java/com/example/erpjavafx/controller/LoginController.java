package com.example.erpjavafx.controller;

import com.example.erpjavafx.dto.UserCredentialsDto;
import com.example.erpjavafx.factory.PopupFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private PopupFactory popupFactory;

    @FXML
    private Button exitBtn;

    @FXML
    private Button logInBtn;

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private TextField login_tf;

    @FXML
    private TextField password_tf;

    public LoginController(){
        popupFactory = new PopupFactory();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("login Started");
        initializeExitButton();
        initializeLoginBtn();
    }

    private void initializeLoginBtn() {
        logInBtn.setOnAction((x) -> {
            performAuthentication();
        });
    }

    private void performAuthentication() {
        Stage waitingPopup = popupFactory.createWaitingPopup("Connecting to the server...");
        waitingPopup.show();
        String login = login_tf.getText();
        String password = password_tf.getText();
        UserCredentialsDto dto = new UserCredentialsDto();
        dto.setLogin(login);
        dto.setPassword(password);
    }

    private void initializeExitButton() {
        exitBtn.setOnAction((x) -> {
            getStage().close();
        });
    }

    private Stage getStage(){
        return (Stage) loginAnchorPane.getScene().getWindow();
    }
}
