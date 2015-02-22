package com.findbus.service;

import com.findbus.entity.BusLocation;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 *
 */
@Service
public class LocationDBService {
    @PersistenceContext
    private EntityManager entityManager;

    public void storeLocations(int busId,Collection<BusLocation> busLocations){
        for(BusLocation busLocation : busLocations){
            busLocation.setBusId(busId);
            entityManager.persist(busLocation);
        }
    }
}
