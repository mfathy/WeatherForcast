package me.mfathy.weather.forcast.domain.model;

public class Maximum {

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

        public Maximum.Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public Maximum.Builder withUnitType(Long unitType) {
            this.unitType = unitType;
            return this;
        }

        public Maximum.Builder withValue(Double value) {
            this.value = value;
            return this;
        }

        public Maximum build() {
            Maximum maximum = new Maximum();
            maximum.unit = unit;
            maximum.unitType = unitType;
            maximum.value = value;
            return maximum;
        }

    }

}
