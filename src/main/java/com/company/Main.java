package com.company;

import com.company.entity.Coordinates;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    private final static String USER_AGENT = "Mozilla/5.0";

    private static String file ="src/main/java/route1.txt";
    public static void main(String[] args) {
        ReadCoordinats readCoordinats = new ReadCoordinats();
        ArrayList<Coordinates> coordinateses = readCoordinats.read(file);
        int j =1;
        Coordinates firstC;
        Coordinates secondC;

        for(int i=0;i<coordinateses.size()-1;i++,j++){
            firstC = coordinateses.get(i);
            secondC = coordinateses.get(j);
            Long time = Long.parseLong(secondC.getTime()) - Long.parseLong(firstC.getTime());
            try {
                Thread.sleep(time*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( firstC );
            sentGet(firstC.getLatitude(), firstC.getLongitude(), firstC.getTime());

        }

    }

//    public static void main(String[] args) {
//	// write your code here
//
//        String lat = "454";
//        String lng = "678";
//        String time = "123456";
//        sentGet(lat,lng,time);
//    }
    public static void sentGet(String lat, String lng, String time){
        try {
            URL url = new URL("http://localhost:8080/gathering/23?lat="+lat+"&lng="+lng+"&time="+time);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            int responceCode = connection.getResponseCode();
            System.out.println(responceCode);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
