package me.mfathy.weather.forcast.domain.model;

public class DailyForecast {

    private String dayText;
    private String nightText;
    private Temperature temperature;

    public String getDayText() {
        return dayText;
    }

    public String getNightText() {
        return nightText;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public static class Builder {

        private String day;
        private String night;
        private Temperature temperature;

        public DailyForecast.Builder withDay(String day) {
            this.day = day;
            return this;
        }

        public DailyForecast.Builder withNight(String night) {
            this.night = night;
            return this;
        }

        public DailyForecast.Builder withTemperature(Temperature temperature) {
            this.temperature = temperature;
            return this;
        }

        public DailyForecast build() {
            DailyForecast dailyForecast = new DailyForecast();
            dailyForecast.dayText= day;
            dailyForecast.nightText = night;
            dailyForecast.temperature = temperature;
            return dailyForecast;
        }

    }

}
