package com.sparta.spartansapi.connection;

public class Spartan {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/spartan";
    
    private static String getAll() {
        return endPointURL+"/all";
    }

    public String getByFirstName(String firstName) {
        return endPointURL+"?firstName="+firstName;
    }

    public String getByLastName(String lastName){
        return endPointURL+"?lastName="+lastName;
    }

    public String getByStartDate(String startDate) {
        return endPointURL + "?startDate" + startDate;
    }

    public String getByCourse(String course) {
        return endPointURL + "?course" + course;
    }

    public String getAddSpartanUrl() {
        return endPointURL + "/add";
    }

    public String getUpdateSpartanUrl(String id){
        return endPointURL+"/"+id+"/update";
    }

    public String getDeleteSpartanUrl(String id) {
        return endPointURL + "/" + id + "/delete";
    }

    public String getByStream(String stream) {
        return endPointURL + "?stream" + stream;
    }
}
