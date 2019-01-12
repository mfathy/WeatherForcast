
package me.mfathy.weather.forcast.data.store.remote.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class NetworkHeadline {

    @SerializedName("Text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
