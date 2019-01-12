package me.mfathy.weather.forcast.domain;

import io.reactivex.Observable;
import me.mfathy.weather.forcast.domain.model.City;
import me.mfathy.weather.forcast.domain.model.Forecast;

import java.util.List;

public interface ForecastsRepository {

    Observable<List<City>> getCities();

    Observable<Forecast> getForecasts(String timeRange, String cityKey);

}
