package com.example.banka;

public class Nakit {

    private Varliklarim varliklarim;

    public Nakit(double mevcutTL, double borcTL) {
        this.varliklarim = new Varliklarim(mevcutTL, borcTL);
    }

    public void paraYatir(double miktar) {
        if (miktar <= 0) {
            System.out.println("Yatırılacak miktar 0 veya negatif olamaz!");
            return;
        }
        varliklarim.setVarlikTL(varliklarim.toplamVarlik() + miktar);
        System.out.println(miktar + " TL yatırıldı.");
        goster();
    }

    public boolean paraCek(double miktar) {
        if (miktar <= 0 || miktar > varliklarim.toplamVarlik()) {
            System.out.println("Yetersiz bakiye veya geçersiz miktar!");
            return false;
        }
        varliklarim.setVarlikTL(varliklarim.toplamVarlik() - miktar);
        System.out.println(miktar + " TL çekildi.");
        goster();
        return true;
    }

    public void goster() {
        varliklarim.goster();
    }

    public double getTL() {
        return varliklarim.toplamVarlik();
    }

    public void setTL(double miktar) {
        varliklarim.setVarlikTL(miktar);
    }
}
