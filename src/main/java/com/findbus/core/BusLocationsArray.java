package com.findbus.core;

import com.findbus.dao.LocationDao;
import com.findbus.entity.BusLocation;
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

    private int activeSize=1;//TODO load from properties
    private int dbBuffer=10;//TODO load from properties
    private final List<BusLocation> busLocations = new LinkedList<>();

    public BusLocationsArray() {

    }

    void put(BusLocation busLocation){
        synchronized (busLocations){
            busLocations.add(0, busLocation);
            if(busLocations.size() > (activeSize + dbBuffer)){
                storeToDB();
            }
        }
    }

    BusLocation getAverageLocation(){
        BusLocation result = new BusLocation();
        double sumLat = 0;
        double sumLng = 0;

        synchronized (busLocations) {
            int last = busLocations.size() < activeSize ? busLocations.size() : activeSize;
            for (BusLocation busLocation : busLocations.subList(0,last)) {
                sumLat += busLocation.getCoordinate().getLat();
                sumLng += busLocation.getCoordinate().getLng();
            }
        }

        result.getCoordinate().setLat(sumLat / activeSize);
        result.getCoordinate().setLng(sumLng/ activeSize);

        return result;
    }

    private void storeToDB(){
        List<BusLocation> storeList = new ArrayList<>(dbBuffer);
        synchronized (busLocations) {
            storeList.addAll(busLocations.subList(activeSize, busLocations.size()));
            busLocations.removeAll(storeList);
        }
        //TODO make this action in one request
        for(BusLocation busLocation : storeList){
            locationDao.save(busLocation);
        }
    }
}
