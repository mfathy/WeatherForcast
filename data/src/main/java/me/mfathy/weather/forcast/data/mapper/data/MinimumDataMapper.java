package me.mfathy.weather.forcast.data.mapper.data;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.MinimumEntity;
import me.mfathy.weather.forcast.domain.model.Minimum;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class MinimumDataMapper implements EntityMapper<Minimum, MinimumEntity> {
    @Override
    public Minimum transform(MinimumEntity domain) {
        return new Minimum.Builder()
                .withUnit(domain.getUnit())
                .withUnitType(domain.getUnitType())
                .withValue(domain.getValue())
                .build();
    }
}
