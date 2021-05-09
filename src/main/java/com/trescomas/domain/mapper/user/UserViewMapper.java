package com.trescomas.domain.mapper.user;

import com.trescomas.domain.dto.user.UserView;
import com.trescomas.domain.model.user.User;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class UserViewMapper {

    public UserView toUserView(@NotNull User user) {
        return new UserView(user.getId(), user.getUsername(), user.getPassword());
    }
}
