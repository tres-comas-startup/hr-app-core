package com.trescomas.service.abstraction;

import com.trescomas.domain.dto.auth.LoginRequest;
import com.trescomas.domain.dto.auth.RegisterRequest;
import com.trescomas.domain.dto.user.UserView;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<UserView> login(LoginRequest request);

    ResponseEntity<UserView> register(RegisterRequest request);

}
