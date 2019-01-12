package me.mfathy.weather.forcast.injection.modules;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import me.mfathy.weather.forcast.data.ForecastsRepositoryImpl;
import me.mfathy.weather.forcast.data.mapper.data.*;
import me.mfathy.weather.forcast.data.store.ForecastDataStore;
import me.mfathy.weather.forcast.data.store.ForecastDataStoreImpl;
import me.mfathy.weather.forcast.data.store.remote.RemoteDataStore;
import me.mfathy.weather.forcast.data.store.remote.RemoteDataStoreImpl;
import me.mfathy.weather.forcast.domain.ForecastsRepository;

import javax.inject.Singleton;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
@Module
abstract public class DataModule {
    @Binds
    abstract ForecastsRepository bindDataRepository(ForecastsRepositoryImpl repository);

    @Binds
    abstract ForecastDataStore bindForecastDataStore(ForecastDataStoreImpl store);

    @Binds
    abstract RemoteDataStore bindsRemoteDataStore(RemoteDataStoreImpl remoteDataStore);
}
