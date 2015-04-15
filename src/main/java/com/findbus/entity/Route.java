package com.findbus.entity;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Entity
@Table(name="routes")
public class Route {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @OneToMany(mappedBy = "route")
    @OrderBy("orderValue")
    private List<RoutePoint> routeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RoutePoint> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<RoutePoint> routeList) {
        this.routeList = routeList;
    }
}
