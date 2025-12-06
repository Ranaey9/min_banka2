package com.example.banka;

import java.util.Scanner;

public class Menu {
    private final Scanner input;
    private Portfoyum aktifPortfoy;
    private BankaHesabi aktifHesap;

    public Menu(Scanner input, BankaHesabi aktifHesap, Portfoyum aktifPortfoy) {
        this.input = input;
        this.aktifHesap = aktifHesap;
        this.aktifPortfoy = aktifPortfoy;
    }

    public void baslat(BankaHesabi hesap2) {
        boolean devam = true;

        while (devam) {
            System.out.println(
                    "\n===== BANKA MENÜSÜ (" + aktifPortfoy.getİsim() + " " + aktifPortfoy.getSoyad() + ") =====");
            System.out.println("1 - Bakiye Sorgulama");
            System.out.println("2 - Para Yatırma");
            System.out.println("3 - Para Çekme");
            System.out.println("4 - Transfer");
            System.out.println("5 - Toplam Açılan Hesap Sayısı");
            System.out.println("6 - Varlıklarım / Borçlarım");
            System.out.println("7 - Son İşlemler");
            System.out.println("8 - Fatura Ödeme");
            System.out.println("9 - Kredi İşlemleri");
            System.out.println("10 - Portföy Menüsü");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");
            if (!input.hasNextInt()) {
                System.out.println("Geçersiz giriş. Lütfen sayı girin.");
                input.nextLine();
                continue;
            }
            int secim = input.nextInt();
            input.nextLine(); 

            switch (secim) {
                case 1 : aktifPortfoy.bakiyeSorgulama();

                case 2 : {
                    System.out.print("Yatırılacak miktar: ");
                    double yatir = readDoubleSafe();
                    aktifPortfoy.paraYatırma(yatir);
                }

                case 3 : {
                    System.out.print("Çekilecek miktar: ");
                    double cek = readDoubleSafe();
                    aktifPortfoy.ParaCekme(cek);
                }

                case 4 : {
                    System.out.print("Transfer miktarı: ");
                    double miktar = readDoubleSafe();
                    aktifPortfoy.transfer(hesap2, miktar);
                }

                case 5 : BankaHesabi.gosterToplamHesapSayisi();

                case 6 : aktifPortfoy.getVarliklarim().goster();

                case 7 : aktifPortfoy.sonIslemler();

                case 8 : faturaMenusu();

                case 9 : krediMenusu();

                case 10 : portfoyMenusu(); // 

                case 0 : {
                    System.out.println("Çıkış yapılıyor...");
                    devam = false;
                }

                default : System.out.println("Geçersiz seçim!");
            }
        }
    }

    private double readDoubleSafe() {
        while (!input.hasNextDouble()) {
            System.out.print("Geçersiz değer. Lütfen sayı girin: ");
            input.nextLine();
        }
        double v = input.nextDouble();
        input.nextLine();
        return v;
    }

    private void faturaMenusu() {
        System.out.print("Fatura miktarı: ");
        System.out.println("1- Elektrik\n2- Su\n3- İnternet\n4- TV");
        System.out.print("Seçiminiz: ");
        if (!input.hasNextInt()) {
            System.out.println("Geçersiz seçim!");
            input.nextLine();
            return;
        }
        int fSecim = input.nextInt();
        input.nextLine();

        switch (fSecim) {
            case 1 : 
            case 2 : 
            case 3 : 
            case 4 : 
            default : {
                System.out.println("Geçersiz seçim!");
                return;
            }
        }
    }

