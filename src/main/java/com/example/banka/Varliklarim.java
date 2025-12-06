package com.example.banka;

public class Varliklarim {
    private double varlikTL;
    private double borcTL;

    public Varliklarim(double varlikTL, double borcTL) {
        this.varlikTL = varlikTL;
        this.borcTL = borcTL;
    }

    public double toplamVarlik() {
        return varlikTL - borcTL;
    }

    public double getBorcTL() {
        return borcTL;
    }

    public void setVarlikTL(double varlikTL) {
        this.varlikTL = varlikTL;
    }

    public void setBorcTL(double borcTL) {
        this.borcTL = borcTL;
    }

    private double[] kurGetir() {
        double usd = 41.90;
        double eur = 48.74;
        return new double[] { usd, eur };
    }

    public void goster() {
        System.out.println("\n=== VARLIKLAR / BORÇLAR ===");
        System.out.println("Varlıklarınız: " + this.varlikTL + " TL");
        System.out.println("Borçlarınız: " + this.borcTL + " TL");

        double net = toplamVarlik();
        System.out.println("Net toplam: " + net + " TL");

        double[] kur = kurGetir();
        System.out.println("USD: " + String.format("%.2f", net / kur[0]) + " USD");
        System.out.println("EUR: " + String.format("%.2f", net / kur[1]) + " EUR");
    }
}
