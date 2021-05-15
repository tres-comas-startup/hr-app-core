package com.trescomas.init.impl;

import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.domain.model.user.Role;
import com.trescomas.init.abstraction.AbstractDatabaseLoader;
import com.trescomas.init.database.LoadOrder;
import com.trescomas.service.role.RoleDataService;
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
