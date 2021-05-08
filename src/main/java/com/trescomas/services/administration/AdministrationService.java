package com.trescomas.services.administration;

import com.trescomas.domain.Test;
import com.trescomas.repository.TestRepository;
import com.trescomas.services.util.date.DateTimeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AdministrationService {

    static final Logger log = LoggerFactory.getLogger(AdministrationService.class);

    private final TestRepository testRepository;
    public final DateTimeService dateTimeService;

    public void testDB() {

        var instance = new Test();
        instance.setName(generateTestName());

        log.debug("Instances count before save: " + testRepository.count());

        log.debug("Test save in the DB:");
        var savedInstance = testRepository.save(instance);
        log.debug("Saved instance: " + savedInstance);

        log.debug("Instances count after save: " + testRepository.count());

        var testInstances = testRepository.findAll();

        log.debug(testInstances.toString());
    }

    private String generateTestName() {
        return "generated-" + dateTimeService.format(LocalDateTime.now());
    }

}
