package com.sparta.spartansapi.connection;

public class Courses {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/courses";

    public String getAllCoursesUrl() {
        return endPointURL + "/all";
    }

    public String getSpecificCourseUrl(String course){
        return endPointURL + "course?name="+course;
    }

    public String getCourseUpdateUrl(String courseId) { return endPointURL + "/update/"+ courseId;}

    public String getCourseDeleteUrl(String courseId){
        return endPointURL + "/delete/"+ courseId ;
    }

    public String getAddCourseUrl(){
        return endPointURL +"/add";
    }


}
