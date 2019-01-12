package me.mfathy.weather.forcast.data.mapper.data;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.DailyForecastEntity;
import me.mfathy.weather.forcast.domain.model.DailyForecast;

import javax.inject.Inject;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class DailyForecastDataMapper implements EntityMapper<DailyForecast, DailyForecastEntity> {

    private TemperatureDataMapper temperatureDataMapper;

    @Inject
    public DailyForecastDataMapper(TemperatureDataMapper temperatureDataMapper) {
        this.temperatureDataMapper = temperatureDataMapper;
    }

    @Override
    public DailyForecast transform(DailyForecastEntity domain) {
        return new DailyForecast.Builder()
                .withDay(domain.getDayText())
                .withNight(domain.getNightText())
                .withTemperature(temperatureDataMapper.transform(domain.getTemperature()))
                .build();
    }
}
