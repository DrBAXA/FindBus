package com.company.entity;

/**
 * Created by maks on 21.02.2015.
 */
public class Coordinates {
    private String longitude;
    private String latitude;
    private String time;

    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Coordinates(String longitude, String latitude, String time) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
    }


}
