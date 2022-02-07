package de.exxcellent.challenge;

import java.io.IOException;

public interface DataReader {
    void read(String path) throws IOException;
    void setCurrentListOfObjects(ListOfObjects currentListOfObjects);
    }
