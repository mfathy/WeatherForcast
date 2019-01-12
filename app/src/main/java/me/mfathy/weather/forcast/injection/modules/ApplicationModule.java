package me.mfathy.weather.forcast.injection.modules;

import android.content.Context;
import dagger.Binds;
import dagger.Module;
import me.mfathy.weather.forcast.ForecastApp;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
@Module
public abstract class ApplicationModule {
    @Binds
    abstract Context bindContext(ForecastApp forecastApp);
}
