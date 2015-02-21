package com.findbus.dao;

import com.findbus.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends CrudRepository<Location, Integer>{
}
