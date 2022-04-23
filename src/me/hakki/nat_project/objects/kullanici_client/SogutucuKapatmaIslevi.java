package me.hakki.nat_project.objects.kullanici_client;

import me.hakki.nat_project.api.objects.IAgArayuzu;

public class SogutucuKapatmaIslevi extends ClientIslevi {

    public SogutucuKapatmaIslevi(IAgArayuzu agArayuzu) {
        super(agArayuzu);
    }

    @Override
    public String aciklama() {
        return "Sogutucu Kapat";
    }

    @Override
    protected void handle() {
        System.out.println("Sogutucu Kapatildi!");
        agArayuzu.sogutucuyuKapat();
    }
}
