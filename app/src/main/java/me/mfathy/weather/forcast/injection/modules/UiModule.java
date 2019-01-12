package me.mfathy.weather.forcast.injection.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.mfathy.weather.forcast.ui.forecast.ForecastActivity;
import me.mfathy.weather.forcast.ui.main.MainActivity;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
@Module
abstract public class UiModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract ForecastActivity contributeForecastActivity();
}
