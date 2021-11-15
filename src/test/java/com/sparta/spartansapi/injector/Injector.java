package com.sparta.spartansapi.injector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.SpartanDTO;

import java.io.IOException;
import java.net.URL;

public class Injector {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static SpartanDTO injectSpartanDTO(ConnectionManager connectionManager) {
        SpartanDTO spartanDTO =  new SpartanDTO();
        try {
            spartanDTO = objectMapper.readValue(connectionManager.getJSON(), SpartanDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return spartanDTO;
    }

}
