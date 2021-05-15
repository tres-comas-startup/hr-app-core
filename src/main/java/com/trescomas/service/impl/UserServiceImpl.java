package com.trescomas.service.impl;

import com.trescomas.domain.dto.user.CreateUserRequest;
import com.trescomas.domain.dto.user.UserView;
import com.trescomas.service.abstraction.UserService;
import com.trescomas.service.dataService.abstraction.UserDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserDataService userDataService;

    @Value("${hrapp.password.min.length:8}")
    private int MIN_PASSWORD_LENGTH;

    public UserView create(CreateUserRequest request) {
//        log.debug("Create user by request: {}", request);
//
//        // Validate username
//        if (userRepository.findByUsername(request.username()).isPresent()) {
//            throw new ValidationException("Username exists!");
//        }
//
//        // Validate password
//        if (request.password().length() < MIN_PASSWORD_LENGTH) {
//            throw new ValidationException("Passwords is too short!");
//        }
//
//        User user = userMapper.toUser(request);
//        user.setPassword(passwordEncoder.encode(request.password()));
//
//        return userMapper.toUserView(userDataService.save(user));
        return null;
    }

}
