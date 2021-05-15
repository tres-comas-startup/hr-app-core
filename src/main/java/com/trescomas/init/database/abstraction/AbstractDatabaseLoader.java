package com.trescomas.init.database.abstraction;

import com.trescomas.domain.model.BaseEntity;
import com.trescomas.service.dataService.abstraction.DataService;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

import static com.trescomas.utils.StringUtils.getEntityName;

@RequiredArgsConstructor
public abstract class AbstractDatabaseLoader<ENTITY extends BaseEntity, ID extends Serializable> implements DatabaseLoader {

    protected final DataService<ENTITY, ID> dataService;

    /**
     * Creates initial message based on Entity class
     *
     * @return String - message to display
     */
    protected String getInitialMessage() {
        return String.format("Init %s...", getEntityName(dataService));
    }

    /**
     * Creates message about completion of the operation.
     * Also shows entries count in the corresponding table
     *
     * @return String - message to display
     */
    protected String getCompletedMessage() {
        return String.format("%s entries count after init: %s", getEntityName(dataService), dataService.count());
    }


}
