package me.mfathy.weather.forcast;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;
import me.mfathy.weather.forcast.injection.DaggerAppComponent;

import javax.inject.Inject;

/**
 * Created by Mohammed Fathy on 15/09/2018.
 * dev.mfathy@gmail.com
 * <p>
 * {@link ForecastApp} Android Main Application
 */
public class ForecastApp extends Application implements HasActivityInjector, HasFragmentInjector {

    /**
     * Performs members-injection on instances of core Android types (e.g. Activity, Fragment) that
     * are constructed by the Android framework and not by Dagger. This class relies on an injected
     * mapping from each concrete class to an AndroidInjector.Factory for an AndroidInjector of that class.
     * Each concrete class must have its own entry in the map, even if it extends another class
     * which is already present in the map. Calls Object.getClass() on the instance in order to
     * find the appropriate AndroidInjector.Factory.
     */
    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return mFragmentInjector;
    }
}
