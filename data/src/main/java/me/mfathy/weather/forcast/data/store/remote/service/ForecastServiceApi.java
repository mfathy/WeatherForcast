package me.mfathy.weather.forcast.data.store.remote.service;

import io.reactivex.Single;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkCity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkForecast;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public interface ForecastServiceApi {

    @GET("locations/v1/topcities/{count}")
    Single<List<NetworkCity>> getCities(
            @Path("count") int count, @Query("apikey") String appKey

    );

    @GET("forecasts/v1/daily/{timeRange}/{cityKey}")
    Single<NetworkForecast> getForecasts(
            @Path("cityKey") String cityKey,
            @Path("timeRange") String timeRange,
            @Query("apikey") String appKey
    );
}
