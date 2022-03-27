package me.hakki.nat_project.api.objects.kullanici_client;

import me.hakki.nat_project.api.objects.IAgArayuzu;

public interface IKullaniciClient {
    void baglan(IAgArayuzu agArayuzu);

    void komutCalistir();
}
