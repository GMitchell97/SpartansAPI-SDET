package com.sparta.spartansapi.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ConnectionManager {

    private static final String BASEURL = "/api";
    private Spartan spartan = new Spartan();
    private Courses courses = new Courses();
    private Streams streams = new Streams();

    public Spartan getSpartan() {
        return spartan;
    }

    public Courses getCourses() {
        return courses;
    }

    public Streams getStreams() {
        return streams;
    }

    public static String getBaseURL() {
        return BASEURL;
    }
}
