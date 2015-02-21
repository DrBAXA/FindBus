package com.findbus.core;

import com.findbus.entity.Location;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class BusLocationsArray {
    private int size;
    private List<Location> locations = new LinkedList<>();

    public void put(Location location){
        synchronized (locations){
            locations.add(0,location);
            if(locations.size() > size){
                locations.remove(size);
            }
        }
    }

    public Location getAverageLocation(){
        Location result = new Location();
        double sumLat = 0;
        double sumLng = 0;

        synchronized (locations) {
            for (Location location : locations) {
                sumLat += location.getLat();
                sumLng += location.getLng();
            }
        }

        result.setLat(sumLat/size);
        result.setLng(sumLng/size);

        return result;
    }
}
