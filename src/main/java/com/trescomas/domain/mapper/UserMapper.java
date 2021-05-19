package com.trescomas.domain.mapper;

import com.trescomas.domain.dto.auth.RegisterRequest;
import com.trescomas.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User create(RegisterRequest request) {
        final var user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setUsername(request.username());
        user.setPassword(request.password());
        return user;
    }

}
