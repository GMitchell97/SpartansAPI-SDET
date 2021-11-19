package com.sparta.spartansapi.connection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.net.http.*;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class CallManager {

    private HttpResponse<String> httpResponse = null;

    public enum Methods {GET, POST, PATCH, DELETE}

    public CallManager(String url) throws IOException, InterruptedException {
        getRequest(url);
    }

    public CallManager(String url, Methods methods, String jsonString) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        switch (methods) {
            case GET -> getRequest(url);
            case POST -> postRequest(url, jsonString);
            case PATCH -> patchRequest(url, jsonString);
            case DELETE -> deleteRequest(url);
        }
    }

    public CallManager(String url, Methods methods) throws IOException, InterruptedException {
        this(url, methods, "");
    }

    private void getRequest(String url) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        makeRequest(httpClient, httpRequest);
    }

    private void postRequest(String url, String jsonString) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .header("Content-Type","application/json")
                .build();

        makeRequest(httpClient, httpRequest);
    }

    private void patchRequest(String url, String jsonString) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                .header("Content-Type","application/json")
                .build();

        makeRequest(httpClient, httpRequest);
    }

    private void deleteRequest(String url) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).DELETE().build();

        makeRequest(httpClient, httpRequest);
    }

    private void makeRequest(HttpClient httpClient, HttpRequest httpRequest) throws IOException, InterruptedException {
        httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public String getJson() {
        return httpResponse.body();
    }

    public int getStatusCode() {
        return httpResponse.statusCode();
    }

}


