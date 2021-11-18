package com.sparta.spartansapi.injector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.gson.JsonObject;
import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Injector {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static IResponse injectDTO(CallManager callManager) throws JsonProcessingException {
        JsonNode jsonObject = objectMapper.readTree(callManager.getJson());
        if (jsonObject.has("results")) {
            return getListOfDTO(jsonObject);
        } else if (jsonObject.has("id")){
            return getSpartan(jsonObject);
        } else if (jsonObject.has("error")) {
            return getError(jsonObject);
        }
        return null;
    }

    private static IResponse getListOfDTO(JsonNode jsonNode) throws JsonProcessingException {
        if (jsonNode.get("results").has("email")) {
            return objectMapper.treeToValue(jsonNode, ListOfSpartanDTO.class);
        } else if (jsonNode.get("results").has("duration")) {
            return objectMapper.treeToValue(jsonNode, ListOfStreamDTO.class);
        } else {
            return objectMapper.treeToValue(jsonNode, ListOfCourseDTO.class);
        }

    }

    private static ErrorDTO getError(JsonNode jsonNode) throws JsonProcessingException {
        return objectMapper.treeToValue(jsonNode, ErrorDTO.class);
    }

    private static SpartanDTO getSpartan(JsonNode jsonNode) throws JsonProcessingException {
        return objectMapper.treeToValue(jsonNode, SpartanDTO.class);
    }
}

