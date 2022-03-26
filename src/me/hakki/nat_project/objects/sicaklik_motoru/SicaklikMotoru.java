package me.hakki.nat_project.objects.sicaklik_motoru;

import me.hakki.nat_project.api.objects.ISicaklikAlgilayici;
import me.hakki.nat_project.api.objects.sicaklik_motoru.ISicaklikMotoru;
import me.hakki.nat_project.objects.SicaklikAlgilayici;

public class SicaklikMotoru implements Runnable, ISicaklikMotoru {

    private static SicaklikMotoru instance;

    private SogutucuModu aktifMod = SogutucuModu.KAPALI;
    private ISicaklikAlgilayici sicaklikAlgilayici;

    private SicaklikMotoru() {}


    public static SicaklikMotoru getInstance() {
        if(instance == null) {
            instance = new SicaklikMotoru();
            instance.setSicaklikAlgilayici(new SicaklikAlgilayici());
        }
        return instance;
    }

    private void setSicaklikAlgilayici(ISicaklikAlgilayici sicaklikAlgilayici) {
        this.sicaklikAlgilayici = sicaklikAlgilayici;
    }

    public SogutucuModu getAktifMod() {
        return aktifMod;
    }

    public ISicaklikAlgilayici getSicaklikAlgilayici() {
        return sicaklikAlgilayici;
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
        getAktifMod().getIslev().calistir(getSicaklikAlgilayici().sicaklikOku());
    }

}