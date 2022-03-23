package me.hakki.nat_project.utils;

import java.security.SecureRandom;

public class Generator {
    private static final SecureRandom random;

    static {
        random = new SecureRandom();
    }

    public static float getRandomFloat(final float fromInclude,final  float toExclude) {
        return (1 + random.nextFloat()) * fromInclude;
    }
}
