package me.hakki.nat_project.objects.sicaklik_motoru;

import java.util.function.Consumer;

public class SogutucuAcıkIslevi extends SogutucuIslevi implements Consumer<Float> {
    @Override
    public void accept(Float aktifDeger) {
        float volume = getRandom().nextFloat();
        super.sonuc = aktifDeger - volume;
    }

    @Override
    public void handle(float aktifDeger) {
        this.accept(aktifDeger);
    }
}