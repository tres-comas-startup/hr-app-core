package com.trescomas.config.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.trescomas.service.util.date.DateTimeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDateTime;

@Configuration
@AllArgsConstructor
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private final DateTimeService dateTimeService;

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.format(dateTimeService.dateTimeFormatter));

    }
}
