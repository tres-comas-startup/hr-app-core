package com.trescomas.init.manager;

import com.trescomas.init.abstraction.DatabaseLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Used to operate with the database after application initialization finished
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseLoaderManagerImpl implements DatabaseLoaderManager {

    private final List<DatabaseLoader> databaseLoaders;

    @Override
    public void load() {
        databaseLoaders.forEach(DatabaseLoader::load);
    }

    @Override
    public List<DatabaseLoader> getDatabaseLoaders() {
        return databaseLoaders;
    }

}
