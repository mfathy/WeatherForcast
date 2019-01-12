package me.mfathy.weather.forcast.data.store.remote;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import me.mfathy.weather.forcast.data.BuildConfig;
import me.mfathy.weather.forcast.data.mapper.remote.CityRemoteMapper;
import me.mfathy.weather.forcast.data.mapper.remote.ForecastRemoteMapper;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.exceptions.NetworkConnectionException;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkCity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkForecast;
import me.mfathy.weather.forcast.data.store.remote.service.ForecastServiceApi;
import me.mfathy.weather.forcast.data.store.remote.utils.NetworkUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class RemoteDataStoreImpl implements RemoteDataStore {

    private NetworkUtils networkUtils;
    private ForecastServiceApi forecastServiceApi;
    private CityRemoteMapper cityRemoteMapper;
    private ForecastRemoteMapper forecastRemoteMapper;

    @Inject
    public RemoteDataStoreImpl(NetworkUtils networkUtils, ForecastServiceApi forecastServiceApi, CityRemoteMapper cityRemoteMapper, ForecastRemoteMapper forecastRemoteMapper) {
        this.networkUtils = networkUtils;
        this.forecastServiceApi = forecastServiceApi;
        this.cityRemoteMapper = cityRemoteMapper;
        this.forecastRemoteMapper = forecastRemoteMapper;
    }


    @Override
    public Single<List<CityEntity>> getCities() {
        if (networkUtils.hasConnection())
            return forecastServiceApi.getCities(50, BuildConfig.APP_KEY)
                    .map(new Function<List<NetworkCity>, List<CityEntity>>() {
                        @Override
                        public List<CityEntity> apply(List<NetworkCity> networkCities) {
                            List<CityEntity> entities = new ArrayList<>();
                            for (NetworkCity city: networkCities) {
                                entities.add(cityRemoteMapper.transform(city));
                            }
                            return entities;
                        }
                    });
        else
            return Single.error(new NetworkConnectionException());
    }

    @Override
    public Single<ForecastEntity> getForecasts(String timeRange, String cityKey) {
        if (networkUtils.hasConnection())
            return forecastServiceApi.getForecasts(cityKey, timeRange, BuildConfig.APP_KEY)
                    .map(new Function<NetworkForecast, ForecastEntity>() {
                        @Override
                        public ForecastEntity apply(NetworkForecast networkForecast){
                            return forecastRemoteMapper.transform(networkForecast);
                        }
                    });
        else
            return Single.error(new NetworkConnectionException());
    }
}
