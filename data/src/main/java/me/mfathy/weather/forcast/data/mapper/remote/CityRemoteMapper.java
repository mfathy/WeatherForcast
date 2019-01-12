package me.mfathy.weather.forcast.data.mapper.remote;

import me.mfathy.weather.forcast.data.mapper.EntityMapper;
import me.mfathy.weather.forcast.data.model.CityEntity;
import me.mfathy.weather.forcast.data.store.remote.model.NetworkCity;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class CityRemoteMapper implements EntityMapper<CityEntity, NetworkCity> {
    @Override
    public CityEntity transform(NetworkCity domain) {
        return new CityEntity.Builder()
                .withVersion(domain.getVersion())
                .withType(domain.getType())
                .withRank(domain.getRank())
                .withLocalizedName(domain.getLocalizedName())
                .withKey(domain.getKey())
                .build();
    }
}
