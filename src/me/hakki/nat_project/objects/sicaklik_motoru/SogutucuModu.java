package me.hakki.nat_project.objects.sicaklik_motoru;

import me.hakki.nat_project.api.objects.sicaklik_motoru.ISogutucuIslevi;

public enum SogutucuModu {
    ACIK(new SogutucuAcıkIslevi()), KAPALI(new SogutucuKapaliIslevi());

    private ISogutucuIslevi islev;

    SogutucuModu(ISogutucuIslevi sogutucuIslevi) {
        this.islev = sogutucuIslevi;
    }

    public ISogutucuIslevi getIslev(){
        return islev;
    }
}