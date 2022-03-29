package me.hakki.nat_project.objects.sicaklik_motoru;

import me.hakki.nat_project.api.objects.IObservable;
import me.hakki.nat_project.api.objects.IObserver;
import me.hakki.nat_project.api.objects.sicaklik_motoru.ISicaklikMotoru;
import me.hakki.nat_project.factories.ComponentFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class SicaklikMotoru extends TimerTask implements ISicaklikMotoru {

    private static SicaklikMotoru instance;

    private List<IObserver> observerList;
    private SogutucuModu aktifMod = SogutucuModu.KAPALI;
    private SicaklikMotoruTimer timer;

    private SicaklikMotoru() {
        observerList = new ArrayList();
    }

    public static SicaklikMotoru getInstance() {
        if(instance == null) {
            instance = new SicaklikMotoru();
            instance.timer = new SicaklikMotoruTimer();
            instance.observe(ComponentFactory.getInstance().getSicaklikAlgilayici());
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
        notifyObservers(
                getAktifMod().getIslev().calistir(
                        ComponentFactory.getInstance().getSicaklikAlgilayici().sicaklikOku()
                )
        );
    }

    @Override
    public void observe(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObservers(Float value) {
        observerList.forEach(observer -> observer.notifyObserver(value));
    }

}