package me.mfathy.weather.forcast.data.mapper.remote;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.MaximumEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkMaximum;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class MaximumRemoteMapper implements EntityMapper<MaximumEntity, NetworkMaximum> {
    @Override
    public MaximumEntity transform(NetworkMaximum domain) {
        return new MaximumEntity.Builder()
                .withUnit(domain.getUnit())
                .withUnitType(domain.getUnitType())
                .withValue(Double.valueOf(domain.getValue()))
                .build();
    }
}
