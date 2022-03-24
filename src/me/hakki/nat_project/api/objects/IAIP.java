package me.hakki.nat_project.api.objects;

import me.hakki.nat_project.api.databases.IDatabaseHandler;

public interface IAIP {
    void sogutucuyuAc();
    void sogutucuyuKapat();
    float sicaklikOku();
    IDatabaseHandler getDatabaseHandler();
}
