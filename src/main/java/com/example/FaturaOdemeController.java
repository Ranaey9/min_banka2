package com.example;

import com.example.banka.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class FaturaOdemeController {

    @FXML private VBox paymentPane;
    @FXML private Label secilenFaturaLabel;
    @FXML private TextField miktarField;
    @FXML private Label sonucLabel;

    private String secilenFatura = null;

    private static BankaHesabi aktifHesap =
            new BankaHesabi("Ali", "Yılmaz", "123", "a@a.com", "1", "1111", 5000);

    @FXML
    private void handleFaturaSecim(javafx.event.ActionEvent event) {
        Button btn = (Button) event.getSource();
        secilenFatura = (String) btn.getUserData();

        paymentPane.setVisible(true);
        secilenFaturaLabel.setText("Seçilen Fatura: " + secilenFatura);
        sonucLabel.setText("");
    }

    @FXML
    private void ode() {
        if (secilenFatura == null) {
            sonucLabel.setText("Lütfen bir fatura seçiniz!");
            return;
        }

        double miktar;
        try {
            miktar = Double.parseDouble(miktarField.getText());
        } catch (Exception e) {
            sonucLabel.setText("Geçerli bir miktar giriniz!");
            return;
        }

        Fatura_Odeme fatura;

        switch (secilenFatura) {
            case "Elektrik" -> fatura = new Elektrik();
            case "Su" -> fatura = new Su();
            case "Internet" -> fatura = new İnternet();
            case "Telefon" -> fatura = new Telefon();
            case "TV" -> fatura = new TV();
            case "Dogalgaz" -> fatura = new DogalGaz();
            default -> {
                sonucLabel.setText("Hata oluştu!");
                return;
            }
        }

        double onceki = aktifHesap.getBakiye();
        fatura.odeme(miktar, aktifHesap);

        if (aktifHesap.getBakiye() < onceki) {
            sonucLabel.setText("Ödeme başarılı! Yeni bakiye: " + aktifHesap.getBakiye());
        } else {
            sonucLabel.setText("Yetersiz bakiye!");
        }
    }


    @FXML
    private void goBack() throws Exception {
        App.setRoot("menu");
    }
}
