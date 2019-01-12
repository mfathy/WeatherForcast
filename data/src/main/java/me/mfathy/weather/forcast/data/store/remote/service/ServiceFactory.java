package me.mfathy.weather.forcast.data.store.remote.service;

import com.google.gson.Gson;
import me.mfathy.weather.forcast.data.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class ServiceFactory {

    public static ForecastServiceApi makeRemoteService(boolean isDebug){
        return makeRemoteService(new Gson(), makeOkHttpClient());
    }

    private static ForecastServiceApi makeRemoteService(Gson gson, OkHttpClient o) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(ForecastServiceApi.class);
    }

    private static OkHttpClient makeOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }
}
