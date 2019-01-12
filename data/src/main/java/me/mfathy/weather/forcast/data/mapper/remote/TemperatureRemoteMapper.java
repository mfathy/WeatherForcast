package me.mfathy.weather.forcast.data.mapper.remote;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.mapper.data.MaximumDataMapper;
import me.mfathy.weather.forcast.data.mapper.data.MinimumDataMapper;
import me.mfathy.weather.forcast.data.model.TemperatureEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkTemperature;
import me.mfathy.weather.forcast.domain.model.Temperature;

import javax.inject.Inject;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class TemperatureRemoteMapper implements EntityMapper<TemperatureEntity, NetworkTemperature> {

    private MaximumRemoteMapper maximumDataMapper;
    private MinimumRemoteMapper minimumDataMapper;

    @Inject public TemperatureRemoteMapper(MaximumRemoteMapper maximumDataMapper, MinimumRemoteMapper minimumDataMapper) {
        this.maximumDataMapper = maximumDataMapper;
        this.minimumDataMapper = minimumDataMapper;
    }

    @Override
    public TemperatureEntity transform(NetworkTemperature domain) {
        return new TemperatureEntity.Builder()
                .withMaximum(maximumDataMapper.transform(domain.getNetworkMaximum()))
                .withMinimum(minimumDataMapper.transform(domain.getNetworkMinimum()))
                .build();
    }
}
