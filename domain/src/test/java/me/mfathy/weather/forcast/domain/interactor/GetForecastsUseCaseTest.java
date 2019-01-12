package me.mfathy.weather.forcast.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.TestObserver;
import me.mfathy.weather.forcast.domain.ForecastsRepository;
import me.mfathy.weather.forcast.domain.model.Forecast;
import me.mfathy.weather.forcast.domain.test.DataFactory;
import me.mfathy.weather.forcast.domain.test.ForecastFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(JUnit4.class)
public class GetForecastsUseCaseTest {

    private GetForecastsUseCase mUseCase;

    @Mock
    private ForecastsRepository mockRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mUseCase = new GetForecastsUseCase(new CompositeDisposable(), mockRepository);
    }

    @After
    public void tearDown() {
        mUseCase.dispose();
    }


    @Test
    public void testGetForecastsUseCaseCompletes() {
        Forecast forecast = ForecastFactory.makeForecast();
        Observable<Forecast> observable = Observable.just(forecast);
        stubGetForecastsUseCase(observable);
        TestObserver testObserver = mUseCase.execute(new GetForecastsUseCase.Params(DataFactory.randomString(), DataFactory.randomString())).test();
        testObserver.assertComplete();
    }

    @Test
    public void testGetForecastsUseCaseReturnData() {
        Forecast forecast = ForecastFactory.makeForecast();
        Observable<Forecast> observable = Observable.just(forecast);
        stubGetForecastsUseCase(observable);
        TestObserver testObserver = mUseCase.execute(new GetForecastsUseCase.Params(DataFactory.randomString(), DataFactory.randomString())).test();
        testObserver.assertValue(forecast);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetForecastsUseCaseThrowsException() {
        mUseCase.execute(null).test();
    }

    private void stubGetForecastsUseCase(Observable<Forecast> observable) {
        given(mockRepository.getForecasts(anyString(), anyString())).willReturn(observable);
    }
}