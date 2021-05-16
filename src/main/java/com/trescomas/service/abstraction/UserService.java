package com.trescomas.service.abstraction;

import com.trescomas.domain.dto.auth.RegisterRequest;
import com.trescomas.domain.dto.user.UserView;

public interface UserService {

    UserView register(RegisterRequest request);

}
