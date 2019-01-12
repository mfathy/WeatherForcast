
package me.mfathy.weather.forcast.data.store.remote.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class NetworkCity {

    @SerializedName("Key")
    private String key;
    @SerializedName("LocalizedName")
    private String localizedName;
    @SerializedName("Rank")
    private Long rank;
    @SerializedName("Type")
    private String type;
    @SerializedName("Version")
    private Long version;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
