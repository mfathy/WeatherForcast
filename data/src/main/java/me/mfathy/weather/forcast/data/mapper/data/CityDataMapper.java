package me.mfathy.weather.forcast.data.mapper.data;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.domain.model.City;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class CityDataMapper implements EntityMapper<City, CityEntity> {
    @Override
    public City transform(CityEntity domain) {
        return new City.Builder()
                .withVersion(domain.getVersion())
                .withType(domain.getType())
                .withRank(domain.getRank())
                .withLocalizedName(domain.getLocalizedName())
                .withKey(domain.getKey())
                .build();
    }
}
