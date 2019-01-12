
package me.mfathy.weather.forcast.data.store.remote.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class NetworkNight {

    @SerializedName("Icon")
    private Long icon;
    @SerializedName("IconPhrase")
    private String iconPhrase;

    public Long getIcon() {
        return icon;
    }

    public void setIcon(Long icon) {
        this.icon = icon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

}
