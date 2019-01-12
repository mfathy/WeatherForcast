package me.mfathy.weather.forcast.domain.model;

public class Temperature {

    private Maximum maximum;
    private Minimum minimum;

    public Maximum getMaximum() {
        return maximum;
    }

    public Minimum getMinimum() {
        return minimum;
    }

    public static class Builder {

        private Maximum maximum;
        private Minimum minimum;

        public Temperature.Builder withMaximum(Maximum maximum) {
            this.maximum = maximum;
            return this;
        }

        public Temperature.Builder withMinimum(Minimum minimum) {
            this.minimum = minimum;
            return this;
        }

        public Temperature build() {
            Temperature temperature = new Temperature();
            temperature.maximum = maximum;
            temperature.minimum = minimum;
            return temperature;
        }

    }

}
