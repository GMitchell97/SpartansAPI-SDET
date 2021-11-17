package com.sparta.spartansapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mockito.cglib.core.Local;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class SpartanDTO implements IResponse{

    @JsonProperty("id")
    private String id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("startDate")
    private LocalDate startDate;
    @JsonProperty("endDate")
    private LocalDate endDate;
    @JsonProperty("course")
    private String course;
    @JsonProperty("stream")
    private String stream;
    @JsonProperty("email")
    private String email;


    public SpartanDTO(String id, String firstName, String middleName, String lastName, LocalDate startDate, LocalDate endDate, String course, String stream, String email) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.stream = stream;
        this.email = email;
    }

    public SpartanDTO(String id, String firstName, String lastName, LocalDate startDate, LocalDate endDate, String course, String stream, String email) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = null;
        this.lastName = lastName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.stream = stream;
        this.email = email;
    }

    public SpartanDTO() {
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getCourse() {
        return course;
    }

    public String getStream() {
        return stream;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Checks if the start date of the spartan matches a specified date
     * @param date - the specified date (as a LocalDate)
     * @return whether or not the start date is equal to the date
     */
    public boolean isStartDateEqual(LocalDate date) {
        return startDate.isEqual(date);
    }

    /**
     * Checks if the start date of the spartan matches a specified date
     * @param date - the specified date (as a String)
     * @return whether or not the start date is equal to the date
     */
    public boolean isStartDateEqual(String date) {
        return startDate.isEqual(LocalDate.parse(date));
    }

    /**
     * Checks if the end date of the spartan matches a specified date
     * @param date - the specified date (as a LocalDate)
     * @return whether or not the end date is equal to the date
     */
    public boolean isEndDateEqual(LocalDate date) {
        return endDate.isEqual(date);
    }

    /**
     * Checks if the end date of the spartan matches a specified date
     * @param date - the specified date (as a String)
     * @return whether or not the end date is equal to the date
     */
    public boolean isEndDateEqual(String date) {
        return endDate.isEqual(LocalDate.parse(date));
    }

    /**
     * Checks if the start date of the spartan is within a specified date range
     * @param dateLower - the earliest date (as a LocalDate)
     * @param dateUpper - the latest date (as a LocalDate)
     * @return whether or not the start date is within the date range
     */
    public boolean isStartDateWithinRange(LocalDate dateLower, LocalDate dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        return !(startDate.isBefore(dateLower) || startDate.isAfter(dateUpper));
    }

    /**
     * Checks if the start date of the spartan is within a specified date range
     * @param dateLower - the earliest date (as a String)
     * @param dateUpper - the latest date (as a String)
     * @return whether or not the start date is within the date range
     */
    public boolean isStartDateWithinRange(String dateLower, String dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        return !(startDate.isBefore(LocalDate.parse(dateLower)) ||
                startDate.isAfter(LocalDate.parse(dateUpper)));
    }

    /**
     * Checks if the end date of the spartan is within a specified date range
     * @param dateLower - the earliest date (as a LocalDate)
     * @param dateUpper - the latest date (as a LocalDate)
     * @return whether or not the end date is within the date range
     */
    public boolean isEndDateWithinRange(LocalDate dateLower, LocalDate dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        return !(endDate.isBefore(dateLower) || endDate.isAfter(dateUpper));
    }

    /**
     * Checks if the end date of the spartan is within a specified date range
     * @param dateLower - the earliest date (as a String)
     * @param dateUpper - the latest date (as a String)
     * @return whether or not the end date is within the date range
     */
    public boolean isEndDateWithinRange(String dateLower, String dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        return !(endDate.isBefore(LocalDate.parse(dateLower)) ||
                endDate.isAfter(LocalDate.parse(dateUpper)));
    }

    /**
     * Checks if the date is in a valid format (e.g. 2021-12-26)
     * @param dateStr - the date (as a String)
     * @return whether or not the date is valid
     */
    public boolean isValidDateStringFormat(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            formatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the start date is valid
     * @return whether or not the start date is valid
     */
    public boolean isValidStartDate() {
        // TODO: review whether startDate and endDate can be the same
        return isDateEqualOrAfterFoundingYear(startDate) &&
                (startDate.isEqual(endDate) || startDate.isBefore(endDate));
    }

    /**
     * Checks if the end date is valid
     * @return whethernor not the end date is valid
     */
    public boolean isValidEndDate() {
        if (endDate == null) {
            return true;
        }
        // TODO: review whether startDate and endDate can be the same
        return isDateEqualOrAfterFoundingYear(endDate) &&
                (endDate.isEqual(startDate) || endDate.isAfter(startDate));
    }

    /**
     * Checks if the date is equal to or after Sparta's founding year (2014)
     * @param date - the date to be checked
     * @return whether or not the date is equal to or after 2014
     */
    private boolean isDateEqualOrAfterFoundingYear(LocalDate date) {
        LocalDate founded = LocalDate.parse("2014-01-01");
        return date.isEqual(founded) || date.isAfter(founded);
    }

    public static boolean isJSONValid(String jsonString ) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
