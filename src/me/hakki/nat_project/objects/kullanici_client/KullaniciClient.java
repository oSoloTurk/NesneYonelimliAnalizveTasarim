package me.hakki.nat_project.objects.kullanici_client;

import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.kullanici_client.IKullaniciClient;
import me.hakki.nat_project.api.objects.kullanici_client.IClientIslevi;
import me.hakki.nat_project.factories.ComponentFactory;
import me.hakki.nat_project.objects.Kullanici;

import java.util.Scanner;
import java.util.function.Function;

public class KullaniciClient extends Thread implements IKullaniciClient {

    protected IAgArayuzu agArayuzu;
    private Kullanici kullanici;
    private Scanner scanner;

    public KullaniciClient(){

    }

    @Override
    public void run(){
        scanner = new Scanner(System.in);
        do {
            kullanici = kullaniciDogrula();
            if(kullanici == null) {
                System.out.println("Hatali kullanici adi veya sifre girdiniz.");
            }
        }while(kullanici == null);
        System.out.println("Hosgeldiniz, " + kullanici.getKullaniciAdi());
        komutlar();
        komutCalistir();
    }

    private Kullanici kullaniciDogrula() {
        System.out.print("Kullanici adi girin: ");
        String kullaniciAdi = scanner.nextLine();
        System.out.print("Sifre girin: ");
        String sifre = scanner.nextLine();
        System.out.println("Bilgileriniz Dogrulanıyor...");
        return ComponentFactory.getInstance().getDatabaseHandler().girisYap(kullaniciAdi, sifre);
    }

    @Override
    public void baglan(IAgArayuzu agArayuzu) {
        this.agArayuzu = agArayuzu;
        Commands.setAgArayuzu(agArayuzu);
        System.out.println("Ana islem platformuna baglanildi!");
        this.start();
    }

    @Override
    public void komutCalistir() {
        int komut = 0;
        Commands islev = null;
        do {
            System.out.print("Komut numarasi: ");
            komut = scanner.nextInt();
            if(komut == -1) {
                kullanici = null;
                System.out.println("Cikis Yapiliyor...");

                run();
                break;
            }
            islev = Commands.getCommand(komut);
            if(islev == null) continue;
            islev.getIslev().calistir();
            komutlar();
        }while(true);
    }

    private void komutlar(){
        System.out.println("****************************");
        for(Commands command : Commands.values()){
            System.out.println(command.getIndex() + " - " + command.getIslev().aciklama());
        }
        System.out.println("-1 - Cikis Yap");
        System.out.println("****************************");
    }


    private enum Commands {
        SOGUTUCU_AC(1, SogutucuAcmaIslevi::new),
        SOGUTUCU_KAPAT(2, SogutucuKapatmaIslevi::new),
        SICAKLIK_GORUNTULEME(3, SicaklikGoruntulemeIslevi::new)
        ;

        private static IAgArayuzu agArayuzu;
        private IClientIslevi islev;
        private final Function<IAgArayuzu, IClientIslevi> creator;
        private final int index;

        public static void setAgArayuzu(IAgArayuzu agArayuzu) {
            Commands.agArayuzu = agArayuzu;
        }

        public static IAgArayuzu getAgArayuzu() {
            return Commands.agArayuzu;
        }

        public static Commands getCommand(final int identifier){
            for(Commands command : Commands.values()) {
                if(identifier == command.getIndex())
                    return command;
            }
            return null;
        }

        Commands(int index, Function<IAgArayuzu, IClientIslevi> creator) {
            this.creator = creator;
            this.index = index;
        }

        public IClientIslevi getIslev() {
            if(islev == null) {
                islev = creator.apply(getAgArayuzu());
            }
            return islev;
        }

        public int getIndex() {
            return index;
        }
    }

}
