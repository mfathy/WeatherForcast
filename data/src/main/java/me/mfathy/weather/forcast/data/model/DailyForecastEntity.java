package me.mfathy.weather.forcast.data.model;


public class DailyForecastEntity {

    private String dayText;
    private String nightText;
    private TemperatureEntity temperature;

    public String getDayText() {
        return dayText;
    }

    public String getNightText() {
        return nightText;
    }

    public TemperatureEntity getTemperature() {
        return temperature;
    }

    public static class Builder {

        private String day;
        private String night;
        private TemperatureEntity temperature;

        public DailyForecastEntity.Builder withDay(String day) {
            this.day = day;
            return this;
        }

        public DailyForecastEntity.Builder withNight(String night) {
            this.night = night;
            return this;
        }

        public DailyForecastEntity.Builder withTemperature(TemperatureEntity temperature) {
            this.temperature = temperature;
            return this;
        }

        public DailyForecastEntity build() {
            DailyForecastEntity dailyForecast = new DailyForecastEntity();
            dailyForecast.dayText = day;
            dailyForecast.nightText = night;
            dailyForecast.temperature = temperature;
            return dailyForecast;
        }

    }

}
