package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.databases.IDatabaseHandler;
import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.factories.ComponentFactory;

public class AgArayuzu implements IAgArayuzu {
    private final IAIP aip;
    private IDatabaseHandler dbHandler;

    public AgArayuzu(IAIP aip) {
        this.aip = aip;
        dbHandler = ComponentFactory.getInstance().getDatabaseHandler();
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

    @Override
    public boolean kullaniciDogrula(String username) {
        return dbHandler.girisYap(username);
    }

    @Override
    public Kullanici kullaniciDogrula(String username, String password) {
        return dbHandler.girisYap(username, password);
    }
}
