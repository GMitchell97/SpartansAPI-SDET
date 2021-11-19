package com.sparta.spartansapi.connection;

public class Spartans {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/spartans";
    
    public String getAll() {
        return endPointURL;
    }

    public String getById(String id) {
        return endPointURL + "/" + id;
    }

    public String getByName(String name) {
        return endPointURL + "?q=" + name;
    }

    public String getByCourse(String course) {
        return endPointURL + "?course=" + course;
    }

    public String getByStream(String stream) {
        return endPointURL + "?stream=" + stream;
    }

    public String getByStartDate(String startDate) {
        return endPointURL + "?startdate=" + startDate;
    }

    public String getByStartDateInRange(String after, String before) {
        return endPointURL + "/range?dateafter=" + after
                + "&datebefore=" + before;
    }

    public String getByEndDate(String endDate) {
        return endPointURL + "?enddate=" + endDate;
    }

    public String getByEndDateInRange(String after, String before) {
        return endPointURL + "/range?dateafter=" + after
                + "&datebefore=" + before;
    }

    public String getAddSpartanUrl() {
        return endPointURL;
    }

    public String getUpdateSpartanUrl(String id) {
        return endPointURL + "/" + id;
    }

    public String getDeleteSpartanUrl(String id) {
        return endPointURL + "/" + id;
    }

}
