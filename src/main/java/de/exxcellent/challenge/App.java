package de.exxcellent.challenge;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws IOException {

        // Your preparation code …
        DataReader fileReader = new FileReaderCSV();
        String path = "C:\\Users\\puroh\\IdeaProjects\\prog-challenge\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";
        var weatherList = new WeatherList();
        fileReader.setCurrentListOfObjects(weatherList);
        fileReader.read(path);

        int dayWithSmallestTempSpread = weatherList.getDayWithMinimumWeatherSpread();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        path = "C:\\Users\\puroh\\IdeaProjects\\prog-challenge\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv";

        var footballList = new FootballList();
        fileReader.setCurrentListOfObjects(footballList);
        fileReader.read(path);

        String teamWithSmallestGoalSpread = footballList.getTeamWithMinimumSpread(); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
