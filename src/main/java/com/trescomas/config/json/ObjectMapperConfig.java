package com.trescomas.config.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.trescomas.config.json.serializer.LocalDateDeserializer;
import com.trescomas.config.json.serializer.LocalDateSerializer;
import com.trescomas.config.json.serializer.LocalDateTimeDeserializer;
import com.trescomas.config.json.serializer.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@AllArgsConstructor
public class ObjectMapperConfig {

    LocalDateSerializer localDateSerializer;
    LocalDateDeserializer localDateDeserializer;
    LocalDateTimeSerializer localDateTimeSerializer;
    LocalDateTimeDeserializer localDateTimeDeserializer;

    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();

        var javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, localDateSerializer);
        javaTimeModule.addDeserializer(LocalDate.class, localDateDeserializer);
        javaTimeModule.addSerializer(LocalDateTime.class, localDateTimeSerializer);
        javaTimeModule.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        objectMapper.registerModule(javaTimeModule);

        return objectMapper;
    }

}
