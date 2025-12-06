package com.example;

import com.example.banka.BankaHesabi;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BakiyeController {

    @FXML
    private Label bakiyeLabel;

    @FXML
    public void initialize() {
        BankaHesabi hesap = Session.currentAccount;
        if (hesap != null) {
            bakiyeLabel.setText(hesap.getBakiye() + " ₺");
        } else {
            bakiyeLabel.setText("Hesap bulunamadı!");
        }
    }

    @FXML
    private void goBack() throws Exception {
        App.setRoot("Menu");
    }
}
