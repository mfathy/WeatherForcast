package me.mfathy.weather.forcast.data.store;

import io.reactivex.Single;
import me.mfathy.weather.forcast.data.mapper.remote.CityRemoteMapper;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.remote.RemoteDataStore;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class ForecastDataStoreImpl implements ForecastDataStore {

    private RemoteDataStore remoteDataStore;

    @Inject
    public ForecastDataStoreImpl(RemoteDataStore remoteDataStore) {
        this.remoteDataStore = remoteDataStore;
    }

    @Override
    public Single<List<CityEntity>> getCities() {
        return remoteDataStore.getCities();
    }

    @Override
    public Single<ForecastEntity> getForecasts(String timeRange, String cityKey) {
        return remoteDataStore.getForecasts(timeRange, cityKey);

    }
}
