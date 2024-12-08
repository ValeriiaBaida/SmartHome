package com.khai.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeValidator {
    private static final String TIME_FORMAT = "hh:mm:ss";

    public static void validateTimeFormat(String time) throws IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(time);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid time format. Please use HH:mm:ss format.");
        }
    }
}