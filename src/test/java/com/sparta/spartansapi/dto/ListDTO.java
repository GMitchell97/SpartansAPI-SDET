package com.sparta.spartansapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "count",
        "status_code"
})
public class ListDTO implements IResponse {
    @JsonProperty("results")
    private List<Object> results;
    @JsonProperty("message")
    private String message;
    @JsonProperty("count")
    private int count;
    @JsonProperty("status_code")
    private int statusCode;

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
