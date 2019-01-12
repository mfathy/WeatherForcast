package me.mfathy.weather.forcast.data.mapper.data;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.MaximumEntity;
import me.mfathy.weather.forcast.domain.model.Maximum;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class MaximumDataMapper implements EntityMapper<Maximum, MaximumEntity> {
    @Override
    public Maximum transform(MaximumEntity domain) {
        return new Maximum.Builder()
                .withUnit(domain.getUnit())
                .withUnitType(domain.getUnitType())
                .withValue(domain.getValue())
                .build();
    }
}
