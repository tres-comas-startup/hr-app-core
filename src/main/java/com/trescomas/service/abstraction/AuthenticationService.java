package com.trescomas.service.abstraction;

import com.trescomas.domain.dto.auth.LoginRequest;
import com.trescomas.domain.dto.auth.RegisterRequest;
import com.trescomas.domain.model.User;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<?> login(LoginRequest request);

    User register(RegisterRequest request);

}
