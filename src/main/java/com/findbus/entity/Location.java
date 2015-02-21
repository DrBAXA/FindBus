package com.findbus.entity;

import javax.persistence.*;

/**
 * Class that represent one piece information received from GPS
 */
@Entity
@Table(name = "stat_points")
public class Location {
    @Id
    @GeneratedValue
    int id;
    @Column
    int busId;
    @Column
    private double lat;
    @Column
    private double lng;
    @Column
    private int timestamp;

    public Location() {
    }

    public Location(double lat, double lng, int timestamp) {
        this.lat = lat;
        this.lng = lng;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
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

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
