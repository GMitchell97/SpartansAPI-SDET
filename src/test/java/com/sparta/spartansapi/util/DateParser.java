package com.sparta.spartansapi.util;

import java.time.LocalDate;

/**
 * Utility class for converting a date in the expected string format into a LocalDate
 */
public class DateParser {

    /**
     * Parses the datetime string into a LocalDate
     * @param dateStr - the datetime string (e.g. (e.g. 2021-11-14T00:00:00.000+00:00)
     * @return the date
     */
    public static LocalDate parse(String dateStr) {
        String d = dateStr.substring(0, dateStr.indexOf('T'));
        LocalDate ld = null;
        try {
            ld = LocalDate.parse(d);
        } catch (Exception e) {
            System.err.println("Failed to parse datestring " + dateStr + " into a LocalDate!");
            //e.printStackTrace();
        }
        // TODO: review what happens if format is invalid/LocalDate.parse fails - throw error, return null or both?
        return ld;
    }

}
