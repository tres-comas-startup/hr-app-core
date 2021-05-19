package com.trescomas.service.impl;

import com.trescomas.config.security.JwtTokenUtil;
import com.trescomas.domain.dto.auth.LoginRequest;
import com.trescomas.domain.dto.auth.RegisterRequest;
import com.trescomas.domain.dto.auth.UserCredentials;
import com.trescomas.domain.dto.user.UserView;
import com.trescomas.domain.model.User;
import com.trescomas.service.abstraction.AuthenticationService;
import com.trescomas.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Override
    public ResponseEntity<UserView> login(LoginRequest request) {
        return authenticate(request);
    }

    @Override
    public ResponseEntity<UserView> register(RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    private ResponseEntity<UserView> authenticate(UserCredentials userCredentials) {
        log.debug("Authenticate credentials: {}", userCredentials);

        final var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCredentials.username(),
                        userCredentials.password()
                )
        );

        final var user = (User) authentication.getPrincipal();
        final var token = jwtTokenUtil.generateAccessToken(user);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .build();
    }

}
