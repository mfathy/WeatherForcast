package me.mfathy.weather.forcast.domain.test;

import me.mfathy.weather.forcast.domain.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class CityFactory {

    public static City makeCity() {
        return new City.Builder()
                .withKey(DataFactory.randomString())
                .withLocalizedName(DataFactory.randomString())
                .withRank((long)DataFactory.randomInt())
                .withType(DataFactory.randomString())
                .withVersion((long) DataFactory.randomInt())
                .build();
    }

    public static List<City> makeCityList(int count){
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cities.add(makeCity());
        }
        return cities;
    }
}
