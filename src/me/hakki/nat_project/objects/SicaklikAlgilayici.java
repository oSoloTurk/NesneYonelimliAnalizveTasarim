package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.objects.ISicaklikAlgilayici;
import me.hakki.nat_project.api.objects.IObserver;
import me.hakki.nat_project.utils.Generator;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private float sicaklikDegeri;

    public SicaklikAlgilayici(){
        sicaklikDegeri = Generator.getRandomFloat(10f, 50f);
    }

    @Override
    public float sicaklikOku() {
        return sicaklikDegeri;
    }

    @Override
    public void notifyObserver(float value) {
        sicaklikDegeri = value;
    }
}
