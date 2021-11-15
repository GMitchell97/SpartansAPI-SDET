package com.sparta.spartansapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class APIKey {

    public static String getAPIKey() {
        String key = null;

        try (InputStream input = APIKey.class.getClassLoader().getResourceAsStream("application.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.err.println("Sorry, unable to find application.properties");
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            key = prop.getProperty("API-Key");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return key;

    }
}