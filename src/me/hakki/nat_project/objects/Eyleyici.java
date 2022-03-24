package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.databases.IDatabaseHandler;
import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IEyleyici;

import java.security.SecureRandom;

public class Eyleyici implements IEyleyici {

    protected IAIP aip;
    protected SecureRandom random;
    private SogutucuAcma sogutucuAcma;
    private SogutucuKapatma sogutucuKapatma;

    public Eyleyici(IAIP aip){
        this.aip = aip;
        this.random = new SecureRandom();
        this.sogutucuAcma = new SogutucuAcma();
        this.sogutucuKapatma = new SogutucuKapatma();
        //TODO: kapatma active
    }

    @Override
    public void sogutucuyuAc() {
        //TODO: acma active kapatma close
    }

    @Override
    public void sogutucuyuKapat() {
        //TODO: acma close kapatma active
    }

    public class SogutucuAcma extends Thread {
        @Override
        public void run(){
            float volume = random.nextFloat();
            aip.getDatabaseHandler().sicaklikYaz(aip.sicaklikOku() - volume);
        }
    }

    public class SogutucuKapatma extends Thread {
        private final int ODA_SICAKLIGI = 25;
        @Override
        public void run(){
            float volume = random.nextFloat();
            aip.getDatabaseHandler().sicaklikYaz((ODA_SICAKLIGI - aip.sicaklikOku()) * volume);
        }
    }
}
