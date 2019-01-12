package me.mfathy.weather.forcast.data.mapper.data;

import me.mfathy.weather.forcast.data.model.ForecastEntity;
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
public class ForecastDataMapperTest {

    private MaximumDataMapper maxMapper = new MaximumDataMapper();
    private MinimumDataMapper minMapper = new MinimumDataMapper();
    private TemperatureDataMapper tempMapper = new TemperatureDataMapper(maxMapper, minMapper);
    private DailyForecastDataMapper dailyMapper = new DailyForecastDataMapper(tempMapper);
    private ForecastDataMapper mapper = new ForecastDataMapper(dailyMapper);

    @Test
    public void testTransformMapsData() {
        ForecastEntity entity = ForecastEntityFactory.makeForecast();
        Forecast forecast = mapper.transform(entity);

        assertDataEqual(entity, forecast);
    }

    private void assertDataEqual(ForecastEntity entity, Forecast forecast) {
        assertEquals(entity.getHeadline(), forecast.getHeadline());
        assertEquals(entity.getDailyForecasts().size(), forecast.getDailyForecasts().size());
        assertEquals(entity.getDailyForecasts().get(0).getDayText(), forecast.getDailyForecasts().get(0).getDayText());
    }
}