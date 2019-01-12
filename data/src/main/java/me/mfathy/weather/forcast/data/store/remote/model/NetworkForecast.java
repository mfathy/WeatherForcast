
package me.mfathy.weather.forcast.data.store.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class NetworkForecast {

    @SerializedName("DailyForecasts")
    private List<NetworkDailyForecast> networkDailyForecasts;
    @SerializedName("Headline")
    private NetworkHeadline networkHeadline;

    public List<NetworkDailyForecast> getNetworkDailyForecasts() {
        return networkDailyForecasts;
    }

    public void setNetworkDailyForecasts(List<NetworkDailyForecast> networkDailyForecasts) {
        this.networkDailyForecasts = networkDailyForecasts;
    }

    public NetworkHeadline getNetworkHeadline() {
        return networkHeadline;
    }

    public void setNetworkHeadline(NetworkHeadline networkHeadline) {
        this.networkHeadline = networkHeadline;
    }

}
