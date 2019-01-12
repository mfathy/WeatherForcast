package me.mfathy.weather.forcast.data.mapper.remote;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.mapper.data.DailyForecastDataMapper;
import me.mfathy.weather.forcast.data.model.DailyForecastEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkDailyForecast;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkForecast;
import me.mfathy.weather.forcast.domain.model.DailyForecast;
import me.mfathy.weather.forcast.domain.model.Forecast;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class ForecastRemoteMapper implements EntityMapper<ForecastEntity, NetworkForecast> {

    private DailyForecastRemoteMapper dailyForecastRemoteMapper;

    @Inject public ForecastRemoteMapper(DailyForecastRemoteMapper dailyForecastRemoteMapper) {
        this.dailyForecastRemoteMapper = dailyForecastRemoteMapper;
    }

    @Override
    public ForecastEntity transform(NetworkForecast domain) {
        List<DailyForecastEntity> dailyForecasts = new ArrayList<>();
        for (NetworkDailyForecast item: domain.getNetworkDailyForecasts()) {

            dailyForecasts.add(dailyForecastRemoteMapper.transform(item));
        }
        return new ForecastEntity.Builder()
                .withHeadline(domain.getNetworkHeadline().getText())
                .withDailyForecasts(dailyForecasts)
                .build();
    }
}
