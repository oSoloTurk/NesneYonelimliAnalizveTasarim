package me.hakki.nat_project.api.objects.sicaklik_motoru;

import me.hakki.nat_project.api.objects.IObservable;
import me.hakki.nat_project.objects.sicaklik_motoru.SogutucuModu;

public interface ISicaklikMotoru extends IObservable<Float> {
    SogutucuModu getAktifMod();
    void setAktifMod(SogutucuModu aktifMod);
    void sogutucuyuAc();
    void sogutucuyuKapat();
}
