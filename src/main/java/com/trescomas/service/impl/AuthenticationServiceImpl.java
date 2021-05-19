package com.trescomas.service.impl;

import com.trescomas.config.security.JwtTokenUtil;
import com.trescomas.domain.dto.auth.LoginRequest;
import com.trescomas.domain.dto.auth.RegisterRequest;
import com.trescomas.domain.model.User;
import com.trescomas.service.abstraction.AuthenticationService;
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

    @Override
    public ResponseEntity<?> login(LoginRequest request) {
        return authenticate(request);
    }

    @Override
    public ResponseEntity<?> register(RegisterRequest request) {
        return ResponseEntity.ok(null);
    }

    private ResponseEntity<?> authenticate(LoginRequest request) {
        log.debug("Authenticate login request: {}", request.username());

        final var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        final var user = (User) authentication.getPrincipal();
        final var token = jwtTokenUtil.generateAccessToken(user);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .build();
    }

}
