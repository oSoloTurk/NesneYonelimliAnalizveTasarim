package me.hakki.nat_project.objects.kullanici_client;

import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.kullanici_client.IKullaniciClient;
import me.hakki.nat_project.api.objects.kullanici_client.IClientIslevi;

import java.util.Scanner;
import java.util.function.Function;

public class KullaniciClient extends Thread implements IKullaniciClient {

    protected IAgArayuzu agArayuzu;
    private Scanner scanner;

    public KullaniciClient(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(){
        komutlar();
        komutCalistir();
    }

    @Override
    public void baglan(IAgArayuzu agArayuzu) {
        this.agArayuzu = agArayuzu;
        Commands.setAgArayuzu(agArayuzu);
        System.out.println("Ana islem platformuna baglanildi!");
        this.run();
    }

    @Override
    public void komutCalistir() {
        int komut = 0;
        Commands islev = null;
        do {
            System.out.println("Komut numarasi: ");
            komut = scanner.nextInt();
            if(komut == -1) break;
            islev = Commands.getCommand(komut);
            if(islev == null) continue;
            islev.getIslev().calistir();
        }while(true);
    }

    private void komutlar(){
        System.out.println("****************************");
        for(Commands command : Commands.values()){
            System.out.println(command.getIndex() + " - " + command.getIslev().aciklama());
        }
        System.out.println("****************************");
    }


    private enum Commands {
        SOGUTUCU_AC(1, SogutucuAcmaIslevi::new),
        SOGUTUCU_KAPAT(2, SogutucuKapatmaIslevi::new),
        SICAKLIK_GORUNTULEME(3, SicaklikGoruntulemeIslevi::new)
        ;

        private static IAgArayuzu agArayuzu;
        private IClientIslevi islev;
        private int index;

        public static void setAgArayuzu(IAgArayuzu agArayuzu) {
            Commands.agArayuzu = agArayuzu;
        }

        public static IAgArayuzu getAgArayuzu() {
            return agArayuzu;
        }

        public static Commands getCommand(final int identifier){
            for(Commands command : Commands.values()) {
                if(identifier == command.getIndex())
                    return command;
            }
            return null;
        }

        Commands(int index, Function<IAgArayuzu, IClientIslevi> creator) {
            islev = creator.apply(getAgArayuzu());
            this.index = index;
        }

        public IClientIslevi getIslev() {
            return islev;
        }

        public int getIndex() {
            return index;
        }
    }

}
