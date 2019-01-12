package me.mfathy.weather.forcast.data.test;

import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkCity;
import me.mfathy.weather.forcast.domain.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class CityEntityFactory {

    public static CityEntity makeCity() {
        return new CityEntity.Builder()
                .withKey(DataEntityFactory.randomString())
                .withLocalizedName(DataEntityFactory.randomString())
                .withRank((long)DataEntityFactory.randomInt())
                .withType(DataEntityFactory.randomString())
                .withVersion((long) DataEntityFactory.randomInt())
                .build();
    }

    public static List<CityEntity> makeCityList(int count){
        List<CityEntity> cities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cities.add(makeCity());
        }
        return cities;
    }

    public static NetworkCity makeNetworkCity() {
        NetworkCity city = new NetworkCity();
        city.setKey(DataEntityFactory.randomString());
        city.setLocalizedName(DataEntityFactory.randomString());
        city.setRank((long) DataEntityFactory.randomInt());
        city.setType(DataEntityFactory.randomString());
        city.setVersion((long) DataEntityFactory.randomInt());
        return city;
    }
}
