package me.mfathy.weather.forcast.domain.test;

import me.mfathy.weather.forcast.domain.model.DailyForecast;
import me.mfathy.weather.forcast.domain.model.Forecast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class ForecastFactory {

    public static Forecast makeForecast() {
        List<DailyForecast> dailyForecasts = new ArrayList<>();
        DailyForecast dailyForecast = new DailyForecast.Builder()
                .withDay(DataFactory.randomString())
                .withNight(DataFactory.randomString())
                .build();
        dailyForecasts.add(dailyForecast);
        return new Forecast.Builder()
                .withHeadline(DataFactory.randomString())
                .withDailyForecasts(dailyForecasts)
                .build();
    }
}
