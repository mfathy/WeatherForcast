package me.mfathy.weather.forcast.domain.model;

import javax.inject.Inject;
import java.util.List;

public class Forecast {

    private List<DailyForecast> dailyForecasts;
    private String headline;

    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public String getHeadline() {
        return headline;
    }

    public static class Builder {

        private List<DailyForecast> dailyForecasts;
        private String headline;

        public Forecast.Builder withDailyForecasts(List<DailyForecast> dailyForecasts) {
            this.dailyForecasts = dailyForecasts;
            return this;
        }

        public Forecast.Builder withHeadline(String headline) {
            this.headline = headline;
            return this;
        }

        public Forecast build() {
            Forecast forecast = new Forecast();
            forecast.dailyForecasts = dailyForecasts;
            forecast.headline = headline;
            return forecast;
        }

    }

}
