package com.sparta.spartansapi.connection;

public class Courses {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/courses";

    public String getAll() {
        return endPointURL;
    }

    public String getByCourseName(String course){
        return endPointURL + "?name="+course;
    }

    public String getAddCourseUrl(){ return endPointURL; }

    public String getCourseUpdateUrl(String courseId) { return endPointURL + "/"+ courseId; }

    public String getCourseDeleteUrl(String courseId){ return endPointURL + "/"+ courseId ; }
}
