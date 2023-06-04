package com.easyline;

import java.io.IOException;

import com.easyline.dao.LoginDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button appLoginBtn;

    @FXML
    private TextField loginField;

    @FXML
    private Label loginMsg;

    @FXML
    private PasswordField passwordField;

    public void appLoginBtnOnAction(ActionEvent event) {
        if (loginField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            String username = loginField.getText();
            String password = passwordField.getText();
            LoginDAO login = new LoginDAO();
            Boolean loginResult = login.select(username, password);
            System.out.println(loginResult);
        } else {
            loginMsg.setText("Il faut saisir les deux champs !");
        }
    }
}
