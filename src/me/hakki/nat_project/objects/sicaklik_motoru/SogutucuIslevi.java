package me.hakki.nat_project.objects.sicaklik_motoru;

import me.hakki.nat_project.api.objects.sicaklik_motoru.ISogutucuIslevi;

import java.security.SecureRandom;

public abstract class SogutucuIslevi implements ISogutucuIslevi {
    private SecureRandom random;
    protected Float sonuc;

    public SogutucuIslevi(){
        this.random = new SecureRandom();
    }

    protected SecureRandom getRandom(){
        return random;
    }

    public float calistir(float aktifDeger) {
        this.handle(aktifDeger);
        return sonuc;
    }

    protected abstract void handle(float aktifDeger);
}