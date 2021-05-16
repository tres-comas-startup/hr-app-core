package com.trescomas.controller;

import com.trescomas.config.web.Routes;
import com.trescomas.domain.dto.auth.LoginRequest;
import com.trescomas.domain.dto.auth.RegisterRequest;
import com.trescomas.domain.dto.user.UserView;
import com.trescomas.service.abstraction.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = Routes.BASE_PUBLIC_API)
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("login")
    public ResponseEntity<UserView> login(@RequestBody @Valid LoginRequest request) {
        return authenticationService.login(request);
    }

    @PostMapping("register")
    public ResponseEntity<UserView> register(@RequestBody @Valid RegisterRequest request) {
        return authenticationService.register(request);
    }
}
