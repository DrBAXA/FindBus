package com.findbus.entity;

/**
 * Class that represent one piece information received from GPS
 */
public class Location {
    private double lat;
    private double lng;
    private int timestamp;

    public Location() {
    }

    public Location(double lat, double lng, int timestamp) {
        this.lat = lat;
        this.lng = lng;
        this.timestamp = timestamp;
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
