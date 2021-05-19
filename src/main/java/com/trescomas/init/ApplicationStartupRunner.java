package com.trescomas.init;

import com.trescomas.config.rest.RestResourceConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationStartupRunner implements ApplicationRunner {

    private final RestResourceConfig restResourceConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        restResourceConfig.initProjections();
    }

}
