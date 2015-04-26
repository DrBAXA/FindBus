package com.findbus.entity;

import javax.persistence.*;

/**
 * Class that represent one piece information received from GPS
 */
@Entity
@Table(name = "stat_points")
public class BusLocation {
    @Id
    @GeneratedValue
    int id;
    @Column
    int busId;
    @Embedded
    private Location location;
    @Column
    private int timestamp;

    public BusLocation() {
        this.location = new Location();
    }

    public BusLocation(double lat, double lng, int timestamp) {
        this.location = new Location(lat,lng);
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
