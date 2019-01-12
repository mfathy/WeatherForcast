
package me.mfathy.weather.forcast.data.store.remote.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class NetworkMaximum {

    @SerializedName("Unit")
    private String unit;
    @SerializedName("UnitType")
    private Long unitType;
    @SerializedName("Value")
    private Long value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getUnitType() {
        return unitType;
    }

    public void setUnitType(Long unitType) {
        this.unitType = unitType;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

}
