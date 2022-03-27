package me.hakki.nat_project;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.kullanici_client.IKullaniciClient;
import me.hakki.nat_project.api.objects.sicaklik_motoru.ISicaklikMotoru;
import me.hakki.nat_project.objects.AIP;
import me.hakki.nat_project.objects.kullanici_client.KullaniciClient;
import me.hakki.nat_project.objects.sicaklik_motoru.SicaklikMotoru;
import me.hakki.nat_project.utils.DotEnv;

public class Main {

    public static void main(String[] args) {
        DotEnv.load();
        IAIP aip = new AIP();

        ISicaklikMotoru sicaklikMotoru = SicaklikMotoru.getInstance(); //create a instance of universal sicaklikMotoru

        IKullaniciClient client = new KullaniciClient();
        client.baglan(aip.getAgArayuzu());
    }
}
