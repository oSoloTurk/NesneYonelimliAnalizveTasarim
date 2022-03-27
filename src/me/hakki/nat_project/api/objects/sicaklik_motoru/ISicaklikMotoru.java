package me.hakki.nat_project.api.objects.sicaklik_motoru;

import me.hakki.nat_project.api.objects.ISicaklikAlgilayici;
import me.hakki.nat_project.objects.sicaklik_motoru.SogutucuModu;

public interface ISicaklikMotoru {
    SogutucuModu getAktifMod();
    void setAktifMod(SogutucuModu aktifMod);
    void sogutucuyuAc();
    void sogutucuyuKapat();
}
