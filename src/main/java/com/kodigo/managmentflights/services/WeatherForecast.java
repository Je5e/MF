package com.kodigo.managmentflights.services;

import java.util.Date;

public class WeatherForecast {
    Date date;
    int TempetureC;
    int TempetureF;
    String Summary;

    public int getTempetureF(){
        TempetureF= (int) ((32+TempetureC)/0.56);
        return TempetureF;
    }
}
