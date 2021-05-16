package com.trescomas.init.database.impl;

import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.domain.model.Role;
import com.trescomas.init.database.abstraction.AbstractDatabaseLoader;
import com.trescomas.init.database.constants.LoadOrder;
import com.trescomas.service.dataService.abstraction.RoleDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Predicate;

@Slf4j
@Component
@Order(value = LoadOrder.ROLE)
public class RoleDatabaseLoader extends AbstractDatabaseLoader<Role, Long> {

    public RoleDatabaseLoader(RoleDataService roleDataService) {
        super(roleDataService);
    }

    @Override
    public void load() {
        log.debug(getInitialMessage());

        final var roleDataService = (RoleDataService) super.dataService;

        Arrays.stream(RoleTitle.values())
                .filter(Predicate.not(roleDataService::existsByTitle))
                .forEach(roleDataService::create);

        log.debug(getCompletedMessage());
    }
}
