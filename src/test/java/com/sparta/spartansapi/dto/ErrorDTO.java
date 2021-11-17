package com.sparta.spartansapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "timestamp",
        "status",
        "error",
        "trace",
        "message",
        "path"
})
public class ErrorDTO implements IResponse{
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("error")
    private String error;
    @JsonProperty("trace")
    private String trace;
    @JsonProperty("message")
    private String message;
    @JsonProperty("path")
    private String path;

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("error")
    public String getError() {
        return error;
    }

    @JsonProperty("trace")
    public String getTrace() {
        return trace;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }
}
