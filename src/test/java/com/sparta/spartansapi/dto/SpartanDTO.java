package com.sparta.spartansapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sparta.spartansapi.util.DateParser;
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
    private String id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("course")
    private String course;
    @JsonProperty("stream")
    private String stream;
    @JsonProperty("email")
    private String email;

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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
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
        if (middleName != null) {
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
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
     * @param date - the specified date
     * @return whether or not the start date is equal to the date
     */
    public boolean isStartDateEqual(LocalDate date) {
        return DateParser.parse(startDate).isEqual(date);
    }

    /**
     * Checks if the end date of the spartan matches a specified date
     * @param date - the specified date
     * @return whether or not the end date is equal to the date
     */
    public boolean isEndDateEqual(LocalDate date) {
        return DateParser.parse(endDate).isEqual(date);
    }

    /**
     * Checks if the start date of the spartan is within a specified date range
     * @param dateLower - the earliest date
     * @param dateUpper - the latest date
     * @return whether or not the start date is within the date range
     */
    public boolean isStartDateWithinRange(LocalDate dateLower, LocalDate dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        LocalDate ld = DateParser.parse(startDate);
        return !(ld.isBefore(dateLower) || ld.isAfter(dateUpper));
    }

    /**
     * Checks if the end date of the spartan is within a specified date range
     * @param dateLower - the earliest date
     * @param dateUpper - the latest date
     * @return whether or not the end date is within the date range
     */
    public boolean isEndDateWithinRange(LocalDate dateLower, LocalDate dateUpper) {
        // TODO: Implement what happens when the second date is earlier than the first date
        LocalDate ld = DateParser.parse(endDate);
        return !(ld.isBefore(dateLower) || ld.isAfter(dateUpper));
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
        if (startDate == null) {
            return false;
        }
        // TODO: review whether startDate and endDate can be the same
        LocalDate lsd = DateParser.parse(startDate);
        LocalDate led = DateParser.parse(endDate);
        return isDateEqualOrAfterFoundingYear(lsd) &&
                (lsd.isEqual(led) || lsd.isBefore(led));
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
        LocalDate lsd = DateParser.parse(startDate);
        LocalDate led = DateParser.parse(endDate);
        return isDateEqualOrAfterFoundingYear(led) &&
                (led.isEqual(lsd) || led.isAfter(lsd));
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
