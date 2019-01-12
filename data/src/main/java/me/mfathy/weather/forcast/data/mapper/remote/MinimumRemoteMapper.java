package me.mfathy.weather.forcast.data.mapper.remote;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.MinimumEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkMinimum;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class MinimumRemoteMapper implements EntityMapper<MinimumEntity, NetworkMinimum> {
    @Override
    public MinimumEntity transform(NetworkMinimum domain) {
        return new MinimumEntity.Builder()
                .withUnit(domain.getUnit())
                .withUnitType(domain.getUnitType())
                .withValue(Double.valueOf(domain.getValue()))
                .build();
    }
}
