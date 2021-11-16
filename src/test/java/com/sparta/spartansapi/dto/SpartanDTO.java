package com.sparta.spartansapi.dto;

import org.mockito.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class SpartanDTO {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String course;
    private String stream;
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
    public boolean isValidDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            formatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
