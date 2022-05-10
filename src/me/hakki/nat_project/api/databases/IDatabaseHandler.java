package me.hakki.nat_project.api.databases;

import me.hakki.nat_project.objects.Kullanici;

public interface IDatabaseHandler {

    Kullanici girisYap(final String kullaniciAdi, final String sifre);
    boolean girisYap(String kullaniciAdi);
    float sicaklikOku();
    void sicaklikYaz(final float yeniDeger);
    boolean migration();
}
