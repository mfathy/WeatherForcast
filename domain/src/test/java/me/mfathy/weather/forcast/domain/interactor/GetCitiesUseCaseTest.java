package me.mfathy.weather.forcast.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.TestObserver;
import me.mfathy.weather.forcast.domain.ForecastsRepository;
import me.mfathy.weather.forcast.domain.model.City;
import me.mfathy.weather.forcast.domain.test.CityFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(JUnit4.class)
public class GetCitiesUseCaseTest {

    private GetCitiesUseCase mUseCase;

    @Mock
    private ForecastsRepository mockRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mUseCase = new GetCitiesUseCase(new CompositeDisposable(), mockRepository);
    }

    @After
    public void tearDown() {
        mUseCase.dispose();
    }


    @Test
    public void testGetCitiesUseCaseCompletes() {
        List<City> cities = CityFactory.makeCityList(2);
        Observable<List<City>> observable = Observable.just(cities);
        stubGetCitiesUseCase(observable);
        TestObserver<List<City>> testObserver = mUseCase.execute(new GetCitiesUseCase.Params("")).test();
        testObserver.assertComplete();
    }

    @Test
    public void testGetCitiesUseCaseReturnData() {
        List<City> cities = CityFactory.makeCityList(2);
        Observable<List<City>> observable = Observable.just(cities);
        stubGetCitiesUseCase(observable);
        TestObserver<List<City>> testObserver = mUseCase.execute(new GetCitiesUseCase.Params("")).test();
        testObserver.assertValue(cities);
    }

    private void stubGetCitiesUseCase(Observable<List<City>> observable) {
        given(mockRepository.getCities()).willReturn(observable);
    }
}