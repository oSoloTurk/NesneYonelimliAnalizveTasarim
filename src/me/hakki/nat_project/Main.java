package me.hakki.nat_project;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.kullanici_client.IKullaniciClient;
import me.hakki.nat_project.api.objects.sicaklik_motoru.ISicaklikMotoru;
import me.hakki.nat_project.factories.ComponentFactory;
import me.hakki.nat_project.objects.AIP;
import me.hakki.nat_project.objects.kullanici_client.KullaniciClient;
import me.hakki.nat_project.objects.sicaklik_motoru.SicaklikMotoru;
import me.hakki.nat_project.utils.DotEnv;

public class Main {

    public static void main(String[] args) {
        if (!DotEnv.load()) {
            System.out.println("Environment degerleri mevcut degil veya hatali!");
            return;
        }

        if(args.length > 0 && args[0].equalsIgnoreCase("--migration")){
            boolean response = ComponentFactory
                    .getInstance()
                    .getDatabaseHandler(ComponentFactory.ACTIVE_DATABASE_HANDLER)
                    .migration();
            System.out.println("Migration Response: " + response);
        }

        IAIP aip = new AIP();

        ISicaklikMotoru sicaklikMotoru = SicaklikMotoru.getInstance(); //create a instance of universal sicaklikMotoru


        IKullaniciClient client = new KullaniciClient();
        client.baglan(aip.getAgArayuzu());
    }
}
