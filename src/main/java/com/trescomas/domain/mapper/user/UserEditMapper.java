package com.trescomas.domain.mapper.user;

import com.trescomas.domain.dto.user.CreateUserRequest;
import com.trescomas.domain.model.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserEditMapper {
    public User create(CreateUserRequest request) {
        var user = new User();
        user.setUsername(request.username());
        user.setFullName(request.fullName());
        return user;
    }
}
