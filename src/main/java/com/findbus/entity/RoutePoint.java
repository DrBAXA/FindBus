package com.findbus.entity;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "route_points")
public class RoutePoint {
    @Id
    @GeneratedValue
    private int id;
    @Embedded
    private Location location;
    @Column
    private boolean isStation;
    @ManyToOne
    private Route route;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isStation() {
        return isStation;
    }

    public void setStation(boolean isStation) {
        this.isStation = isStation;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
