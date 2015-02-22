package com.findbus.core;

import com.findbus.entity.BusLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 *
 */

@Component
public class BusesLocationProvider {

    @Autowired
    ApplicationContext context;

    private HashMap<Integer, BusLocationsArray> busesLocationMap;

    public BusesLocationProvider() {
        busesLocationMap = new HashMap<>();
    }

    public void register(int id){
        if(! busesLocationMap.containsKey(id)){
            busesLocationMap.put(id, (BusLocationsArray)context.getBean("busLocationsArray"));
        }
    }

    public void registerAll(Iterable<Integer> busesIds){
        for(int id : busesIds){
            register(id);
        }
    }

    public void putLocation(int id, BusLocation busLocation){
        if(busesLocationMap.containsKey(id)){
            busesLocationMap.get(id).put(busLocation);
        }
    }

    public BusLocation getLocation(int id){
        if(busesLocationMap.containsKey(id)){
            return busesLocationMap.get(id).getAverageLocation();
        }else{
            return null;
        }
    }

    public boolean checkExist(int id){
        return busesLocationMap.containsKey(id);
    }

}
