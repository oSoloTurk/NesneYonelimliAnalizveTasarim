package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IEyleyici;
import me.hakki.nat_project.objects.sicaklik_motoru.SicaklikMotoru;

public class Eyleyici implements IEyleyici {

    public Eyleyici(){
    }

    @Override
    public void sogutucuyuAc() {
        SicaklikMotoru.getInstance().sogutucuyuAc();
    }

    @Override
    public void sogutucuyuKapat() {
        SicaklikMotoru.getInstance().sogutucuyuKapat();
    }
}
