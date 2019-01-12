package me.mfathy.weather.forcast.data.mapper;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public interface EntityMapper<E, D> {
    E transform(D domain);
}
