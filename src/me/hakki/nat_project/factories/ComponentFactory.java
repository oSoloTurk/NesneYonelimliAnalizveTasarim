package me.hakki.nat_project.factories;

import me.hakki.nat_project.api.databases.IDatabaseHandler;
import me.hakki.nat_project.api.factories.IComponentFactory;
import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.IEyleyici;
import me.hakki.nat_project.api.objects.ISicaklikAlgilayici;
import me.hakki.nat_project.objects.AgArayuzu;
import me.hakki.nat_project.objects.DatabaseType;
import me.hakki.nat_project.objects.Eyleyici;
import me.hakki.nat_project.objects.SicaklikAlgilayici;

public class ComponentFactory implements IComponentFactory {
    private static ComponentFactory instance;
    private ComponentFactory(){ }

    public static ComponentFactory getInstance(){
        return instance;
    }

    @Override
    public IAgArayuzu createAgArayuzu() {
        return new AgArayuzu();
    }

    @Override
    public IEyleyici createEyleyici() {
        return new Eyleyici();
    }

    @Override
    public ISicaklikAlgilayici createSicaklikAygilayici() {
        return new SicaklikAlgilayici();
    }

    @Override
    public IDatabaseHandler createDatabaseHandler(DatabaseType databaseType) {
        return databaseType.getHandler();
    }
}
