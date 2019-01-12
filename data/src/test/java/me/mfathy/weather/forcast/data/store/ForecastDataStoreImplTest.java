package me.mfathy.weather.forcast.data.store;

import io.reactivex.Single;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.remote.RemoteDataStore;
import me.mfathy.weather.forcast.data.store.remote.RemoteDataStoreImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Mohammed Fathy on 13/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(JUnit4.class)
public class ForecastDataStoreImplTest {

    private ForecastDataStore dataStore;

    private RemoteDataStore mockStore = mock(RemoteDataStoreImpl.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        dataStore = new ForecastDataStoreImpl(mockStore);
    }

    @Test
    public void testGetCitiesCallsRemote() {
        List<CityEntity> entities = new ArrayList<>();
        given(mockStore.getCities()).willReturn(Single.just(entities));

        dataStore.getCities().test();

        verify(mockStore).getCities();

    }

    @Test
    public void testGetForecastsCallsRemote() {

        ForecastEntity forecast = new ForecastEntity();
        given(mockStore.getForecasts(anyString(), anyString())).willReturn(Single.just(forecast));

        dataStore.getForecasts("", "").test();

        verify(mockStore).getForecasts(anyString(), anyString());

    }


}