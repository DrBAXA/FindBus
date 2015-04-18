package com.findbus.websocket;

import com.findbus.entity.BusLocation;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.websocket.EncodeException;
import java.io.IOException;

@Service
public class BusLocationEncoder {
    public String encode(BusLocation object) throws EncodeException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
