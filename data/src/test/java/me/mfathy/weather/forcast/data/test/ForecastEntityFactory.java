package me.mfathy.weather.forcast.data.test;

import me.mfathy.weather.forcast.data.model.*;
import me.mfathy.weather.forcast.data.store.remote.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class ForecastEntityFactory {

    public static ForecastEntity makeForecast() {
        List<DailyForecastEntity> dailyForecasts = new ArrayList<>();
        MaximumEntity maxTemp = new MaximumEntity.Builder()
                .withUnit(DataEntityFactory.randomString())
                .withUnitType((long) DataEntityFactory.randomInt())
                .withValue((double) DataEntityFactory.randomInt())
                .build();
        MinimumEntity mimTemp = new MinimumEntity.Builder()
                .withUnit(DataEntityFactory.randomString())
                .withUnitType((long) DataEntityFactory.randomInt())
                .withValue((double) DataEntityFactory.randomInt())
                .build();
        TemperatureEntity temp = new TemperatureEntity.Builder()
                .withMinimum(mimTemp)
                .withMaximum(maxTemp)
                .build();
        DailyForecastEntity dailyForecast = new DailyForecastEntity.Builder()
                .withDay(DataEntityFactory.randomString())
                .withNight(DataEntityFactory.randomString())
                .withTemperature(temp)
                .build();
        dailyForecasts.add(dailyForecast);
        return new ForecastEntity.Builder()
                .withHeadline(DataEntityFactory.randomString())
                .withDailyForecasts(dailyForecasts)
                .build();
    }

    public static NetworkForecast makeNetworkForecast() {
        NetworkForecast networkForecast = new NetworkForecast();
        NetworkHeadline networkHeadline = new NetworkHeadline();
        networkHeadline.setText(DataEntityFactory.randomString());
        networkForecast.setNetworkHeadline(new NetworkHeadline());
        List<NetworkDailyForecast> networkDailyForecasts = new ArrayList<>();
        NetworkDailyForecast networkDailyForecast = new NetworkDailyForecast();
        NetworkDay day = new NetworkDay();
        day.setIcon(1L);
        day.setIconPhrase("");
        NetworkNight night = new NetworkNight();
        night.setIcon(1L);
        night.setIconPhrase("");
        networkDailyForecast.setNetworkDay(day);
        networkDailyForecast.setNetworkNight(night);
        NetworkTemperature netTemp = new NetworkTemperature();
        NetworkMaximum maxTemp = new NetworkMaximum();
        maxTemp.setUnit("");
        maxTemp.setUnitType(1L);
        maxTemp.setValue(1L);

        NetworkMinimum mimTemp = new NetworkMinimum();
        mimTemp.setUnit("");
        mimTemp.setUnitType(1L);
        mimTemp.setValue(1L);
        netTemp.setNetworkMaximum(maxTemp);
        netTemp.setNetworkMinimum(mimTemp);

        networkDailyForecast.setNetworkTemperature(netTemp);
        networkDailyForecasts.add(networkDailyForecast);
        networkForecast.setNetworkDailyForecasts(networkDailyForecasts);
        return networkForecast;
    }
}
