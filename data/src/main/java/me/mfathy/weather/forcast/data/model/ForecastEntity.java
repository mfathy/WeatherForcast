package me.mfathy.weather.forcast.data.model;

import java.util.List;

public class ForecastEntity {

    private List<DailyForecastEntity> dailyForecasts;
    private String headline;

    public List<DailyForecastEntity> getDailyForecasts() {
        return dailyForecasts;
    }

    public String getHeadline() {
        return headline;
    }

    public static class Builder {

        private List<DailyForecastEntity> dailyForecasts;
        private String headline;

        public ForecastEntity.Builder withDailyForecasts(List<DailyForecastEntity> dailyForecasts) {
            this.dailyForecasts = dailyForecasts;
            return this;
        }

        public ForecastEntity.Builder withHeadline(String headline) {
            this.headline = headline;
            return this;
        }

        public ForecastEntity build() {
            ForecastEntity forecast = new ForecastEntity();
            forecast.dailyForecasts = dailyForecasts;
            forecast.headline = headline;
            return forecast;
        }

    }

}
