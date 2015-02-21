package com.findbus.core;

import com.findbus.dao.LocationDao;
import com.findbus.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@Component
@Scope("prototype")
public class BusLocationsArray {
    @Autowired
    LocationDao locationDao;

    private int activeSize=5;//TODO load from properties
    private int dbBuffer=60;//TODO load from properties
    private final List<Location> locations = new LinkedList<>();

    public BusLocationsArray(int activeSize) {
        this.activeSize = activeSize;
    }

    void put(Location location){
        synchronized (locations){
            locations.add(0,location);
            if(locations.size() > (activeSize + dbBuffer)){
                storeToDB();
            }
        }
    }

    Location getAverageLocation(){
        Location result = new Location();
        double sumLat = 0;
        double sumLng = 0;

        synchronized (locations) {
            int last = locations.size() < activeSize ? locations.size() : activeSize;
            for (Location location : locations.subList(0,last)) {
                sumLat += location.getLat();
                sumLng += location.getLng();
            }
        }

        result.setLat(sumLat/ activeSize);
        result.setLng(sumLng/ activeSize);

        return result;
    }

    private void storeToDB(){
        List<Location> storeList = new ArrayList<>(dbBuffer);
        synchronized (locations) {
            storeList.addAll(locations.subList(activeSize, locations.size()));
            locations.removeAll(storeList);
        }
        //TODO make this action in one request
        for(Location location : storeList){
            locationDao.save(location);
        }
    }
}
