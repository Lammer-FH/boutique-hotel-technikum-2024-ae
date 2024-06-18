package com.example.boutiquehoteltechnikum.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void validateDates(String startDate, String endDate) {
        if (startDate != null && endDate != null) {
            Date start = getDate(startDate);
            Date end = getDate(endDate);
            if (end.before(start)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Das Startdatum muss vor dem Enddatum sein!");
            }
        }
    }

    public static Date getDate(String date) {
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Das Datum muss im Format yyyy-MM-dd sein!");
        }
    }
}
