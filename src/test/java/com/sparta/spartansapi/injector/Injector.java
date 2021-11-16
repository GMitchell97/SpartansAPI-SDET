package com.sparta.spartansapi.injector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.gson.JsonObject;
import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.ErrorDTO;
import com.sparta.spartansapi.dto.IResponse;
import com.sparta.spartansapi.dto.ListOfSpartanDTO;
import com.sparta.spartansapi.dto.SpartanDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Injector {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static IResponse injectDTO(CallManager callManager) {
        try {
            JsonNode jsonObject = objectMapper.readTree(callManager.getJson());
            if (jsonObject.getNodeType() == JsonNodeType.ARRAY) {
                return getListOfSpartans(jsonObject);
            } else {
                return getError(jsonObject);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ListOfSpartanDTO getListOfSpartans(JsonNode jsonNode) throws JsonProcessingException {
        ListOfSpartanDTO listOfSpartanDTO = new ListOfSpartanDTO();
        for (JsonNode spartan: jsonNode) {
            listOfSpartanDTO.addSpartan(objectMapper.readValue(spartan.asText(), SpartanDTO.class));
        }
        return listOfSpartanDTO;
    }

    private static ErrorDTO getError(JsonNode jsonNode) throws JsonProcessingException {
        return objectMapper.readValue(jsonNode.asText(), ErrorDTO.class);
    }
}

