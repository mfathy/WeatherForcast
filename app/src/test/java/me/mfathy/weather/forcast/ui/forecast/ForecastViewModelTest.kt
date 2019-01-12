package me.mfathy.weather.forcast.ui.forecast

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import me.mfathy.weather.forcast.domain.interactor.GetForecastsUseCase
import me.mfathy.weather.forcast.domain.model.Forecast
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
class ForecastViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private var getForecastsUseCase: GetForecastsUseCase = mock()
    private var viewModel = ForecastViewModel(getForecastsUseCase)

    @Captor
    val captor = argumentCaptor<DisposableSubscriber<Forecast>>()


    @Test
    fun testFetchAirportsExecutesUseCase() {
        whenever(getForecastsUseCase.execute(any())).thenReturn(Observable.empty())
        viewModel.fetchForecasts(Schedulers.trampoline(),Schedulers.trampoline(),"", "")

        verify(getForecastsUseCase, times(1)).execute(any())
    }
}