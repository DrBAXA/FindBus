package com.findbus.service;

import com.findbus.dao.RouteDAO;
import com.findbus.entity.GooglesCoordinate;
import com.findbus.entity.Route;
import com.findbus.entity.RoutePoint;
import com.findbus.entity.SnappedPoints;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DrBAX_000 on 26.04.2015.
 */
@Service
public class CoordinateParser {
    @Autowired
    RouteDAO routeDAO;
    final String  url = "https://roads.googleapis.com/v1/snapToRoads?interpolate=true&key=AIzaSyADYWIGFSnn3DHlJblK0hntz5KQiwbD0hk&path=";
    File file;
    Route route;


    public void readFile(){
        String url =this.url;
        String s = null;
        try{
            int count =0;
            BufferedReader bf = new BufferedReader(new FileReader(file));
            while ((s = bf.readLine())!=null){
                url +=s;
                if(count++ ==99){
                    sendToGoogle(url);
                    count=0;
                    url = this.url;
                }
            }
            sendToGoogle(url);
        }catch(Exception e){
            e.getMessage();
        }

    }
    public void sendToGoogle(String url) throws IOException {
        url=url.substring(0,url.length()-3);
//         doc = Jsoup.connect(url).get();
        String d=Jsoup.connect(url).ignoreContentType(true).execute().body();
        ObjectMapper mapper = new ObjectMapper();
        SnappedPoints snappedPoints =mapper.readValue(d, SnappedPoints.class);

//        coordinates.addAll(snappedPoints.getSnappedPoints());
        route.getRouteList().addAll(tranlator(snappedPoints.getSnappedPoints()));
    }
    private List<RoutePoint> tranlator(List<GooglesCoordinate> coordinates){
        List<RoutePoint> res = new ArrayList<>();

        for (GooglesCoordinate current: coordinates){
            RoutePoint temp = new RoutePoint();
            temp.setRoute(route);
            temp.setLocation(current.getLocation());
            res.add(temp);
        }
        return res;

    }
    public void parseRoute(String routeName)  {
        try {
            String filePath = new ClassPathResource("routeFiles").getURI().getPath() + "/route23.txt";
            file = new File(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        route = new Route();
        route.setName(routeName);
        readFile();
        routeDAO.save(route);

        System.out.println(route.getRouteList());
    }

}
