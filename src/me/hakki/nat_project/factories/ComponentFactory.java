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

    private IAgArayuzu agArayuzu;
    private IEyleyici eyleyici;
    private IDatabaseHandler dbHandler;
    private ISicaklikAlgilayici sicaklikAlgilayici;

    private ComponentFactory(){ }

    public static ComponentFactory getInstance(){
        if(instance == null){
            instance = new ComponentFactory();
        }
        return instance;
    }

    @Override
    public IAgArayuzu getAgArayuzu(final IAIP aip) {
        if(this.agArayuzu == null) {
            this.agArayuzu = new AgArayuzu(aip);
        }
        return this.agArayuzu;
    }

    @Override
    public IEyleyici getEyleyici() {
        if(this.eyleyici == null) {
            this.eyleyici = new Eyleyici();
        }
        return eyleyici;
    }

    @Override
    public IDatabaseHandler getDatabaseHandler(DatabaseType databaseType) {
        if(this.dbHandler == null) {
            this.dbHandler = databaseType.getHandler();
        }
        return dbHandler;
    }

    @Override
    public IDatabaseHandler getDatabaseHandler() {
        return dbHandler;
    }

    @Override
    public ISicaklikAlgilayici getSicaklikAlgilayici() {
        if(this.sicaklikAlgilayici == null) {
            this.sicaklikAlgilayici = new SicaklikAlgilayici();
        }
        return sicaklikAlgilayici;
    }
}
