package me.mfathy.weather.forcast.data.model;

public class MaximumEntity {

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

        public MaximumEntity.Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public MaximumEntity.Builder withUnitType(Long unitType) {
            this.unitType = unitType;
            return this;
        }

        public MaximumEntity.Builder withValue(Double value) {
            this.value = value;
            return this;
        }

        public MaximumEntity build() {
            MaximumEntity maximum = new MaximumEntity();
            maximum.unit = unit;
            maximum.unitType = unitType;
            maximum.value = value;
            return maximum;
        }

    }

}
