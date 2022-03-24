package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.IKullaniciClient;

public class KullaniciClient implements IKullaniciClient {

    private IAgArayuzu agArayuzu;

    @Override
    public void baglan(IAgArayuzu aip) {
        this.agArayuzu = aip;
        System.out.println("Ana islem platformuna baglanildi!");
    }

    @Override
    public void komutCalistir() {

    }

    private void komutlar(){
        System.out.println("****************************");
        System.out.println("1- Sogutucuyu Ac");
        System.out.println("2- Sogutucuyu Kapat");
        System.out.println("Sicaklik Degeri" + agArayuzu.sicaklikGonder());
        System.out.println("****************************");

        int komut = 0;
        do {

        }while(komut != -1);
    }
}
