package me.hakki.nat_project.objects.sicaklik_motoru;


import java.util.function.Consumer;

public class SogutucuKapaliIslevi  extends SogutucuIslevi implements Consumer<Float> {
    private final int ODA_SICAKLIGI = 25;

    @Override
    public void accept(Float aktifDeger) {
        float volume = getRandom().nextFloat();
        super.sonuc = (ODA_SICAKLIGI - aktifDeger) * volume;
    }

    @Override
    public void handle(float aktifDeger) {
        this.accept(aktifDeger);
    }
}