package me.mfathy.weather.forcast.data.mapper.data;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.TemperatureEntity;
import me.mfathy.weather.forcast.domain.model.Temperature;

import javax.inject.Inject;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class TemperatureDataMapper implements EntityMapper<Temperature, TemperatureEntity> {

    private MaximumDataMapper maximumDataMapper;
    private MinimumDataMapper minimumDataMapper;

    @Inject
    public TemperatureDataMapper(MaximumDataMapper maximumDataMapper, MinimumDataMapper minimumDataMapper) {
        this.maximumDataMapper = maximumDataMapper;
        this.minimumDataMapper = minimumDataMapper;
    }

    @Override
    public Temperature transform(TemperatureEntity domain) {
        return new Temperature.Builder()
                .withMaximum(maximumDataMapper.transform(domain.getMaximum()))
                .withMinimum(minimumDataMapper.transform(domain.getMinimum()))
                .build();
    }
}
