package com.company;

import com.company.entity.Coordinates;

import java.util.ArrayList;

/**
 * Created by maks on 21.02.2015.
 */
public class TempMain {
    private static String file ="src/route1.txt";
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

            psevdoSend(firstC);
        }

    }
    public static void psevdoSend(Coordinates coordinates){
        System.out.println(coordinates);

    }
}
