package me.mfathy.weather.forcast.data.mapper.remote;

import me.mfathy.weather.forcast.data.model.ForecastEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkForecast;
import me.mfathy.weather.forcast.data.test.ForecastEntityFactory;
import me.mfathy.weather.forcast.domain.model.Forecast;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by Mohammed Fathy on 13/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(JUnit4.class)
public class ForecastRemoteMapperTest {

    private MaximumRemoteMapper maxMapper = new MaximumRemoteMapper();
    private MinimumRemoteMapper minMapper = new MinimumRemoteMapper();
    private TemperatureRemoteMapper tempMapper = new TemperatureRemoteMapper(maxMapper, minMapper);
    private DailyForecastRemoteMapper dailyMapper = new DailyForecastRemoteMapper(tempMapper);
    private ForecastRemoteMapper mapper = new ForecastRemoteMapper(dailyMapper);

    @Test
    public void testTransformMapsData() {
        NetworkForecast entity = ForecastEntityFactory.makeNetworkForecast();
        ForecastEntity forecast = mapper.transform(entity);

        assertDataEqual(entity, forecast);
    }

    private void assertDataEqual(NetworkForecast entity, ForecastEntity forecast) {
        assertEquals(entity.getNetworkHeadline().getText(), forecast.getHeadline());
        assertEquals(entity.getNetworkDailyForecasts().size(), forecast.getDailyForecasts().size());
    }

}