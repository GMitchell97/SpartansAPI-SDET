package com.sparta.spartansapi.connection;

import java.net.http.*;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class CallManager{

    private HttpResponse<String> httpResponse = null;

    public CallManager(String url){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getJson(){
        return httpResponse.body();
    }

    public int getStatusCode() {
        return httpResponse.statusCode();
    }

}


