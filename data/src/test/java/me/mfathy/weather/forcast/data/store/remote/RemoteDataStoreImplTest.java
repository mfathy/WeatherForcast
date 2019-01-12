package me.mfathy.weather.forcast.data.store.remote;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import me.mfathy.weather.forcast.data.mapper.remote.CityRemoteMapper;
import me.mfathy.weather.forcast.data.mapper.remote.ForecastRemoteMapper;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkCity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkForecast;
import me.mfathy.weather.forcast.data.store.remote.service.ForecastServiceApi;
import me.mfathy.weather.forcast.data.store.remote.utils.NetworkUtils;
import me.mfathy.weather.forcast.data.test.CityEntityFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Mohammed Fathy on 13/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(JUnit4.class)
public class RemoteDataStoreImplTest {

    private NetworkUtils mockNetwork = mock(NetworkUtils.class);

    private ForecastServiceApi mockApi = mock(ForecastServiceApi.class);

    private CityRemoteMapper cityMapper = mock(CityRemoteMapper.class);

    private ForecastRemoteMapper forecastMapper = mock(ForecastRemoteMapper.class);

    private RemoteDataStoreImpl store = new RemoteDataStoreImpl(
            mockNetwork,
            mockApi,
            cityMapper,
            forecastMapper
    );

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        stubNetworkUtils();
    }

    private void stubNetworkUtils() {
        given(mockNetwork.hasConnection()).willReturn(true);
    }

    @Test
    public void testGetCitiesCompletes() {
        //  Stub
        NetworkCity city = CityEntityFactory.makeNetworkCity();
        List<NetworkCity> networkCities = new ArrayList<>();
        networkCities.add(city);
        given(mockApi.getCities(anyInt(), anyString())).willReturn(Single.just(networkCities));
        given(cityMapper.transform(any(NetworkCity.class))).willReturn(CityEntityFactory.makeCity());

        TestObserver<List<CityEntity>> testObserver = store.getCities().test();
        testObserver.assertComplete();
    }

    @Test
    public void testGetCitiesReturnData() {
        //  Stub
        NetworkCity city = CityEntityFactory.makeNetworkCity();
        List<NetworkCity> networkCities = new ArrayList<>();
        networkCities.add(city);
        given(mockApi.getCities(anyInt(), anyString())).willReturn(Single.just(networkCities));
        CityEntity cityEntity = CityEntityFactory.makeCity();
        given(cityMapper.transform(any(NetworkCity.class))).willReturn(cityEntity);

        TestObserver<List<CityEntity>> testObserver = store.getCities().test();
        List<CityEntity> entities = new ArrayList<>();
        entities.add(cityEntity);

        testObserver.assertValue(entities);
    }

    @Test
    public void testGetCitiesCallService() {
        //  Stub
        NetworkCity city = CityEntityFactory.makeNetworkCity();
        List<NetworkCity> networkCities = new ArrayList<>();
        networkCities.add(city);
        given(mockApi.getCities(anyInt(), anyString())).willReturn(Single.just(networkCities));
        CityEntity cityEntity = CityEntityFactory.makeCity();
        given(cityMapper.transform(any(NetworkCity.class))).willReturn(cityEntity);

        store.getCities().test();

        verify(mockApi).getCities(anyInt(),anyString());
    }

    @Test
    public void testGetForecastsCompletes(){
        NetworkForecast networkForecast = new NetworkForecast();
        ForecastEntity forecastEntity = new ForecastEntity();
        given(mockApi.getForecasts(anyString(), anyString(), anyString())).willReturn(Single.just(networkForecast));
        given(forecastMapper.transform(any(NetworkForecast.class))).willReturn(forecastEntity);

        TestObserver testObserver = store.getForecasts("", "").test();
        testObserver.assertComplete();

    }

    @Test
    public void testGetForecastsReturnsData(){
        NetworkForecast networkForecast = new NetworkForecast();
        ForecastEntity forecastEntity = new ForecastEntity();
        given(mockApi.getForecasts(anyString(), anyString(), anyString())).willReturn(Single.just(networkForecast));
        given(forecastMapper.transform(any(NetworkForecast.class))).willReturn(forecastEntity);

        TestObserver testObserver = store.getForecasts("", "").test();
        testObserver.assertValue(forecastEntity);

    }

    @Test
    public void testGetForecastsCallService(){
        NetworkForecast networkForecast = new NetworkForecast();
        ForecastEntity forecastEntity = new ForecastEntity();
        given(mockApi.getForecasts(anyString(), anyString(), anyString())).willReturn(Single.just(networkForecast));
        given(forecastMapper.transform(any(NetworkForecast.class))).willReturn(forecastEntity);

        store.getForecasts("", "").test();

        verify(mockApi).getForecasts(anyString(), anyString(), anyString());
    }


}