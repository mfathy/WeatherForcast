package me.mfathy.weather.forcast.data.mapper.data;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.DailyForecastEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.domain.model.DailyForecast;
import me.mfathy.weather.forcast.domain.model.Forecast;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class ForecastDataMapper implements EntityMapper<Forecast, ForecastEntity> {

    private DailyForecastDataMapper dailyForecastDataMapper;

    @Inject
    public ForecastDataMapper(DailyForecastDataMapper dailyForecastDataMapper) {
        this.dailyForecastDataMapper = dailyForecastDataMapper;
    }

    @Override
    public Forecast transform(ForecastEntity domain) {
        List<DailyForecast> dailyForecasts = new ArrayList<>();
        for (DailyForecastEntity entity : domain.getDailyForecasts()) {
            dailyForecasts.add(dailyForecastDataMapper.transform(entity));
        }
        return new Forecast.Builder()
                .withDailyForecasts(dailyForecasts)
                .withHeadline(domain.getHeadline())
                .build();
    }
}
