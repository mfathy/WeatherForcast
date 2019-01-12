
package me.mfathy.weather.forcast.data.store.remote.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class NetworkTemperature {

    @SerializedName("Maximum")
    private NetworkMaximum networkMaximum;
    @SerializedName("Minimum")
    private NetworkMinimum networkMinimum;

    public NetworkMaximum getNetworkMaximum() {
        return networkMaximum;
    }

    public void setNetworkMaximum(NetworkMaximum networkMaximum) {
        this.networkMaximum = networkMaximum;
    }

    public NetworkMinimum getNetworkMinimum() {
        return networkMinimum;
    }

    public void setNetworkMinimum(NetworkMinimum networkMinimum) {
        this.networkMinimum = networkMinimum;
    }

}
