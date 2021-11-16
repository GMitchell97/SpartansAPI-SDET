package com.sparta.spartansapi.connection;

public class Spartan {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/spartan";
    
    public String getAll() {
        return endPointURL+"/all";
    }

    public String getByName(String firstName) {
        return endPointURL+"/name?firstName=" + firstName;
    }

    public String getByName(String fName, String lName) {
        return endPointURL+"/name?firstName=" + fName
                + "&lastname=" + lName;
    }

    public String getByStartDate(String startDate) {
        return endPointURL + "/start?startdate=" + startDate;
    }

    public String getByStartDateInRange(String lower, String upper) {
        return endPointURL + "/range?startdatelower=" + lower
                + "&startdateupper=" + lower;
    }

    public String getByCourse(String course) {
        return endPointURL + "/course?name=" + course;
    }

    public String getAddSpartanUrl() {
        return endPointURL + "/add";
    }

    public String getUpdateSpartanUrl(String id) {
        return endPointURL+"/update/" + id;
    }

    public String getDeleteSpartanUrl(String id) {
        return endPointURL + "/delete/" + id;
    }

    public String getByStream(String stream) {
        return endPointURL + "/stream?name=" + stream;
    }
}
