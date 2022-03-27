package me.hakki.nat_project.objects.sicaklik_motoru;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SicaklikMotoruTimer extends Timer {
    private final long SCHEDULE_TIME = 1000;
    private final TimeUnit SCHEDULE_TIME_UNIT = TimeUnit.MILLISECONDS;

    public final long getPeriod(){
        return SCHEDULE_TIME_UNIT.toMillis(SCHEDULE_TIME);
    }
}
