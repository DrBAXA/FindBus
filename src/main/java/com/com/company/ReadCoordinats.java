package com.company;

import com.company.entity.Coordinates;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class read file of coordinates, parse , and put there  in ArrayList
 */
public class ReadCoordinats {
    private ArrayList<Coordinates> coordinatesList = new ArrayList<Coordinates>();
//    private String file ="src/route1.txt";

    public ArrayList<Coordinates> read(String file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(file)));
            String s;

            while ((s = bufferedReader.readLine())!=null){
                coordinatesList.add(tuCoordinates(s));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  coordinatesList;

    }
    /**
     * parse coordinate
     * */
    private  Coordinates tuCoordinates(String coordinate){
        String[] lat = coordinate.split(";");
        Coordinates coordinates = new Coordinates(lat[0], lat[1], lat[2]);
       // System.out.println(coordinates);
        return coordinates;
    }
}
