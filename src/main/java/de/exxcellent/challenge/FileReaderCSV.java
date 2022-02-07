package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileReaderCSV implements DataReader{
    private ListOfObjects currentListOfObjects;
    private BufferedReader br;

    @Override
    public void read(String path) throws IOException {
        ArrayList list = new ArrayList();
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            boolean isFirst = true;
            String[] columnList;
            columnList = new String[0];
            while ((line = br.readLine()) != null) {
                // split on comma(',')
                String[] csvFile = line.split(",");
                if (isFirst){
                    isFirst = false;
                    columnList = csvFile;
                }else{
                    Map<String, String> mMap = new HashMap();
                    for(int i = 0; i < columnList.length; i++){
                        mMap.put(columnList[i], csvFile[i]);
                    }
                    list.add(mMap);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        createListOfObjects(list);
    }

    public void createListOfObjects(ArrayList br){
        try {
            currentListOfObjects.createListOfObjects(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ListOfObjects getCurrentListOfObjects() {
        return currentListOfObjects;
    }

    public void setCurrentListOfObjects(ListOfObjects currentListOfObjects) {
        this.currentListOfObjects = currentListOfObjects;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }
}
