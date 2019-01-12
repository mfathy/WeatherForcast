package me.mfathy.weather.forcast.ui.forecast

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import me.mfathy.weather.forcast.domain.interactor.GetForecastsUseCase
import me.mfathy.weather.forcast.domain.model.Forecast
import me.mfathy.weather.forcast.state.Resource
import me.mfathy.weather.forcast.state.ResourceState

import javax.inject.Inject

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
class ForecastViewModel @Inject
constructor(private val getForecastsUseCase: GetForecastsUseCase) : ViewModel() {
    val forecastMutableLiveData = MutableLiveData<Resource<Forecast>>()


    override fun onCleared() {
        getForecastsUseCase.dispose()
        super.onCleared()
    }

    fun fetchForecasts(scheduler: Scheduler, observer: Scheduler, city: String, time: String) {
        forecastMutableLiveData.postValue(Resource<Forecast>(ResourceState.LOADING, null, null, null))
        getForecastsUseCase.execute(GetForecastsUseCase.Params(city, time))
            .subscribeOn(scheduler)
            .observeOn(observer)
            .subscribe(CitiesSubscriber())
    }

    internal inner class CitiesSubscriber : DisposableObserver<Forecast>() {

        override fun onNext(forecast: Forecast) {
            forecastMutableLiveData.postValue(Resource(ResourceState.SUCCESS, forecast, null, null))
        }

        override fun onError(e: Throwable) {
            forecastMutableLiveData.postValue(Resource(ResourceState.ERROR, null, e.message, e))
        }

        override fun onComplete() {

        }
    }
}
