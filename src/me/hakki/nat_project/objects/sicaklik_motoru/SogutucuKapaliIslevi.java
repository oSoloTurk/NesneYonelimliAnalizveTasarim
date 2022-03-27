package me.hakki.nat_project.objects.sicaklik_motoru;

import java.util.function.Consumer;

public class SogutucuKapaliIslevi  extends SogutucuIslevi implements Consumer<Float> {
    private final int ODA_SICAKLIGI;

    public SogutucuKapaliIslevi(){
        ODA_SICAKLIGI = getRandom().nextInt(25) + 15;
        System.out.println("Simule Edilen Ortama Dair Bilgiler:\n" +
                "\tOda Sicakligi: " + ODA_SICAKLIGI + "\n" +
                "\tSogutucu Sogutma Limiti: " + SOGUTUCU_ALT_LIMITI + "\n" +
                "\tOrtam isininin esitlenme suresi: " + ESITLENME_SURESI / 1000 + "(saniye)");
    }
    @Override
    public void accept(Float aktifDeger) {
        float volume = getRandom().nextFloat() / ESITLENME_SURESI;
        super.sonuc += (ODA_SICAKLIGI - aktifDeger) * volume;
    }

    @Override
    public void handle() {
        this.accept(super.sonuc);
    }
}