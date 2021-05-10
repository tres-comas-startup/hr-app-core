package com.trescomas.config.json.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.trescomas.service.util.date.DateTimeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;

@Configuration
@AllArgsConstructor
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    private final DateTimeService dateTimeService;

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDate.parse(p.getValueAsString(), dateTimeService.dateFormatter);
    }
}
