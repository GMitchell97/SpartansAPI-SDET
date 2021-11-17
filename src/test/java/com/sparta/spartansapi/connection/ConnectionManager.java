package com.sparta.spartansapi.connection;

public class ConnectionManager {

    private static final String BASEURL = "/api";

    public static Spartans getSpartans() {
        return new Spartans();
    }

    public static Courses getCourses() {
        return new Courses();
    }

    public static Streams getStreams() {
        return new Streams();
    }

    public static String getBaseURL() {
        return BASEURL;
    }

}
