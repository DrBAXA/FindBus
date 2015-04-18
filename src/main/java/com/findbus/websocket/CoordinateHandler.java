package com.findbus.websocket;

import com.findbus.service.GatheringService;

import javax.websocket.EncodeException;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;


public class CoordinateHandler implements MessageHandler.Whole<String> {

    private GatheringService gatheringService;
    private BusLocationEncoder encoder;

    private final Session session;


    public GatheringService getGatheringService() {
        return gatheringService;
    }

    public void setGatheringService(GatheringService gatheringService) {
        this.gatheringService = gatheringService;
    }

    public BusLocationEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(BusLocationEncoder encoder) {
        this.encoder = encoder;
    }

    public CoordinateHandler(Session session) {
        this.session = session;

    }

    @Override
    public void onMessage(String message) {

            // Print the client message for testing purposes
        System.out.println("Received: " + message);

            // Send the first message to the client
        try {
            for (int i = 0; i < 10; i++) {
                session.getBasicRemote().sendText(encoder.encode(gatheringService.getLocation(23)));
                Thread.sleep(2000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
