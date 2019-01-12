package me.mfathy.weather.forcast.data;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import me.mfathy.weather.forcast.data.mapper.data.CityDataMapper;
import me.mfathy.weather.forcast.data.mapper.data.ForecastDataMapper;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.ForecastDataStore;
import me.mfathy.weather.forcast.domain.ForecastsRepository;
import me.mfathy.weather.forcast.domain.model.City;
import me.mfathy.weather.forcast.domain.model.Forecast;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class ForecastsRepositoryImpl implements ForecastsRepository {

    private ForecastDataMapper forecastDataMapper;
    private CityDataMapper cityDataMapper;
    private ForecastDataStore mDataStore;

    @Inject
    public ForecastsRepositoryImpl(ForecastDataMapper forecastDataMapper, CityDataMapper cityDataMapper, ForecastDataStore mDataStore) {
        this.forecastDataMapper = forecastDataMapper;
        this.cityDataMapper = cityDataMapper;
        this.mDataStore = mDataStore;
    }

    @Override
    public Observable<List<City>> getCities() {
        return mDataStore.getCities().map(new Function<List<CityEntity>, List<City>>() {
            @Override
            public List<City> apply(List<CityEntity> cityEntities){
                List<City> cities = new ArrayList<>();
                for (CityEntity entity: cityEntities) {
                    cities.add(cityDataMapper.transform(entity));
                }
                return cities;
            }
        }).toObservable();
    }

    @Override
    public Observable<Forecast> getForecasts(String timeRange, String cityKey) {
        return mDataStore.getForecasts(timeRange, cityKey).map(new Function<ForecastEntity, Forecast>() {
            @Override
            public Forecast apply(ForecastEntity forecastEntity) {
                return forecastDataMapper.transform(forecastEntity);
            }
        }).toObservable();
    }
}
