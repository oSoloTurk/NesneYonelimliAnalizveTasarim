package me.hakki.nat_project.objects.sicaklik_motoru;

import me.hakki.nat_project.api.objects.sicaklik_motoru.ISogutucuIslevi;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public abstract class SogutucuIslevi implements ISogutucuIslevi {

    protected final float SOGUTUCU_ALT_LIMITI = -10;
    protected final long ESITLENME_SURESI = TimeUnit.MINUTES.toSeconds(1);

    private SecureRandom random;
    protected float sonuc;

    public SogutucuIslevi(){
        this.random = new SecureRandom();
    }

    protected SecureRandom getRandom(){
        return random;
    }

    public float calistir(float aktifDeger) {
        this.sonuc = aktifDeger;
        this.handle();
        return sonuc;
    }

    protected abstract void handle();
}