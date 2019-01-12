package me.mfathy.weather.forcast.domain.model;

public class Minimum {

    private String unit;
    private Long unitType;
    private Double value;

    public String getUnit() {
        return unit;
    }

    public Long getUnitType() {
        return unitType;
    }

    public Double getValue() {
        return value;
    }

    public static class Builder {

        private String unit;
        private Long unitType;
        private Double value;

        public Minimum.Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public Minimum.Builder withUnitType(Long unitType) {
            this.unitType = unitType;
            return this;
        }

        public Minimum.Builder withValue(Double value) {
            this.value = value;
            return this;
        }

        public Minimum build() {
            Minimum minimum = new Minimum();
            minimum.unit = unit;
            minimum.unitType = unitType;
            minimum.value = value;
            return minimum;
        }

    }

}
