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

    public static IResponse injectDTO(CallManager callManager) throws JsonProcessingException {
        JsonNode jsonObject = objectMapper.readTree(callManager.getJson());
        if (jsonObject.getNodeType() == JsonNodeType.ARRAY) {
            return getListOfSpartans(jsonObject);
        } else if (jsonObject.has("id")){
            return getSpartan(jsonObject);
        } else if (jsonObject.has("error")) {
            return getError(jsonObject);
        }
        return null;
    }

    private static ListOfSpartanDTO getListOfSpartans(JsonNode jsonNode) throws JsonProcessingException {
        ListOfSpartanDTO listOfSpartanDTO = new ListOfSpartanDTO();
        for (JsonNode spartan : jsonNode) {
            SpartanDTO spartanDTO = objectMapper.treeToValue(spartan, SpartanDTO.class);
            listOfSpartanDTO.addSpartan(spartanDTO);
        }
        return listOfSpartanDTO;
    }

    private static ErrorDTO getError(JsonNode jsonNode) throws JsonProcessingException {
        return objectMapper.treeToValue(jsonNode, ErrorDTO.class);
    }

    private static SpartanDTO getSpartan(JsonNode jsonNode) throws JsonProcessingException {
        return objectMapper.treeToValue(jsonNode, SpartanDTO.class);
    }
}

