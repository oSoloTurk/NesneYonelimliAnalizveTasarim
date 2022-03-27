package me.hakki.nat_project.api.factories;

import me.hakki.nat_project.api.databases.IDatabaseHandler;
import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.IEyleyici;
import me.hakki.nat_project.api.objects.ISicaklikAlgilayici;
import me.hakki.nat_project.objects.DatabaseType;

public interface IComponentFactory {
    IAgArayuzu getAgArayuzu(final IAIP aip);
    IEyleyici getEyleyici();
    IDatabaseHandler getDatabaseHandler(DatabaseType db);

    IDatabaseHandler getDatabaseHandler();

    ISicaklikAlgilayici getSicaklikAlgilayici();
}
