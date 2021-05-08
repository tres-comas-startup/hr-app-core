package com.trescomas.services.util.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DateTimeService {

    String DATE_TIME_FORMAT_PATTERN = "dd.MM.yyyy HH:mm";
    String DATE_FORMAT_PATTERN = "dd.MM.yyyy";

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_PATTERN);
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);

    default String format(LocalDateTime localDateTime) {
        return localDateTime.format(dateTimeFormatter);
    }

}
