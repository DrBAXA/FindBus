package com.findbus.service;

import com.findbus.entity.Location;
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

    public void storeLocations(int busId,Collection<Location> locations){
        for(Location location : locations){
            location.setBusId(busId);
            entityManager.persist(location);
        }
    }
}
