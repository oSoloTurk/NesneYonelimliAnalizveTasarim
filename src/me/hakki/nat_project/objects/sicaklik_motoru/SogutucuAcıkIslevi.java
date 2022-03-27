package me.hakki.nat_project.objects.sicaklik_motoru;

import java.util.function.Consumer;

public class SogutucuAcıkIslevi extends SogutucuIslevi implements Consumer<Float> {
    @Override
    public void accept(Float aktifDeger) {
        float volume = getRandom().nextFloat() / ESITLENME_SURESI;
        super.sonuc += (SOGUTUCU_ALT_LIMITI - aktifDeger) * volume;
    }

    @Override
    public void handle() {
        this.accept(super.sonuc);
    }
}