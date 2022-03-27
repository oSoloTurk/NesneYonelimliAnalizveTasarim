package me.hakki.nat_project.objects.kullanici_client;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.kullanici_client.IClientIslevi;
import me.hakki.nat_project.api.objects.sicaklik_motoru.ISogutucuIslevi;
import me.hakki.nat_project.objects.AgArayuzu;

import java.security.SecureRandom;

public abstract class ClientIslevi implements IClientIslevi {

    protected final IAgArayuzu agArayuzu;

    public ClientIslevi(IAgArayuzu agArayuzu){
        this.agArayuzu = agArayuzu;
    }

    public void calistir() {
        this.handle();
    }

    public abstract String aciklama();

    protected abstract void handle();
}