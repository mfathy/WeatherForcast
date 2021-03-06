package me.mfathy.weather.forcast.domain.test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class DataFactory {
    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    static int randomInt(){
        return ThreadLocalRandom.current().nextInt();
    }
}
