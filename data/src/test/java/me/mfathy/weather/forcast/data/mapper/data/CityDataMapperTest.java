package me.mfathy.weather.forcast.data.mapper.data;

import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.test.CityEntityFactory;
import me.mfathy.weather.forcast.domain.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(JUnit4.class)
public class CityDataMapperTest {

    private CityDataMapper mapper = new CityDataMapper();

    @Test
    public void testTransformMapsData() {
        CityEntity entity = CityEntityFactory.makeCity();
        City city = mapper.transform(entity);

        assertDataEqual(entity, city);
    }

    private void assertDataEqual(CityEntity entity, City city) {
        assertEquals(entity.getKey(), city.getKey());
        assertEquals(entity.getLocalizedName(), city.getLocalizedName());
        assertEquals(entity.getRank(), city.getRank());
        assertEquals(entity.getType(), city.getType());
        assertEquals(entity.getVersion(), city.getVersion());
    }
}