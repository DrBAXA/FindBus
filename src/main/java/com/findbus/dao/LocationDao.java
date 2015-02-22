package com.findbus.dao;

import com.findbus.entity.BusLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends CrudRepository<BusLocation, Integer>{
}