    private void krediMenusu() {
        if (aktifHesap instanceof Kredi_Hesaplama) {
            Kredi_Hesaplama kredi = (Kredi_Hesaplama) aktifHesap; 

            int krediSecim;
            do {
                System.out.println("\n--- KREDİ MENÜSÜ ---");
                System.out.println("1 - Kredi Çek");
                System.out.println("2 - Kredi Öde");
                System.out.println("3 - Kredi Durumu");
                System.out.println("0 - Geri Dön");
                System.out.print("Seçiminiz: ");
                while (!input.hasNextInt()) {
                    System.out.print("Lütfen bir sayı girin: ");
                    input.nextLine();
                }
                krediSecim = input.nextInt();
                input.nextLine();

                switch (krediSecim) {
                    case 1 : {
                        System.out.print("Kredi miktarı: ");
                        double miktar = readDoubleSafe();
                        System.out.print("Vade (ay): ");
                        int ay = readIntSafe();
                        kredi.krediCek(miktar, ay);
                    }
                    case 2 : {
                        System.out.print("Ödeme miktarı: ");
                        double miktar = readDoubleSafe();
                        kredi.krediOde(miktar);
                    }
                    case 3 : kredi.krediDurumu();
                    case 0 : System.out.println("Ana menüye dönülüyor...");
                    default : System.out.println("Geçersiz seçim!");
                }
            } while (krediSecim != 0);
        } else {
            System.out.println("Bu hesap kredi işlemleri için uygun değil!");
        }
    }

    private int readIntSafe() {
        while (!input.hasNextInt()) {
            System.out.print("Geçersiz değer. Lütfen tam sayı girin: ");
            input.nextLine();
        }
        int v = input.nextInt();
        input.nextLine();
        return v;
    }

    private void portfoyMenusu() {
        if (aktifHesap == null) {
            System.out.println("Henüz giriş yapılmadı!");
            return;
        }

        Portfoyum portfoy = aktifPortfoy;
        int pSecim = 0;

        do {
            System.out.println("\n--- PORTFÖY MENÜSÜ (" + portfoy.getİsim() + ") ---");
            System.out.println("1 - Nakit İşlemleri");
            System.out.println("2 - Hisse İşlemleri");
            System.out.println("3 - Fon İşlemleri");
            System.out.println("4 - Döviz / Altın İşlemleri");
            System.out.println("5 - Vadeli Mevduat İşlemleri");
            System.out.println("6 - BES İşlemleri");
            System.out.println("7 - Yatırım Ürünleri");
            System.out.println("8 - Diğer Banka Hesapları");
            System.out.println("0 - Ana Menüye Dön");
            System.out.print("Seçim: ");
            if (!input.hasNextInt()) {
                System.out.println("Geçersiz giriş!");
                input.nextLine();
                continue;
            }
            pSecim = input.nextInt();
            input.nextLine();

            switch (pSecim) {
                case 1 :
                    System.out.println("Nakit gösteriliyor...");
                    portfoy.getNakit().goster();
                
                case 2 :
                    System.out.println("Hisse gösteriliyor...");
                    portfoy.getHisse().goster();
                
                case 3 :
                    System.out.println("Fon bilgisi gösteriliyor...");
                    Portfoyum.getFon().fonBilgisiGoster();
                
                case 4 :
                    System.out.println("Döviz/Altın gösteriliyor...");
                    portfoy.getDovizAltın().bilgileriGoster();
                
                case 5 : {
                    System.out.println("Vadeli Mevduat bakiye sorgulama...");
                    portfoy.getVadeliMevduat().bakiyeSorgulama();
                }
                case 6 : {
                    System.out.println("BES bilgileri gösteriliyor...");
                    portfoy.getBes().bilgiGoster();
                }
                case 7 : {
                    System.out.println("Yatırım ürünleri işlemleri...");
                    portfoy.getYatirimUrunleri().bilgiGoster();
                }
                case 8 : {
                    System.out.println("Diğer banka hesapları gösteriliyor...");
                    portfoy.getDigerBankaHesaplari().bilgileriGoster();
                }
                case 0 : System.out.println("Ana menüye dönülüyor...");
                default : System.out.println("Geçersiz seçim!");
            }

        } while (pSecim != 0);
    }
}
