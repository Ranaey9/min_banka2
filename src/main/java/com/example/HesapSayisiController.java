package com.example;

import com.example.banka.BankaHesabi;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HesapSayisiController {

@FXML
private Label sayacLabel;

@FXML
public void initialize() {
    BankaHesabi.gosterToplamHesapSayisi(sayacLabel);
}


    @FXML
    private void goBack() throws Exception {
        App.setRoot("Menu");
    }
}
