package me.hakki.nat_project.objects.kullanici_client;

import me.hakki.nat_project.api.objects.IAgArayuzu;

public class SicaklikGoruntulemeIslevi extends ClientIslevi{

    public SicaklikGoruntulemeIslevi(IAgArayuzu agArayuzu) {
        super(agArayuzu);
    }

    @Override
    public String aciklama() {
        return "Sicaklik Goruntuleme";
    }

    @Override
    protected void handle() {
        System.out.println("Sicaklik Degeri" + agArayuzu.sicaklikGonder());
    }
}
