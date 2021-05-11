package com.trescomas.api;

import com.trescomas.config.security.JwtTokenUtil;
import com.trescomas.config.security.Routes;
import com.trescomas.domain.dto.api.AuthRequest;
import com.trescomas.domain.dto.user.CreateUserRequest;
import com.trescomas.domain.dto.user.UserView;
import com.trescomas.domain.mapper.user.UserViewMapper;
import com.trescomas.domain.model.User;
import com.trescomas.service.user.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;

@AllArgsConstructor
@RestController
@RequestMapping(path = Routes.PUBLIC)
public class AuthApi {

    private final Logger log;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserViewMapper userViewMapper;
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<UserView> login(@RequestBody @Valid AuthRequest request) {
        try {
            var authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.username(), request.password()
                            )
                    );

            var user = (User) authenticate.getPrincipal();

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(user))
                    .body(userViewMapper.toUserView(user));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("register")
    public ResponseEntity<UserView> register(@RequestBody @Valid CreateUserRequest request) {
        try {
            var userView = userService.create(request);
            return ResponseEntity.ok(userView);
        } catch (ValidationException e) {
            log.error(e.getMessage(), e.getCause());
            return ResponseEntity.badRequest().build();
        }
    }
}
