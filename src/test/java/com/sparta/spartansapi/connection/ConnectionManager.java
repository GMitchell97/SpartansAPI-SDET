package com.sparta.spartansapi.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ConnectionManager {

    private static final String BASEURL = "http://localhost:8080";

    public static Spartan getSpartan() {
        return new Spartan();
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
