package com.example.erpjavafx.controller;

import com.example.erpjavafx.dto.OperatorCredentialsDto;
import com.example.erpjavafx.factory.PopupFactory;
import com.example.erpjavafx.rest.Authenticator;
import com.example.erpjavafx.rest.AuthenticatorImpl;
import javafx.application.Platform;
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
    private Authenticator authenticator;

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
        authenticator = new AuthenticatorImpl();
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
        OperatorCredentialsDto dto = new OperatorCredentialsDto();
        dto.setLogin(login);
        dto.setPassword(password);
        authenticator.authenticate(dto, (authenticationResult) -> {
            Platform.runLater(() -> {
                waitingPopup.close();
                System.out.println(authenticationResult.isAuthenticated());
            });
        });
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
