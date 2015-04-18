package com.findbus.websocket;

import com.findbus.entity.BusLocation;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.websocket.DecodeException;
import java.io.IOException;

@Service
public class BusLocationDecoder{
    public BusLocation decode(String s) throws DecodeException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            BusLocation busLocation = objectMapper.readValue(s, BusLocation.class);
            return busLocation;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
