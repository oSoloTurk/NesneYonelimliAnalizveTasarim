package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.databases.IDatabaseHandler;
import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.IEyleyici;
import me.hakki.nat_project.api.objects.ISicaklikAlgilayici;
import me.hakki.nat_project.factories.ComponentFactory;

public class AIP implements IAIP {
    private final IAgArayuzu agArayuzu;
    private final IEyleyici eyleyici;
    private final IDatabaseHandler databaseHandler;
    private final ISicaklikAlgilayici sicaklikAlgilayici;

    public AIP(){
        agArayuzu = ComponentFactory.getInstance().getAgArayuzu(this);
        eyleyici = ComponentFactory.getInstance().getEyleyici();
        databaseHandler = ComponentFactory.getInstance().getDatabaseHandler(DatabaseType.MONGODB);
        sicaklikAlgilayici = ComponentFactory.getInstance().getSicaklikAlgilayici();
    }

    @Override
    public void sogutucuyuAc() {
        eyleyici.sogutucuyuAc();
    }

    @Override
    public void sogutucuyuKapat() {
        eyleyici.sogutucuyuKapat();
    }

    @Override
    public float sicaklikOku() {
        return sicaklikAlgilayici.sicaklikOku();
    }

    public IAgArayuzu getAgArayuzu() {
        return agArayuzu;
    }
}
