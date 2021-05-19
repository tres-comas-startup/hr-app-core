package com.trescomas.service.impl;

import com.trescomas.domain.dto.auth.RegisterRequest;
import com.trescomas.domain.dto.user.UserView;
import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.service.abstraction.UserService;
import com.trescomas.service.dataService.abstraction.RoleDataService;
import com.trescomas.service.dataService.abstraction.UserDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserDataService userDataService;
    private final RoleDataService roleDataService;

    @Override
    public UserView register(RegisterRequest request) {
        log.debug("Register user: {}", request);
        return null;
    }

}
