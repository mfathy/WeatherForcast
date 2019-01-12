package me.mfathy.weather.forcast.injection.modules;

import dagger.Module;
import dagger.Provides;
import me.mfathy.weather.forcast.data.mapper.data.*;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
@Module
public class DataMapperModule {
    @Provides
    CityDataMapper providesCityDataMapper() {
        return new CityDataMapper();
    }

    @Provides
    MaximumDataMapper providesMaximumDataMapper() {
        return new MaximumDataMapper();
    }

    @Provides
    MinimumDataMapper providesMinimumDataMapper() {
        return new MinimumDataMapper();
    }

    @Provides
    TemperatureDataMapper providesTemperatureDataMapper(MaximumDataMapper maximumDataMapper, MinimumDataMapper minimumDataMapper) {
        return new TemperatureDataMapper(maximumDataMapper, minimumDataMapper);
    }

    @Provides
    DailyForecastDataMapper providesDailyForecastDataMapper(TemperatureDataMapper temperatureDataMapper) {
        return new DailyForecastDataMapper(temperatureDataMapper);
    }

    @Provides
    ForecastDataMapper providesForecastDataMapper(DailyForecastDataMapper dailyForecastDataMapper) {
        return new ForecastDataMapper(dailyForecastDataMapper);
    }
}
