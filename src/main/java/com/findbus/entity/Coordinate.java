package com.findbus.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 */
@Embeddable
public class Coordinate {
    @Column
    private double lat;
    @Column
    private double lng;

    public Coordinate() {
    }

    public Coordinate(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
