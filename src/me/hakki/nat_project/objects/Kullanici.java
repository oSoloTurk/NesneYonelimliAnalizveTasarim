package me.hakki.nat_project.objects;

public class Kullanici {
    private final String kullaniciAdi;
    private final int yetkiSeviyesi;

    public Kullanici(String kullaniciAdi, int yetkiSeviyesi) {
        this.kullaniciAdi = kullaniciAdi;
        this.yetkiSeviyesi = yetkiSeviyesi;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public int getYetkiSeviyesi() {
        return yetkiSeviyesi;
    }
}
