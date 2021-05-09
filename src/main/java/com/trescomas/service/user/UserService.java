package com.trescomas.service.user;

import com.trescomas.domain.dto.user.CreateUserRequest;
import com.trescomas.domain.dto.user.UserView;
import com.trescomas.domain.mapper.user.UserEditMapper;
import com.trescomas.domain.mapper.user.UserViewMapper;
import com.trescomas.domain.model.user.User;
import com.trescomas.repository.user.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;

@Service
public class UserService extends UserDetailsServiceImpl {

    @Autowired
    private Logger log;

    @Autowired
    private UserViewMapper userViewMapper;

    @Autowired
    private UserEditMapper userEditMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${hrapp.password.min.length:8}")
    private int MIN_PASSWORD_LENGTH;

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Transactional
    public UserView create(CreateUserRequest request) {
        log.debug("Create user by request: {}", request);

        // Validate username
        if (super.userRepository.findByUsername(request.username()).isPresent()) {
            throw new ValidationException("Username exists!");
        }

        // Validate password
        if (request.password().length() < MIN_PASSWORD_LENGTH) {
            throw new ValidationException("Passwords is too short!");
        }

        User user = userEditMapper.create(request);
        user.setPassword(passwordEncoder.encode(request.password()));

        user = userRepository.save(user);

        return userViewMapper.toUserView(user);
    }
}
