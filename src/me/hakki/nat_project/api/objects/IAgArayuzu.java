package me.hakki.nat_project.api.objects;

import me.hakki.nat_project.objects.Kullanici;

public interface IAgArayuzu {
    void sogutucuyuAc();
    void sogutucuyuKapat();
    float sicaklikGonder();
    String getCihazDurumu();
    boolean kullaniciDogrula(String username);
    Kullanici kullaniciDogrula(String username, String password);
}
