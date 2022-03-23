package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.objects.IAIP;
import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.IEyleyici;
import me.hakki.nat_project.api.objects.ISicaklikAlgilayici;
import me.hakki.nat_project.factories.ComponentFactory;

public class AIP implements IAIP {
    private final IAgArayuzu agArayuzu;
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;

    public AIP(){
        agArayuzu = ComponentFactory.getFactory().createAgArayuzu();
        eyleyici = ComponentFactory.getFactory().createEyleyici();
        sicaklikAlgilayici = ComponentFactory.getFactory().createSicaklikAygilayici();
    }

    @Override
    public void start() {

    }
}
