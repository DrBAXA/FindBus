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
    private Coordinate coordinate;
    @Column
    private boolean isStation;
    @Column
    private int orderValue;
    @ManyToOne
    private Route route;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isStation() {
        return isStation;
    }

    public void setStation(boolean isStation) {
        this.isStation = isStation;
    }

    public int getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(int orderValue) {
        this.orderValue = orderValue;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
