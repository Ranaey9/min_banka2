package com.example;

import com.example.banka.BankaHesabi;
import com.example.banka.Son_İslemler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class SonIslemlerController {

    @FXML
    private VBox islemlerContainer;

    @FXML
    private Button geriButton;

    private BankaHesabi aktifHesap;

    @FXML
    public void initialize() {
        // Örnek olarak aktif hesap oluşturuyoruz. Sen buraya login sonrası atanmış hesabı kullanmalısın.
        aktifHesap = new BankaHesabi("Rana", "Eyüp", "12345678901",
                "rana@gmail.com", "1234", "TR1001", 5000.0);

        // Örnek işlemler ekleyelim
        aktifHesap.paraYatırma(1000);
        aktifHesap.ParaCekme(500);
        aktifHesap.paraCekFatura(200, "Fatura Ödeme");

        gosterIslemler();
    }

    private void gosterIslemler() {
        islemlerContainer.getChildren().clear();

        if (aktifHesap.getIslemler().isEmpty()) {
            Label lbl = new Label("Henüz işlem yapılmamış.");
            islemlerContainer.getChildren().add(lbl);
            return;
        }

        for (Son_İslemler islem : aktifHesap.getIslemler()) {
            String islemTipi = (islem.getTutar() >= 0) ? "Gelir" : "Gider";
            String aciklama = (islem.getTutar() < 0) ? " | Açıklama: " + islem.getAciklama() : "";
            String text = "Dekont: " + islem.getDekontNo() +
                    " | Tarih: " + islem.getTarih() +
                    " | Tip: " + islemTipi +
                    " | Tutar: " + islem.getTutar() + " TL" +
                    aciklama;

            Label lbl = new Label(text);
            islemlerContainer.getChildren().add(lbl);
        }
    }

    @FXML
    private void geriGit() throws Exception {
        App.setRoot("Menu");
    }
}
