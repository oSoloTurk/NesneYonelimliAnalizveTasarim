package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;

public class AgArayuzu implements IAgArayuzu {
    private final IAIP aip;

    public AgArayuzu(IAIP aip) {
        this.aip = aip;
    }

    @Override
    public void sogutucuyuAc() {
        aip.sogutucuyuAc();
    }

    @Override
    public void sogutucuyuKapat() {
        aip.sogutucuyuKapat();
    }

    @Override
    public float sicaklikGonder() {
        return aip.sicaklikOku();
    }

    @Override
    public String getCihazDurumu() {
        return aip.getDurumMesaji();
    }
}
