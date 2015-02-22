package com.findbus.service;

import com.findbus.core.BusesLocationProvider;
import com.findbus.entity.BusLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service that gather information about buses location
 * and store this information to DB and
 */

@Service
public class GatheringService {

    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass().getName());

    @Autowired
    BusesLocationProvider busesLocationProvider;

    public void receiveData(int busId, BusLocation busLocation){
        if(! busesLocationProvider.checkExist(busId)){
            busesLocationProvider.register(busId);
        }
        busesLocationProvider.putLocation(busId, busLocation);
    }
}
