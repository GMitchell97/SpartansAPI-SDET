package com.sparta.spartansapi.dto;

import org.joda.time.DateTime;

public class SpartanDTO {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private DateTime startDate;
    private DateTime endDate;
    private String course;
    private String stream;
    private String email;


    public SpartanDTO(String id, String firstName, String middleName, String lastName, DateTime startDate, DateTime endDate, String course, String stream, String email) {
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

    public SpartanDTO(String id, String firstName, String lastName, DateTime startDate, DateTime endDate, String course, String stream, String email) {
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

    public DateTime getStartDate() {
        return startDate;
    }

    public DateTime getEndDate() {
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
}
