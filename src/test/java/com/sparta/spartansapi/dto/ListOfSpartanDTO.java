package com.sparta.spartansapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "results",
        "message",
        "count",
        "status_code"
})

public class ListOfSpartanDTO implements IResponse {
    @JsonProperty("results")
    private List<SpartanDTO> results;
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

    public List<SpartanDTO> getSpartans() {
        return results;
    }

    /**
     * Checks if spartans in List<SpartanDTO> has the specified stream name
     * @param stream - stream of course the spartan is in
     * @return if all spartans in list have stream
     */
    public boolean isSpartanInStream(String stream){
        for (SpartanDTO spartanDTO: results){
            if (!spartanDTO.getStream().getName().equals(stream)){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if spartans in List<SpartanDTO> has the specified course name
     * @param course - course the spartan is in
     * @return if all spartans in list have course
     */
    public boolean isSpartanInCourse(String course){
        for (SpartanDTO spartanDTO: results){
            if (!spartanDTO.getCourse().getName().equals(course)){
                return false;
            }
        }
        return true;
    }

    public boolean doesSpartanExist(String name){
        for(SpartanDTO spartanDTO: results){
            if(!spartanDTO.getFirstName().equals(name)){
                return false;
            }
        }
        return true;
    }

    public String spartanNameConverter (String name) {
        String nname = "";
        for (SpartanDTO spartanDTO : results) {
            if (spartanDTO.getMiddleName().isEmpty()) {
                nname = spartanDTO.getFirstName()+"%20"+spartanDTO.getLastName();
            } else {
                nname = spartanDTO.getFirstName()+"%20"+spartanDTO.getMiddleName()+"%20"+spartanDTO.getLastName();
            }
        }
        return nname;
    }

    public boolean isSpartanNameInResponse(String name) {
        for (SpartanDTO spartanDTO : results) {
            String nname = spartanNameConverter(name);
            if (!name.equals(nname)) return false;
        }
        return true;
    }

    /**
     * Gets all spartans who start their contract on a specific date
     * @param date - the specified date
     * @return a list of matching spartans
     */
    public List<SpartanDTO> getSpartansByStartDate(LocalDate date) {
        return results.stream()
                .filter(s -> s.isStartDateEqual(date))
                .collect(Collectors.toList());
    }

    /**
     * Gets all spartans who start their contract within a date range
     * @param dateMin - the earliest possible start date
     * @param dateMax - the latest possible start date
     * @return a list of matching spartans
     */
    public List<SpartanDTO> getSpartansByStartDateInRange(LocalDate dateMin, LocalDate dateMax) {
        return results.stream()
                .filter(s -> s.isStartDateWithinRange(dateMin, dateMax))
                .collect(Collectors.toList());
    }

    /**
     * Gets all spartans who end their contract on a specific date
     * @param date - the specified date
     * @return a list of matching spartans
     */
    public List<SpartanDTO> getSpartansByEndDate(LocalDate date) {
        return results.stream()
                .filter(s -> s.isEndDateEqual(date))
                .collect(Collectors.toList());
    }

    /**
     * Gets all spartans who end their contract within a date range
     * @param dateMin - the earliest possible end date
     * @param dateMax - the latest possible end date
     * @return a list of matching spartans
     */
    public List<SpartanDTO> getSpartansByEndDateInRange(LocalDate dateMin, LocalDate dateMax) {
        return results.stream()
                .filter(s -> s.isEndDateWithinRange(dateMin, dateMax))
                .collect(Collectors.toList());
    }

    public boolean isIdNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getId() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isFirstNameNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getFirstName() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isLastNameNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getLastName() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isStartDateNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getLastName() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isCourseNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getCourse() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isCourseNameNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getCourse().getName() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isStreamNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getStream() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isStreamNameNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getStream().getName() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isStreamDurationNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getStream().getDuration() == null){
                return true;
            }
        }
        return false;
    }

    public boolean isEmailNull(){
        for (SpartanDTO spartanDTO: results){
            if (spartanDTO.getEmail() == null){
                return true;
            }
        }
        return false;
    }

}
