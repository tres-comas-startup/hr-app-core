package com.trescomas.service.user;

import com.trescomas.domain.dto.user.CreateUserRequest;
import com.trescomas.domain.dto.user.UserView;
import com.trescomas.domain.mapper.user.UserEditMapper;
import com.trescomas.domain.mapper.user.UserViewMapper;
import com.trescomas.domain.model.User;
import com.trescomas.repository.UserRepository;
import com.trescomas.service.DataService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements DataService<User, Long> {

    @NonNull
    private final UserRepository userRepository;

    @NonNull
    private final UserViewMapper userViewMapper;

    @NonNull
    private final UserEditMapper userEditMapper;

    @NonNull
    private final PasswordEncoder passwordEncoder;

    @Value("${hrapp.password.min.length:8}")
    private int MIN_PASSWORD_LENGTH;

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public List<User> list() {
        log.debug("List all users");
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        log.debug("Get user with id: {}", id);
        return userRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public User save(User user) {
        log.debug("Save user: {}", user);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public List<User> saveAll(List<User> users) {
        log.debug("Save users: {}", users);
        return (List<User>) userRepository.saveAll(users);
    }

    @Transactional
    @Override
    public void delete(User user) {
        log.debug("Delete user: {}", user);
        userRepository.delete(user);
    }

    @Transactional
    public UserView create(CreateUserRequest request) {
        log.debug("Create user by request: {}", request);

        // Validate username
        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new ValidationException("Username exists!");
        }

        // Validate password
        if (request.password().length() < MIN_PASSWORD_LENGTH) {
            throw new ValidationException("Passwords is too short!");
        }

        User user = userEditMapper.create(request);
        user.setPassword(passwordEncoder.encode(request.password()));

        return userViewMapper.toUserView(save(user));
    }

}
