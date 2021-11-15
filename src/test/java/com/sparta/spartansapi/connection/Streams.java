package com.sparta.spartansapi.connection;

public class Streams {
    private static String endPointURL = ConnectionManager.getBaseURL() + "/courses";

    public String getAllStreamsUrl() {
        return endPointURL + "/all";
    }

    public String getByStreamNameUrl(String streamName) {
        return endPointURL + "?streamName=" + streamName;
    }

    public String getAddStreamUrl() {
        return endPointURL + "/add";
    }

    public String getStreamUpdateUrl(String spartanId) {
        return endPointURL+"/"+spartanId+"/update";
    }

    public String getStreamDeleteUrl(String spartanId) {
        return endPointURL+"/"+spartanId+"/delete";
    }
}
