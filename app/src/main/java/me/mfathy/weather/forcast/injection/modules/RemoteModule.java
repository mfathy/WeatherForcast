package me.mfathy.weather.forcast.injection.modules;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import me.mfathy.weather.forcast.BuildConfig;
import me.mfathy.weather.forcast.ForecastApp;
import me.mfathy.weather.forcast.data.mapper.remote.*;
import me.mfathy.weather.forcast.data.store.remote.service.ForecastServiceApi;
import me.mfathy.weather.forcast.data.store.remote.service.ServiceFactory;
import me.mfathy.weather.forcast.data.store.remote.utils.NetworkUtils;
import me.mfathy.weather.forcast.data.store.remote.utils.NetworkUtilsImpl;
import me.mfathy.weather.forcast.domain.model.Forecast;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
@Module
public class RemoteModule {

    @Provides
    CompositeDisposable providesCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    ForecastServiceApi provideForecastServiceApi() {
        return ServiceFactory.makeRemoteService(BuildConfig.DEBUG);
    }

    @Provides
    NetworkUtils providesNetworkUtils(ForecastApp app) {
        return new NetworkUtilsImpl(app.getApplicationContext());
    }

    @Provides
    CityRemoteMapper providesCityRemoteMapper() {
        return new CityRemoteMapper();
    }

    @Provides
    DailyForecastRemoteMapper providesDailyForecastRemoteMapper(TemperatureRemoteMapper temperatureRemoteMapper) {
        return new DailyForecastRemoteMapper(temperatureRemoteMapper);
    }

    @Provides
    TemperatureRemoteMapper providesTemperatureRemoteMapper(MaximumRemoteMapper maximumDataMapper, MinimumRemoteMapper minimumDataMapper) {
        return new TemperatureRemoteMapper(maximumDataMapper, minimumDataMapper);
    }

    @Provides
    MaximumRemoteMapper providesMaximumRemoteMapper() {
        return new MaximumRemoteMapper();
    }

    @Provides
    MinimumRemoteMapper providesMinimumRemoteMapper() {
        return new MinimumRemoteMapper();
    }

    @Provides
    ForecastRemoteMapper providesForecastRemoteMapper(DailyForecastRemoteMapper dailyForecastRemoteMapper) {
        return new ForecastRemoteMapper(dailyForecastRemoteMapper);
    }
}
