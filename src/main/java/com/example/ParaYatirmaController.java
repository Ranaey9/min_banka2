package com.example;

import com.example.banka.BankaHesabi;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ParaYatirmaController {

    @FXML
    private TextField miktarField;

    @FXML
    private Label sonucLabel;

    @FXML
    private void yatir() {
        BankaHesabi hesap = Session.currentAccount;
        if (hesap == null) {
            sonucLabel.setText("Hesap bulunamadı!");
            return;
        }

        try {
            double miktar = Double.parseDouble(miktarField.getText());
            if (miktar <= 0) {
                sonucLabel.setText("Lütfen geçerli bir miktar girin!");
                return;
            }

            hesap.paraYatırma(miktar);

            sonucLabel.setText(miktar + " ₺ yatırıldı. Güncel bakiye: " + hesap.getBakiye() + " ₺");

            miktarField.clear();

        } catch (NumberFormatException e) {
            sonucLabel.setText("Lütfen sayısal bir değer girin!");
        }
    }

    @FXML
    private void goBack() throws Exception {
        App.setRoot("Menu"); 
    }
}
