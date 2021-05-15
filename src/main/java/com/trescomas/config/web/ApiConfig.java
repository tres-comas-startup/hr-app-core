package com.trescomas.config.web;

import com.trescomas.domain.dto.util.AppInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApiConfig {

    @Bean
    public AppInfo appInfo() {
        return new AppInfo("HR-APP", "0.1.0", Map.of("info", "/api/public/application/info"));
    }

}
