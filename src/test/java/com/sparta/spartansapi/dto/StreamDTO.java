package com.sparta.spartansapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "duration",
})
public class StreamDTO implements IResponse {

    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("duration")
    public Integer duration;

    public StreamDTO(String id, String firstName, Integer duration) {
        this.id = id;
        this.name = firstName;
        this.duration = duration;
    }

    public StreamDTO(String firstName, Integer duration) {
        this.name = firstName;
        this.duration = duration;
    }

    public StreamDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "StreamDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
