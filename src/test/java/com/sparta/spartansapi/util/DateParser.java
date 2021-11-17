package com.sparta.spartansapi.util;

import java.time.LocalDate;

/**
 * Converts a date in the expected string format (e.g. 2021-11-14T00:00:00.000+00:00)
 * into a LocalDate
 * @author Natasha
 */
public class DateParser {

    /**
     * Parses the datetime string into a LocalDate
     * @param dateStr
     * @return
     */
    public static LocalDate parse(String dateStr) {
        String d = dateStr.substring(0, dateStr.indexOf('T'));
        return LocalDate.parse(d);
    }

}
