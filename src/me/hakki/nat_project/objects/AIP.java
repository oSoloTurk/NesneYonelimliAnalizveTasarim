package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.databases.IDatabaseHandler;
import me.hakki.nat_project.api.objects.*;
import me.hakki.nat_project.enums.CihazDurumu;
import me.hakki.nat_project.factories.ComponentFactory;

public class AIP implements IAIP {
    private final IAgArayuzu agArayuzu;
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private CihazDurumu durum = CihazDurumu.KAPALI;

    public AIP(){
        agArayuzu = ComponentFactory.getInstance().getAgArayuzu(this);
        eyleyici = ComponentFactory.getInstance().getEyleyici();
        sicaklikAlgilayici = ComponentFactory.getInstance().getSicaklikAlgilayici();
        setDurum(CihazDurumu.BEKLEME);
    }

    @Override
    public void sogutucuyuAc() {
        setDurum(CihazDurumu.ISLEM_YAPIYOR);
        eyleyici.sogutucuyuAc();
        setDurum(CihazDurumu.BEKLEME);
    }

    @Override
    public void sogutucuyuKapat() {
        setDurum(CihazDurumu.ISLEM_YAPIYOR);
        eyleyici.sogutucuyuKapat();
        setDurum(CihazDurumu.BEKLEME);
    }

    @Override
    public float sicaklikOku() {
        return sicaklikAlgilayici.sicaklikOku();
    }

    @Override
    public IAgArayuzu getAgArayuzu() {
        return agArayuzu;
    }

    @Override
    public String getDurumMesaji(){
        return durum.getMesaj();
    }

    private void setDurum(CihazDurumu yeniDurum) {
        this.durum = yeniDurum;
    }
}
