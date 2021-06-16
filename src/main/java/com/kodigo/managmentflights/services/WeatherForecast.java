package com.kodigo.managmentflights.services;

import java.util.Date;

public class WeatherForecast {
    APIWeather apiWeather;
  public WeatherForecast(APIWeather apiWeather){
      this.apiWeather =apiWeather;
  }
    public String getTempetureF(){
        return apiWeather.getWeather();
    }
}
