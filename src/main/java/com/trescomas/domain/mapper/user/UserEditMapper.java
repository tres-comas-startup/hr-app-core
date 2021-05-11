package com.trescomas.domain.mapper.user;

import com.trescomas.domain.dto.user.CreateUserRequest;
import com.trescomas.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserEditMapper {
    public User create(CreateUserRequest request) {
        var user = new User(
                request.username(),
                request.fullName(),
                request.fullName()
        );

        user.setRoles(request.authorities());

        return user;
    }
}
