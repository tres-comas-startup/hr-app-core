package com.trescomas.init.database.impl;

import com.trescomas.domain.model.user.User;
import com.trescomas.init.database.abstraction.AbstractDatabaseLoader;
import com.trescomas.init.database.constants.LoadOrder;
import com.trescomas.service.dataService.abstraction.RoleDataService;
import com.trescomas.service.dataService.abstraction.UserDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(value = LoadOrder.USER)
public class UserDatabaseLoader extends AbstractDatabaseLoader<User, Long> {

    private final RoleDataService roleDataService;

    public UserDatabaseLoader(UserDataService userDataService, RoleDataService roleDataService) {
        super(userDataService);
        this.roleDataService = roleDataService;
    }

    @Override
    public void load() {
        log.debug(getInitialMessage());

        final var userDataService = (UserDataService) super.dataService;

//        if (!userDataService.existsByUsername(SystemUsernames.ADMIN.getValue())) {
//            userDataService.create(
//                    "Системный администратор",
//                    SystemUsernames.ADMIN.getValue(),
//                    "hradmin#12345",
//                    Set.of(roleDataService.findByTitle(RoleTitle.ADMIN))
//            );
//        }
//
//        if (!userDataService.existsByUsername(SystemUsernames.HR_MANAGER.getValue())) {
//            userDataService.create(
//                    "Есьман Арина",
//                    SystemUsernames.HR_MANAGER.getValue(),
//                    "hrhr#12345",
//                    Set.of(roleDataService.findByTitle(RoleTitle.HR_MANAGER))
//            );
//        }

        log.debug(getCompletedMessage());
    }

}
