package me.mfathy.weather.forcast.data.mapper.remote;

import me.mfathy.weather.forcast.data.mapper.data.CityDataMapper;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkCity;
import me.mfathy.weather.forcast.data.test.CityEntityFactory;
import me.mfathy.weather.forcast.domain.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by Mohammed Fathy on 13/01/2019.
 * dev.mfathy@gmail.com
 */

@RunWith(JUnit4.class)
public class CityRemoteMapperTest {
    private CityRemoteMapper mapper = new CityRemoteMapper();

    @Test
    public void testTransformMapsData() {
        NetworkCity network = CityEntityFactory.makeNetworkCity();
        CityEntity entity = mapper.transform(network);

        assertDataEqual(entity, network);
    }

    private void assertDataEqual(CityEntity entity, NetworkCity city) {
        assertEquals(entity.getKey(), city.getKey());
        assertEquals(entity.getLocalizedName(), city.getLocalizedName());
        assertEquals(entity.getRank(), city.getRank());
        assertEquals(entity.getType(), city.getType());
        assertEquals(entity.getVersion(), city.getVersion());
    }
}