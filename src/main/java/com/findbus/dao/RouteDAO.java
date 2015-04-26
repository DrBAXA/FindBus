package com.findbus.dao;

import com.findbus.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DrBAX_000 on 26.04.2015.
 */
@Repository
public interface RouteDAO extends CrudRepository<Route, Integer> {
}
