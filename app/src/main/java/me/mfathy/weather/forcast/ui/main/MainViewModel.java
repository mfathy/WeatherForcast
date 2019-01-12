package me.mfathy.weather.forcast.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
import me.mfathy.weather.forcast.domain.interactor.GetCitiesUseCase;
import me.mfathy.weather.forcast.domain.model.City;
import me.mfathy.weather.forcast.state.Resource;
import me.mfathy.weather.forcast.state.ResourceState;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class MainViewModel extends ViewModel {

    GetCitiesUseCase getCitiesUseCase;
    private MutableLiveData<Resource<List<City>>> citiesMutableLiveData = new MutableLiveData<>();

    @Inject
    public MainViewModel(GetCitiesUseCase getCitiesUseCase) {
        this.getCitiesUseCase = getCitiesUseCase;
    }

    @Override
    protected void onCleared() {
        getCitiesUseCase.dispose();
        super.onCleared();
    }

    public MutableLiveData<Resource<List<City>>> getCitiesMutableLiveData() {
        return citiesMutableLiveData;
    }

    public void fetchCities(Scheduler scheduler, Scheduler observer) {
        citiesMutableLiveData.postValue(new Resource<List<City>>(ResourceState.LOADING, null, null, null));
        getCitiesUseCase.execute(null)
                .subscribeOn(scheduler)
                .observeOn(observer)
                .subscribe(new CitiesSubscriber());
    }

    class CitiesSubscriber extends DisposableObserver<List<City>> {
        @Override
        public void onNext(List<City> cities) {
            citiesMutableLiveData.postValue(new Resource(ResourceState.SUCCESS, cities, null, null));
        }

        @Override
        public void onError(Throwable e) {
            citiesMutableLiveData.postValue(new Resource(ResourceState.ERROR, null, e.getMessage(), e));
        }

        @Override
        public void onComplete() {

        }
    }
}
