package com.example;

import com.example.banka.BankaHesabi;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TransferController {

    @FXML
    private TextField miktarField;

    @FXML
    private Label sonucLabel;

    // transfer edilcek hesap
    private BankaHesabi hedefHesap = new BankaHesabi(
            "Ali", "Yılmaz", "98765432100", "ali@gmail.com", "5678", "TR1002", 7000.0);

    @FXML
    private void transferEt() {
        BankaHesabi gonderici = Session.currentAccount;
        if (gonderici == null) {
            sonucLabel.setText("Hesap bulunamadı!");
            return;
        }

        try {
            double miktar = Double.parseDouble(miktarField.getText());
            if (miktar <= 0) {
                sonucLabel.setText("Lütfen geçerli bir miktar girin!");
                return;
            }

            if (miktar > gonderici.getBakiye()) {
                sonucLabel.setText("Yetersiz bakiye! Mevcut bakiye: " + gonderici.getBakiye() + " ₺");
                return;
            }

            gonderici.transfer(hedefHesap, miktar);

            sonucLabel.setText(miktar + " ₺ başarıyla " + hedefHesap.getHesapNo() +
                    " numaralı hesaba transfer edildi.\nGüncel bakiye: " + gonderici.getBakiye() + " ₺");

            miktarField.clear();

        } catch (NumberFormatException e) {
            sonucLabel.setText("Lütfen sayısal bir değer girin!");
        }
    }

    @FXML
    private void goBack() throws Exception {
        App.setRoot("Menu"); // Menüye geri dön
    }
}
