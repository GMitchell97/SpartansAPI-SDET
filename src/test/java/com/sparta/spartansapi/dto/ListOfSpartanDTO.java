package com.sparta.spartansapi.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfSpartanDTO implements IResponse {
    private List<SpartanDTO> spartans = new ArrayList<>();

    public List<SpartanDTO> getSpartans() {
        return spartans;
    }
    public void addSpartan(SpartanDTO spartanDTO){
        spartans.add(spartanDTO);
    }

    /**
     * Checks if spartans in List<SpartanDTO> has the specified stream name
     * @param stream - stream of course the spartan is in
     * @return if all spartans in list have stream
     */
    public boolean isSpartanInStream(String stream){
        for (SpartanDTO spartanDTO: spartans){
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
        for (SpartanDTO spartanDTO: spartans){
            if (!spartanDTO.getCourse().getName().equals(course)){
                return false;
            }
        }
        return true;
    }

    /**
     * Gets all spartans who start their contract on a specific date
     * @param date - the specified date
     * @return a list of matching spartans
     */
    public List<SpartanDTO> getSpartansByStartDate(LocalDate date) {
        return spartans.stream()
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
        return spartans.stream()
                .filter(s -> s.isStartDateWithinRange(dateMin, dateMax))
                .collect(Collectors.toList());
    }

    /**
     * Gets all spartans who end their contract on a specific date
     * @param date - the specified date
     * @return a list of matching spartans
     */
    public List<SpartanDTO> getSpartansByEndDate(LocalDate date) {
        return spartans.stream()
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
        return spartans.stream()
                .filter(s -> s.isEndDateWithinRange(dateMin, dateMax))
                .collect(Collectors.toList());
    }
}
