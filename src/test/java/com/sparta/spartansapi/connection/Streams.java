package com.sparta.spartansapi.connection;

public class Streams {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/streams";

    public String getAllStreamsUrl() {
        return endPointURL + "/all";
    }

    public String getByStreamNameUrl(String streamName) {
        return endPointURL + "/stream?name=" + streamName;
    }

    public String getAddStreamUrl() {
        return endPointURL + "/add";
    }

    public String getStreamUpdateUrl(String spartanId) {
        return endPointURL+"/update/" + spartanId;
    }

    public String getStreamDeleteUrl(String spartanId) {
        return endPointURL+"/delete/" + spartanId;
    }
}
