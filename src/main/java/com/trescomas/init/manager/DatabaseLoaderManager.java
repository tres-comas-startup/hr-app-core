package com.trescomas.init.manager;

import com.trescomas.init.abstraction.DatabaseLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

public interface DatabaseLoaderManager extends CommandLineRunner {

    Logger log = LoggerFactory.getLogger(DatabaseLoaderManager.class);

    /**
     * Executes operations from all loaders
     */
    void load();

    /**
     * Indicates that subclass must have a List of DatabaseLoaders
     *
     * @return List<DatabaseLoader> - list of loaders
     */
    List<DatabaseLoader> getDatabaseLoaders();

    @Override
    default void run(String... args) throws Exception {
        log.debug("Init DatabaseLoaderManager...");
        log.debug("Use DatabaseLoaders: {}; - Count: {}", getDatabaseLoaders(), getDatabaseLoaders().size());
        load();
    }

}
