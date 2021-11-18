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

public class ListOfStreamDTO extends ListDTO implements IResponse {
    @JsonProperty("results")
    private List<StreamDTO> results;

    public List<StreamDTO> getStreams() {
        return results;
    }

}
