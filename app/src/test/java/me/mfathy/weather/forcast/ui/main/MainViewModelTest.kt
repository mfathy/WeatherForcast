package me.mfathy.weather.forcast.ui.main

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import me.mfathy.weather.forcast.domain.interactor.GetCitiesUseCase
import me.mfathy.weather.forcast.domain.interactor.GetForecastsUseCase
import me.mfathy.weather.forcast.domain.model.City
import me.mfathy.weather.forcast.domain.model.Forecast
import me.mfathy.weather.forcast.ui.forecast.ForecastViewModel
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor

/**
 * Created by Mohammed Fathy on 13/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(JUnit4::class)
class MainViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private var mockGetCitiesUseCase: GetCitiesUseCase = mock()
    private var viewModel = MainViewModel(mockGetCitiesUseCase)

    @Captor
    val captor = argumentCaptor<DisposableSubscriber<List<City>>>()


    @Test
    fun testFetchAirportsExecutesUseCase() {
        whenever(mockGetCitiesUseCase.execute(any())).thenReturn(Observable.empty())
        viewModel.fetchCities(Schedulers.trampoline(), Schedulers.trampoline())

        verify(mockGetCitiesUseCase, times(1)).execute(any())
    }

}