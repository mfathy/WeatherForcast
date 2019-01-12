package me.mfathy.weather.forcast.data.store;

import io.reactivex.Single;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;

import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public interface ForecastDataStore {

    Single<List<CityEntity>> getCities();

    Single<ForecastEntity> getForecasts(String timeRange, String cityKey);
}
