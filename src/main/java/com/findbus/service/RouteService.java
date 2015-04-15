package com.findbus.service;

import com.findbus.entity.Coordinate;
import com.findbus.entity.Route;
import com.findbus.entity.RoutePoint;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class RouteService {

    private final static Logger logger = Logger.getLogger(RouteService.class);

    private Route loadFromXml(InputStream xmlData){
        try {
            Document routeXml = loadStream(xmlData);
            Route route = new Route();
            route.setName(parseName(routeXml));
            route.setDescription(parseDescription(routeXml));
            route.setRouteList(parsePoints(routeXml));
            return route;
        }catch (IOException | IndexOutOfBoundsException | IllegalArgumentException parsingException){
            return null;
        }
    }

    private Document loadStream(InputStream xmlData) throws IOException {
        Document xml = null;
        try {
            logger.debug("Try to load DOM from stream");
            xml = Jsoup.parse(xmlData, "utf8", "");
            logger.debug("DOM was loaded");
        } catch (IOException ioe) {
            logger.error("Loading DOM failed");
            throw ioe;
        }
        return xml;
    }

    private String parseName(Document xml){
        try {
            Element routeElement = xml.getElementsByTag("Route").get(0);
            String name = null;
            if(routeElement.hasAttr("name")){
                name = routeElement.attr("name");
            }else {
                name = "Route_" + xml.hashCode();
                logger.warn("Route name isn't given. Will use name Route_" + name);
            }
            return name;
        } catch (IndexOutOfBoundsException ioobe) {
            logger.error("XML file has unsupported schema. Root element must be <route>.");
            throw ioobe;
        }
    }

    private String parseDescription(Document xml){
        if(! xml.getElementsByTag("descriptin").isEmpty()) {
            Element description = xml.getElementsByTag("description").get(0);
            return description.text();
        }else {
            logger.warn("Route description not presented");
            return null;
        }
    }

    private List<RoutePoint> parsePoints(Document xml){
        if(xml.getElementsByTag("GpsData").size() < 10){
            logger.error("File hasn't enough points for representing real route ");
            throw new IllegalArgumentException();
        }
        List<RoutePoint> routePoints = new ArrayList<>(xml.getElementsByTag("GpsData").size());
        int pointIndex = 0;
        for (Element element : xml.getElementsByTag("GpsData")){
            RoutePoint point = parseRoutePoint(element);
            point.setOrderValue(pointIndex++);
            if(point != null)
                routePoints.add(point);
        }
        return routePoints;
    }

    private RoutePoint parseRoutePoint(Element element){
        RoutePoint point = new RoutePoint();
        if(element.hasAttr("latitude") && element.hasAttr("longitude")){
            double lat = Double.parseDouble(element.attr("latitude"));
            double lng = Double.parseDouble(element.attr("longitude"));
            point.setCoordinate(new Coordinate(lat, lng));
        }else {
            logger.warn("Point element is invalid: " + element.text());
            return null;
        }
        if(element.hasAttr("isStation")){
            boolean isStation = Boolean.parseBoolean(element.attr("isStation"));
            point.setStation(isStation);
        }
        return point;
    }
}
