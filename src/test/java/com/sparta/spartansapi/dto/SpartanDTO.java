package com.sparta.spartansapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstName",
        "middleName",
        "lastName",
        "startDate",
        "endDate",
        "course",
        "stream",
        "email"
})
public class SpartanDTO implements IResponse{

    @JsonProperty("id")
    public String id;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("middleName")
    public String middleName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("endDate")
    public String endDate;
    @JsonProperty("course")
    public String course;
    @JsonProperty("stream")
    public String stream;
    @JsonProperty("email")
    public String email;


    public SpartanDTO(String id, String firstName, String middleName, String lastName, String startDate, String endDate, String course, String stream, String email) {
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

    public SpartanDTO(String id, String firstName, String lastName, String startDate, String endDate, String course, String stream, String email) {
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
        return LocalDate.parse(startDate);
    }

    public LocalDate getEndDate() {
        return LocalDate.parse(endDate);
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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
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
        return getStartDate().isEqual(date);
    }

    /**
     * Checks if the start date of the spartan matches a specified date
     * @param date - the specified date (as a String)
     * @return whether or not the start date is equal to the date
     */
    public boolean isStartDateEqual(String date) {
        return getStartDate().isEqual(LocalDate.parse(date));
    }

    /**
     * Checks if the end date of the spartan matches a specified date
     * @param date - the specified date (as a LocalDate)
     * @return whether or not the end date is equal to the date
     */
    public boolean isEndDateEqual(LocalDate date) {
        return getEndDate().isEqual(date);
    }

    /**
     * Checks if the end date of the spartan matches a specified date
     * @param date - the specified date (as a String)
     * @return whether or not the end date is equal to the date
     */
    public boolean isEndDateEqual(String date) {
        return getEndDate().isEqual(LocalDate.parse(date));
    }

    /**
     * Checks if the start date of the spartan is within a specified date range
     * @param dateLower - the earliest date (as a LocalDate)
     * @param dateUpper - the latest date (as a LocalDate)
     * @return whether or not the start date is within the date range
     */
    public boolean isStartDateWithinRange(LocalDate dateLower, LocalDate dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        return !(getStartDate().isBefore(dateLower) || getStartDate().isAfter(dateUpper));
    }

    /**
     * Checks if the start date of the spartan is within a specified date range
     * @param dateLower - the earliest date (as a String)
     * @param dateUpper - the latest date (as a String)
     * @return whether or not the start date is within the date range
     */
    public boolean isStartDateWithinRange(String dateLower, String dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        return !(getStartDate().isBefore(LocalDate.parse(dateLower)) ||
                getStartDate().isAfter(LocalDate.parse(dateUpper)));
    }

    /**
     * Checks if the end date of the spartan is within a specified date range
     * @param dateLower - the earliest date (as a LocalDate)
     * @param dateUpper - the latest date (as a LocalDate)
     * @return whether or not the end date is within the date range
     */
    public boolean isEndDateWithinRange(LocalDate dateLower, LocalDate dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        return !(getEndDate().isBefore(dateLower) || getEndDate().isAfter(dateUpper));
    }

    /**
     * Checks if the end date of the spartan is within a specified date range
     * @param dateLower - the earliest date (as a String)
     * @param dateUpper - the latest date (as a String)
     * @return whether or not the end date is within the date range
     */
    public boolean isEndDateWithinRange(String dateLower, String dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        return !(getEndDate().isBefore(LocalDate.parse(dateLower)) ||
                getEndDate().isAfter(LocalDate.parse(dateUpper)));
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
        return isDateEqualOrAfterFoundingYear(getStartDate()) &&
                (getStartDate().isEqual(getEndDate()) || getStartDate().isBefore(getEndDate()));
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
        return isDateEqualOrAfterFoundingYear(getEndDate()) &&
                (getEndDate().isEqual(getStartDate()) || getEndDate().isAfter(getStartDate()));
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
