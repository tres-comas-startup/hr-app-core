package com.trescomas.service.dataService.impl;

import com.trescomas.domain.model.Role;
import com.trescomas.domain.model.User;
import com.trescomas.exception.UserNotFoundException;
import com.trescomas.repository.UserRepository;
import com.trescomas.service.dataService.abstraction.UserDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    protected final UserRepository userRepository;

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
        return userRepository.get(id);
    }

    @Override
    public User findByUsername(@NotNull String username) {
        log.debug("Find user by username: {}", username);
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public boolean existsByUsername(String username) {
        log.debug("Check whether a user with username: {} exists", username);
        return userRepository.existsByUsername(username);
    }

    @Transactional
    @Override
    public User save(User user) {
        log.debug("Save user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public User create(String fullName, String username, String password, Set<Role> roles) {
        log.debug("Create user: {}, {}, {}", fullName, username, roles);

        final var user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(roles);

        return save(user);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Delete user: {}", id);
        userRepository.deleteById(id);
    }
}
