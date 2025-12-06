package com.example;

import com.example.banka.BankaHesabi;
import com.example.banka.Varliklarim;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VarliklarimController {

    @FXML
    private Label varlikLabel, borcLabel, netLabel, usdLabel, eurLabel;

    private BankaHesabi aktifHesap;

    @FXML
    public void initialize() {
        aktifHesap = new BankaHesabi("Rana", "Eyüp", "12345678901",
                "rana@gmail.com", "1234", "TR1001", 5000.0);

        guncelle(); 
    }

    public void guncelle() {
        Varliklarim varlik = aktifHesap.getVarliklarim();
        varlikLabel.setText("Varlıklarınız: " + varlik.toplamVarlik() + " TL");
        borcLabel.setText("Borçlarınız: " + varlik.getBorcTL() + " TL");
        double net = varlik.toplamVarlik();
        netLabel.setText("Net Toplam: " + net + " TL");

        double[] kur = new double[] {41.90, 48.74};
        usdLabel.setText("USD: " + String.format("%.2f", net / kur[0]) + " USD");
        eurLabel.setText("EUR: " + String.format("%.2f", net / kur[1]) + " EUR");
    }

    @FXML
    private void goBack() throws Exception {
        App.setRoot("Menu");
    }
    
    public BankaHesabi getAktifHesap() {
        return aktifHesap;
    }
}
