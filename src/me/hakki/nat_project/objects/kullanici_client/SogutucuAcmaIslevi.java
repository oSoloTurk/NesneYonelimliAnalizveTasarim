package me.hakki.nat_project.objects.kullanici_client;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;

public class SogutucuAcmaIslevi extends ClientIslevi {

    public SogutucuAcmaIslevi(IAgArayuzu agArayuzu) {
        super(agArayuzu);
    }

    @Override
    public String aciklama() {
        return "Sogutucu Ac";
    }

    @Override
    protected void handle() {
        System.out.println("Sogutucu Acildi!");
        agArayuzu.sogutucuyuAc();
    }
}
