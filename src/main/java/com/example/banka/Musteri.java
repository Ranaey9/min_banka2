package com.example.banka;

public class Musteri {
    public String İsim;
    String Soyad;
    String tcNo;
    String e_mail;
    String Sifre;

    public Musteri(String İsim, String Soyad, String tcNo, String email, String Sifre) {
        this.İsim = İsim;
        this.Soyad = Soyad;
        this.tcNo = tcNo;
        this.e_mail = email;
        this.Sifre = Sifre;
    }

    public String getİsim() {
        return İsim;
    }

    public String getSoyad() {
        return Soyad;
    }

    public String getTcNo() {
        return tcNo;
    }

 
    public String getE_mail() {
        return e_mail;
    }

    public String getSifre() {
        return Sifre;
    }

    public int getToplamHesapSayisi() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getToplamHesapSayisi'");
    }

}
