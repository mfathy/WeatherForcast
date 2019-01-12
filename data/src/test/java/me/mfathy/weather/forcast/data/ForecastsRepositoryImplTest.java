package me.mfathy.weather.forcast.data;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import me.mfathy.weather.forcast.data.mapper.data.CityDataMapper;
import me.mfathy.weather.forcast.data.mapper.data.ForecastDataMapper;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.ForecastDataStore;
import me.mfathy.weather.forcast.domain.ForecastsRepository;
import me.mfathy.weather.forcast.domain.model.City;
import me.mfathy.weather.forcast.domain.model.Forecast;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Mohammed Fathy on 13/01/2019.
 * dev.mfathy@gmail.com
 */
public class ForecastsRepositoryImplTest {

    private ForecastsRepository repository;
    private ForecastDataMapper mockForecastDataMapper = mock(ForecastDataMapper.class);
    private CityDataMapper mockCityDataMapper = mock(CityDataMapper.class);
    private ForecastDataStore mockStore = mock(ForecastDataStore.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        repository = new ForecastsRepositoryImpl(
                mockForecastDataMapper,
                mockCityDataMapper,
                mockStore
        );
    }

    @Test
    public void testGetCitiesCompletes() {

        List<CityEntity> entities = new ArrayList<>();
        given(mockStore.getCities()).willReturn(Single.just(entities));
        given(mockCityDataMapper.transform(any(CityEntity.class))).willReturn(new City());
        TestObserver testObserver = repository.getCities().test();
        testObserver.assertComplete();
    }

    @Test
    public void testGetCitiesCallsStore() {

        List<CityEntity> entities = new ArrayList<>();
        given(mockStore.getCities()).willReturn(Single.just(entities));
        given(mockCityDataMapper.transform(any(CityEntity.class))).willReturn(new City());
        repository.getCities().test();

        verify(mockStore).getCities();
    }

    @Test
    public void testGetForecastsCompletes() {

        ForecastEntity forecastEntity = new ForecastEntity();
        given(mockStore.getForecasts(anyString(), anyString())).willReturn(Single.just(forecastEntity));
        given(mockForecastDataMapper.transform(any(ForecastEntity.class))).willReturn(new Forecast());
        TestObserver testObserver = repository.getForecasts("", "").test();
        testObserver.assertComplete();
    }

    @Test
    public void testGetForecastsCallStore() {

        ForecastEntity forecastEntity = new ForecastEntity();
        given(mockStore.getForecasts(anyString(), anyString())).willReturn(Single.just(forecastEntity));
        given(mockForecastDataMapper.transform(any(ForecastEntity.class))).willReturn(new Forecast());
        repository.getForecasts("", "").test();

        verify(mockStore).getForecasts(anyString(), anyString());
    }
}