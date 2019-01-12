
package me.mfathy.weather.forcast.data.store.remote.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class NetworkDailyForecast {

    @SerializedName("Day")
    private NetworkDay networkDay;
    @SerializedName("Night")
    private NetworkNight networkNight;
    @SerializedName("Temperature")
    private NetworkTemperature networkTemperature;

    public NetworkDay getNetworkDay() {
        return networkDay;
    }

    public void setNetworkDay(NetworkDay networkDay) {
        this.networkDay = networkDay;
    }

    public NetworkNight getNetworkNight() {
        return networkNight;
    }

    public void setNetworkNight(NetworkNight networkNight) {
        this.networkNight = networkNight;
    }

    public NetworkTemperature getNetworkTemperature() {
        return networkTemperature;
    }

    public void setNetworkTemperature(NetworkTemperature networkTemperature) {
        this.networkTemperature = networkTemperature;
    }

}
