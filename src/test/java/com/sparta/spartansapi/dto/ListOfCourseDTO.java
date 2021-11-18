package com.sparta.spartansapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "results",
        "message",
        "count",
        "status_code"
})

public class ListOfCourseDTO implements IResponse {
    @JsonProperty("results")
    private List<CourseDTO> results;
    @JsonProperty("message")
    private String message;
    @JsonProperty("count")
    private int count;
    @JsonProperty("status_code")
    private int statusCode;

    public List<CourseDTO> getCourses() {return results;}

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