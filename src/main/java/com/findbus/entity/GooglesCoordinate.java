package com.findbus.entity;

/**
 * Created by DrBAX_000 on 26.04.2015.
 */
public class GooglesCoordinate {
    private Location location;
    private String placeId;
    private int originalIndex;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }

    public void setOriginalIndex(int originalIndex) {
        this.originalIndex = originalIndex;
    }

    @Override
    public String toString() {
        return "GooglesCoordinate{\n" +
                "location=" + location +
                ", placeId='" + placeId + '\'' +
                ", originalIndex=" + originalIndex +
                "}\n";
    }
}
