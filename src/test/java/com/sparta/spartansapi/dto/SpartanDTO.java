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
    private CourseDTO course;
    @JsonProperty("stream")
    private StreamDTO stream;
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

    public CourseDTO getCourse() {
        return course;
    }

    public StreamDTO getStream() {
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

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public void setStream(StreamDTO stream) {
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
     * Checks if the start date of the spartan is within a specified date range
     * @param dateMin - the earliest date
     * @param dateMax - the latest date
     * @return whether or not the start date is within the date range
     */
    public boolean isStartDateWithinRange(LocalDate dateMin, LocalDate dateMax) {
        // TODO: Implement what happens when the second date is earlier than the first date
        LocalDate ld = DateParser.parse(startDate);
        return !(ld.isBefore(dateMin) || ld.isAfter(dateMax));
    }

    /**
     * Checks if the start date is valid
     * @return whether or not the start date is valid
     */
    public boolean isStartDateValid() {
        LocalDate start = DateParser.parse(startDate);
        if (start == null) { // if parse failed
            return false;
        }

        if (!isDateEqualOrAfterFoundingYear(start)) { // if start date occurs before sparta was founded
            return false;
        }

        // TODO: review whether startDate and endDate can be the same
        LocalDate end = DateParser.parse(endDate);
        if (end != null) {
            if (start.isAfter(end)) { // if start date occurs after end date
                return false;
            }
        }

        // TODO: review creation of end date non-null/null value
        //  (given we will always know startDate and course/course length, can we not calculate end date?
        //  why should it ever be null?

        // TODO: implement check for start date occuring x weeks before projected end date of contract

        return true;
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
     * Checks if the end date of the spartan is within a specified date range
     * @param dateMin - the earliest date
     * @param dateMax - the latest date
     * @return whether or not the end date is within the date range
     */
    public boolean isEndDateWithinRange(LocalDate dateMin, LocalDate dateMax) {
        // TODO: Implement what happens when the second date is earlier than the first date
        LocalDate ld = DateParser.parse(endDate);
        return !(ld.isBefore(dateMin) || ld.isAfter(dateMax));
    }

    /**
     * Checks if the end date is valid
     * @return whether or not the end date is valid
     */
    public boolean isEndDateValid() {
        if (endDate == null) { // immediately return true for null values
            return true;
        }

        LocalDate end = DateParser.parse(endDate);
        if (end == null) { // if parse failed
            return false;
        }

        if (!isDateEqualOrAfterFoundingYear(end)) { // if end date occurs before sparta was founded
            return false;
        }

        // TODO: review whether startDate and endDate can be the same
        LocalDate start = DateParser.parse(startDate);
        if (start != null) {
            if (end.isBefore(start)) { // if end date occurs before start date
                return false;
            }
        }

        // TODO: review creation of end date non-null/null value
        //  (given we will always know startDate and course/course length, can we not calculate end date?
        //  why should it ever be null?

        // TODO: implement check for (projected) end date occuring x weeks after start date of contract

        return true;
    }

    /**
     * Checks if the date is in a valid format
     *
     * @deprecated
     * Needs to be updated for new date string format (e.g. 2022-10-23T23:00:00.000+00:00)
     * Move it into Util.DateParser maybe?
     *
     * @param dateStr - the date
     * @return whether or not the date is valid
     */
    @Deprecated
    public boolean isDateStringValid(String dateStr) {
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
     * Checks if the date is equal to or after Sparta's founding year (2014)
     * @param date - the date to be checked
     * @return whether or not the date is equal to or after 2014
     */
    public boolean isDateEqualOrAfterFoundingYear(LocalDate date) {
        LocalDate founded = LocalDate.parse("2014-01-01");
        return !date.isBefore(founded); // alternatively: date.isEqual(founded) || date.isAfter(founded)
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


    public String getFirstInital(){
        return getFirstName().substring(0,1);
    }


    public boolean isEmailValidFormat(){
        return getEmail().equals(getFirstInital()+getLastName()+"@spartaglobal.com");
    }
}
