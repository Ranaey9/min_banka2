package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button bakiyeButton, yatirmaButton, cekmeButton, transferButton;

    @FXML
    private void goBakiye() throws Exception {
        App.setRoot("bakiye"); // bakiye.fxml açılır
    }

    @FXML
    private void goParaYatirma() throws Exception {
        App.setRoot("paraYatirma"); // paraYatirma.fxml açılır
    }

    @FXML
    private void goParaCekme() throws Exception {
        App.setRoot("paraCekme"); // paraCekme.fxml açılır
    }

    @FXML
    private void goTransfer() throws Exception {
        App.setRoot("transfer");
    }

    @FXML
    private void goToplamHesap() throws Exception {
        App.setRoot("hesapSayisi");
    }

    @FXML
    private void goVarliklar() throws Exception {
        App.setRoot("Varliklarim");
    }

    @FXML
    private void goSonIslemler() throws Exception {
        App.setRoot("sonIslemler");
    }

    @FXML
    private void goFatura() throws Exception {
        App.setRoot("FaturaOdeme");
    }

    @FXML
    private void goCikis() throws Exception {
        App.setRoot("primary");
    }
}
