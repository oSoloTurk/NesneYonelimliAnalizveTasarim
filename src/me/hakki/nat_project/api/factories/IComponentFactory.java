package me.hakki.nat_project.api.factories;

import me.hakki.nat_project.api.objects.IAgArayuzu;
import me.hakki.nat_project.api.objects.IEyleyici;
import me.hakki.nat_project.api.objects.ISicaklikAlgilayici;

public interface IComponentFactory {
    IAgArayuzu createAgArayuzu();
    IEyleyici createEyleyici();
    ISicaklikAlgilayici createSicaklikAygilayici();
}
