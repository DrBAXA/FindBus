package com.findbus.websocket;

import com.findbus.entity.BusLocation;
import org.codehaus.jackson.map.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;

/**
 * Created by DrBAX_000 on 15.03.2015.
 */
public class BusLocationEncoder implements Encoder.Text<BusLocation> {
    @Override
    public String encode(BusLocation object) throws EncodeException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
