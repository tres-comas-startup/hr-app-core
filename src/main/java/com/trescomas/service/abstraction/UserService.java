package com.trescomas.service.abstraction;

import com.trescomas.domain.dto.user.CreateUserRequest;
import com.trescomas.domain.dto.user.UserView;

public interface UserService {

    UserView create(CreateUserRequest request);

}
