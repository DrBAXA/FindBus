package com.findbus.websocket;

import com.findbus.entity.BusLocation;
import org.codehaus.jackson.map.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;

/**
 * Created by DrBAX_000 on 15.03.2015.
 */
public class BusLocationDecoder implements Decoder.Text<BusLocation> {
    @Override
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

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
