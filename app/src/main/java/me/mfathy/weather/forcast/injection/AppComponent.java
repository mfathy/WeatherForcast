package me.mfathy.weather.forcast.injection;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import me.mfathy.weather.forcast.ForecastApp;
import me.mfathy.weather.forcast.injection.modules.*;

import javax.inject.Singleton;

/**
 * Created by Mohammed Fathy on 15/09/2018.
 * dev.mfathy@gmail.com
 * <p>
 * {@link AppComponent} interface that ties dagger modules all together.
 * It is implemented as an interface that Dagger will use to generate the code necessary to perform
 * the dependency injection.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        DataModule.class,
        DataMapperModule.class,
        RemoteModule.class,
        UiModule.class,
        ViewModelsModule.class
})
public interface AppComponent {
    void inject(ForecastApp app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(ForecastApp application);

        AppComponent build();
    }
}

