package com.example;

import com.example.banka.BankaHesabi;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class PrimaryController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (user.equals("Rana") && pass.equals("1234")) {
            BankaHesabi hesap = new BankaHesabi(
                    "Rana",
                    "Eyüp",
                    "12345678901",
                    "rana@gmail.com",
                    "1234",
                    "TR1001",
                    5000.0);
            Session.currentAccount = hesap;

            try {
                App.setRoot("Menu");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Hatalı kullanıcı veya şifre");
        }
    }
}
