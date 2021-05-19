package com.trescomas.service.abstraction;

import com.trescomas.domain.dto.auth.LoginRequest;
import com.trescomas.domain.dto.auth.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<?> login(LoginRequest request);

    ResponseEntity<?> register(RegisterRequest request);

}
