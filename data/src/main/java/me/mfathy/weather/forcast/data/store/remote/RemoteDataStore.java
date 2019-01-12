package me.mfathy.weather.forcast.data.store.remote;

import io.reactivex.Single;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.ForecastDataStore;

import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public interface RemoteDataStore extends ForecastDataStore {
    @Override
    Single<List<CityEntity>> getCities();

    @Override
    Single<ForecastEntity> getForecasts(String timeRange, String cityKey);
}
