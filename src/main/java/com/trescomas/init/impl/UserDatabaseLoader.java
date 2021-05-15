package com.trescomas.init.impl;

import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.domain.enums.SystemUsernames;
import com.trescomas.domain.model.user.User;
import com.trescomas.init.abstraction.AbstractDatabaseLoader;
import com.trescomas.init.database.LoadOrder;
import com.trescomas.service.role.RoleDataService;
import com.trescomas.service.user.UserDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;

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
