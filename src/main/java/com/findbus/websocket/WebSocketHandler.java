package com.findbus.websocket;

import com.findbus.service.GatheringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

@Component
public class WebSocketHandler extends  Endpoint{

    @Autowired
    GatheringService gatheringService;
    @Autowired
    BusLocationEncoder busLocationEncoder;


    @Override
    public void onOpen(Session session, EndpointConfig config) {

        System.out.println("websocket connection opened: " + session.getId());

        CoordinateHandler handler = new CoordinateHandler(session);
        handler.setEncoder(busLocationEncoder);
        handler.setGatheringService(gatheringService);
        session.addMessageHandler(handler);
    }
}

