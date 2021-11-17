package com.sparta.spartansapi.connection;

public class Streams {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/streams";

    public String getAll() {
        return endPointURL;
    }

    public String getByStreamName(String streamName) {
        return endPointURL + "?name=" + streamName;
    }

    public String getAddStreamUrl() {
        return endPointURL;
    }

    public String getStreamUpdateUrl(String streamId) {
        return endPointURL+ "/" + streamId;
    }

    public String getStreamDeleteUrl(String streamId) {
        return endPointURL+ "/" + streamId;
    }
}
