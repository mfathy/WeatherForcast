package me.mfathy.weather.forcast.data.model;

public class TemperatureEntity {

    private MaximumEntity maximum;
    private MinimumEntity minimum;

    public MaximumEntity getMaximum() {
        return maximum;
    }

    public MinimumEntity getMinimum() {
        return minimum;
    }

    public static class Builder {

        private MaximumEntity maximum;
        private MinimumEntity minimum;

        public TemperatureEntity.Builder withMaximum(MaximumEntity maximum) {
            this.maximum = maximum;
            return this;
        }

        public TemperatureEntity.Builder withMinimum(MinimumEntity minimum) {
            this.minimum = minimum;
            return this;
        }

        public TemperatureEntity build() {
            TemperatureEntity temperature = new TemperatureEntity();
            temperature.maximum = maximum;
            temperature.minimum = minimum;
            return temperature;
        }

    }

}
