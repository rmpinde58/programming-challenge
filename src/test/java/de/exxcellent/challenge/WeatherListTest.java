package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WeatherListTest {
    private Map<Integer, Integer> map;
    private WeatherList weatherList;
    private Weather weather1;
    private Weather weather2;
    private Weather weather3;
    private List<Weather> weatherObjList;

    @BeforeEach
    void setUp() {
        weatherList = new WeatherList();
        map = new HashMap<>();
        map.put(1,27);
        map.put(2,22);
        map.put(3,12);
        map.put(4,30);
        weatherObjList = new ArrayList<>();
        weather1 = new Weather();
        weather1.setDay("1");
        weather1.setMxT("88");
        weather1.setMnT("68");
        weather2 = new Weather();
        weather2.setDay("2");
        weather2.setMxT("90");
        weather2.setMnT("45");
        weather3 = new Weather();
        weather3.setDay("3");
        weather3.setMxT("80");
        weather3.setMnT("75");
        weatherObjList.add(weather1);
        weatherObjList.add(weather2);
        weatherObjList.add(weather3);
    }

    @Test
    void weatherServiceReturnsMinimumSpread() {
        int value = weatherList.weatherServiceReturnsMinimumSpread(weatherObjList);
        assertEquals(3, value);
    }

    @Test
    void sortByValue() {
        Map<Integer, Integer> temp = weatherList.sortByValue(map);
        assertEquals(3, temp.keySet().stream().findFirst().get());
    }
}