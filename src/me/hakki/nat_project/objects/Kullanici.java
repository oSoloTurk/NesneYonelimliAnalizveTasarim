package me.hakki.nat_project.objects;

public class Kullanici {
    private final String kullaniciAdi;
    private final String sifreHashi;

    public Kullanici(String kullaniciAdi, String sifreHashi) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifreHashi = sifreHashi;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
}
