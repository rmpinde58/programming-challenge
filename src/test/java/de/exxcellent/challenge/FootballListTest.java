package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FootballListTest {
    private Map<String, Integer> map;
    private FootballList footballList;
    private Football football1;
    private Football football2;
    private Football football3;
    private List<Football> footballObjList;

    @BeforeEach
    void setUp() {
        footballList = new FootballList();
        map = new HashMap<>();
        map.put("1",27);
        map.put("2",22);
        map.put("3",12);
        map.put("4",30);
        footballObjList = new ArrayList<>();
        football1 = new Football();
        football1.setTeam("Arsenal");
        football1.setGoals("88");
        football1.setGoalsAllowed("68");
        football2 = new Football();
        football2.setTeam("Manchester");
        football2.setGoals("80");
        football2.setGoalsAllowed("60");
        football3 = new Football();
        football3.setTeam("Bayern");
        football3.setGoals("70");
        football3.setGoalsAllowed("60");
        footballObjList.add(football1);
        footballObjList.add(football2);
        footballObjList.add(football3);
    }

    @Test
    void footballServiceWithMinimumSpread() {
        String value = footballList.footballServiceWithMinimumSpread(footballObjList);
        assertEquals("Bayern", value);
    }

    @Test
    void sortByValue() {
        Map<String, Integer> temp = footballList.sortByValue(map);
        assertEquals("3", temp.keySet().stream().findFirst().get());
    }
}