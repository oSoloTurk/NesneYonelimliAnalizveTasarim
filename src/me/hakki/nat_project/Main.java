package me.hakki.nat_project;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.kullanici_client.IKullaniciClient;
import me.hakki.nat_project.objects.AIP;
import me.hakki.nat_project.objects.kullanici_client.KullaniciClient;
import me.hakki.nat_project.objects.sicaklik_motoru.SicaklikMotoru;

public class Main {

    public static void main(String[] args) {
        //TODO: load environments in here
        IAIP aip = new AIP();

        SicaklikMotoru sicaklikMotoru = SicaklikMotoru.getInstance(); //create a instance of universal sicaklikMotoru

        IKullaniciClient client = new KullaniciClient();
        client.baglan(aip.getAgArayuzu());
    }
}
