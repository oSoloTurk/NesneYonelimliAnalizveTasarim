package me.hakki.nat_project.objects.sicaklik_motoru;

import me.hakki.nat_project.api.objects.sicaklik_motoru.ISicaklikMotoru;
import me.hakki.nat_project.factories.ComponentFactory;
import me.hakki.nat_project.objects.SicaklikAlgilayici;

import java.util.TimerTask;

public class SicaklikMotoru extends TimerTask implements ISicaklikMotoru {

    private static SicaklikMotoru instance;

    private SogutucuModu aktifMod = SogutucuModu.KAPALI;
    private SicaklikMotoruTimer timer;

    private SicaklikMotoru() {}


    public static SicaklikMotoru getInstance() {
        if(instance == null) {
            instance = new SicaklikMotoru();
            instance.timer = new SicaklikMotoruTimer();
            instance.timer.schedule(instance, 0, instance.timer.getPeriod());
        }
        return instance;
    }
    public SogutucuModu getAktifMod() {
        return aktifMod;
    }

    public void setAktifMod(SogutucuModu aktifMod) {
        this.aktifMod = aktifMod;
    }

    public void sogutucuyuAc() {
        setAktifMod(SogutucuModu.ACIK);
    }

    public void sogutucuyuKapat() {
        setAktifMod(SogutucuModu.KAPALI);
    }

    @Override
    public void run() {
       ComponentFactory.getInstance().getSicaklikAlgilayici().sicaklikYaz(
                getAktifMod().getIslev().calistir(
                        ComponentFactory.getInstance().getSicaklikAlgilayici().sicaklikOku()
                )
        );
    }

}