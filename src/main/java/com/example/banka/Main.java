package com.example.banka;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BankaHesabi hesap1 = new BankaHesabi("Rana", "Eyüp", "12345678901",
                "rana@gmail.com", "1234", "TR1001", 5000.0);
        Kredi_Hesaplama hesap2 = new Kredi_Hesaplama("Ali", "Yılmaz", "98765432100", "ali@gmail.com", "5678", "TR1002",
                7000.0);

        ArrayList<BankaHesabi> hesaplar = new ArrayList<>();
        hesaplar.add(hesap1);
        hesaplar.add(hesap2);

        BankaHesabi aktifHesap = null;

        while (aktifHesap == null) {
            System.out.print("Adınızı girin: ");
            String ad = input.next();
            System.out.print("Soyadınızı girin: ");
            String soyad = input.next();
            System.out.print("Şifrenizi girin: ");
            String sifre = input.next();

            for (BankaHesabi h : hesaplar) {
                if (h.getİsim().equalsIgnoreCase(ad)
                        && h.getSoyad().equalsIgnoreCase(soyad)
                        && h.getSifre().equals(sifre)) {
                    aktifHesap = h;
                    break;
                }
            }

            if (aktifHesap == null) {
                System.out.println("\nHatalı giriş! Tekrar deneyin.\n");
            }
        }

        System.out.println("\nHoş geldiniz, " + aktifHesap.getİsim() + "!\n");
        Portfoyum aktifPortfoy = new Portfoyum(aktifHesap);

        Menu menu = new Menu(input, aktifHesap, aktifPortfoy);
        menu.baslat(aktifHesap);
        input.close();
        System.out.println("Program sonlandırıldı.");
    }
}