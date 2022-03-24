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
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private final IDatabaseHandler databaseHandler;
    private final ComponentFactory factory;

    public AIP(){
        factory = new ComponentFactory(this);
        agArayuzu = factory.createAgArayuzu();
        eyleyici = factory.createEyleyici();
        sicaklikAlgilayici =factory.createSicaklikAygilayici();
        databaseHandler = factory.createDatabaseHandler(DatabaseType.MONGODB);
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

    @Override
    public IDatabaseHandler getDatabaseHandler() {
        return databaseHandler;
    }
}
