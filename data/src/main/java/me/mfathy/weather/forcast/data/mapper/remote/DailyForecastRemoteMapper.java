package me.mfathy.weather.forcast.data.mapper.remote;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.DailyForecastEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkDailyForecast;

import javax.inject.Inject;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class DailyForecastRemoteMapper implements EntityMapper<DailyForecastEntity, NetworkDailyForecast> {

    private TemperatureRemoteMapper temperatureRemoteMapper;

    @Inject public DailyForecastRemoteMapper(TemperatureRemoteMapper temperatureRemoteMapper) {
        this.temperatureRemoteMapper = temperatureRemoteMapper;
    }

    @Override
    public DailyForecastEntity transform(NetworkDailyForecast domain) {
        return new DailyForecastEntity.Builder()
                .withDay(domain.getNetworkDay().getIconPhrase())
                .withNight(domain.getNetworkNight().getIconPhrase())
                .withTemperature(temperatureRemoteMapper.transform(domain.getNetworkTemperature()))
                .build();
    }
}
