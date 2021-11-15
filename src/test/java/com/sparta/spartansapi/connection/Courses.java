package com.sparta.spartansapi.connection;

public class Courses {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/courses";

    public String getAllCoursesUrl() {
        return endPointURL + "/all";
    }

    public String getSpecificCourseUrl(String course){
        return endPointURL + "?courseName="+course;
    }

    public String getCourseUpdateUrl(String courseId) {
        return endPointURL + "/" + courseId + "/update";
    }

    public String getCourseDeleteUrl(String courseId){
        return endPointURL + "/" + courseId + "/delete";
    }

    public String getAddCourseUrl(){
        return endPointURL +"/add";
    }


}
