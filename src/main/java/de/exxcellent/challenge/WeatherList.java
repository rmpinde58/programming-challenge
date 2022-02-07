package de.exxcellent.challenge;

import java.io.IOException;
import java.util.*;

public class WeatherList implements ListOfObjects {
    private int dayWithMinimumWeatherSpread;
    /*
        Method to generate list of objects per row in weather.csv
     */
    @Override
    public void createListOfObjects(ArrayList<Map<String, String>> br) throws IOException {
        List<Weather> weatherList = new ArrayList<>();
        for(Map<String, String> hmap : br){
            // create weather object to store values
            Weather weatherObj = new Weather();
            // add values from csv to weather object
            weatherObj.setDay(hmap.get("Day"));
            weatherObj.setMxT(hmap.get("MxT"));
            weatherObj.setMnT(hmap.get("MnT"));
            // adding weather objects to a list

            weatherList.add(weatherObj);
        }
        //call to hashmap sorting function
        setDayWithMinimumWeatherSpread(weatherServiceReturnsMinimumSpread(weatherList));
    }


    /*
        Method to store weatherList objects into a HashMap
        And it returns key of first KeyValue Pair in sorted HashMap.
     */
    public int weatherServiceReturnsMinimumSpread(List<Weather> weatherList){
        Map<Integer, Integer> temp = new HashMap<>();
        for(Weather w : weatherList){
            var tag = Integer.parseInt(w.getDay());
            var max = w.getMxT();
            var min = w.getMnT();
            temp.put(tag, (Integer.parseInt(max) - Integer.parseInt(min)));
        }
        Map<Integer, Integer> hm1 = sortByValue(temp);

        return hm1.keySet().stream().findFirst().get();
    }

    /*
        Method to sort HashMap
     */
    public Map<Integer, Integer>
    sortByValue(Map<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list
                = new LinkedList<Map.Entry<Integer, Integer> >(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp
                = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public int getDayWithMinimumWeatherSpread() {
        return dayWithMinimumWeatherSpread;
    }

    public void setDayWithMinimumWeatherSpread(int dayWithMinimumWeatherSpread) {
        this.dayWithMinimumWeatherSpread = dayWithMinimumWeatherSpread;
    }
}
