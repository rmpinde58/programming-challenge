package de.exxcellent.challenge;

import java.io.IOException;
import java.util.*;


public class FootballList implements ListOfObjects{
    private String teamWithMinimumSpread;
    @Override
    public void createListOfObjects(ArrayList<Map<String, String>> br) throws IOException {
        List<Football> footballList = new ArrayList<>();
        for(Map<String, String> hmap : br){
            // create weather object to store values
            Football footballObj = new Football();

            // add values from csv to weather object
            footballObj.setTeam(hmap.get("Team"));
            footballObj.setGoals(hmap.get("Goals"));
            footballObj.setGoalsAllowed(hmap.get("Goals Allowed"));
            // adding weather objects to a list
            footballList.add(footballObj);
        }

        //call to hashmap sorting function
        setTeamWithMinimumSpread(footballServiceWithMinimumSpread(footballList));
    }
    public String footballServiceWithMinimumSpread(List<Football> footballList){
        Map<String, Integer> temp = new HashMap<>();
        for(Football f : footballList){
            var max = f.getGoals();
            var min = f.getGoalsAllowed();
            temp.put(f.getTeam(), (Integer.parseInt(max) - Integer.parseInt(min)));
        }

        Map<String, Integer> hm1 = sortByValue(temp);

        return hm1.keySet().stream().findFirst().get();
    }

    public Map<String, Integer>
    sortByValue(Map<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list
                = new LinkedList<Map.Entry<String, Integer> >(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp
                = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public String getTeamWithMinimumSpread() {
        return teamWithMinimumSpread;
    }

    public void setTeamWithMinimumSpread(String teamWithMinimumSpread) {
        this.teamWithMinimumSpread = teamWithMinimumSpread;
    }
}
