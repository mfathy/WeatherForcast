package me.mfathy.weather.forcast.data.model;

public class MinimumEntity {

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

        public MinimumEntity.Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public MinimumEntity.Builder withUnitType(Long unitType) {
            this.unitType = unitType;
            return this;
        }

        public MinimumEntity.Builder withValue(Double value) {
            this.value = value;
            return this;
        }

        public MinimumEntity build() {
            MinimumEntity minimum = new MinimumEntity();
            minimum.unit = unit;
            minimum.unitType = unitType;
            minimum.value = value;
            return minimum;
        }

    }

}
