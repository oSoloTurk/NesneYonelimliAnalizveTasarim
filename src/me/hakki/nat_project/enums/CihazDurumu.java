package me.hakki.nat_project.enums;

public enum CihazDurumu {
    KAPALI("Cihaz Kapalı."),
    ACILIS_TESTI("Acilis Testi Yapiliyor..."),
    BEKLEME("Kullanici Bekleniyor..."),
    ALGILAMA(""),
    SERVIS_DISI("Cihaz Servis Disi!"),
    ISLEM_YAPIYOR("Bir Kullanici Islem Yapiyor.");

    private String mesaj;

    CihazDurumu(String durumMesaji) {
        this.mesaj = durumMesaji;
    }

    public final String getMesaj(){
        return mesaj;
    }
}
