package com.trescomas.service.dataService.impl;

import com.trescomas.domain.enums.RoleTitle;
import com.trescomas.domain.model.Role;
import com.trescomas.domain.model.User;
import com.trescomas.repository.UserRepository;
import com.trescomas.service.dataService.abstraction.RoleDataService;
import com.trescomas.service.dataService.abstraction.UserDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    protected final UserRepository userRepository;
    private final RoleDataService roleDataService;

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
    public User findByUsername(String username) {
        log.debug("Find user by username: {}", username);
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User: %s, not found", username)));
    }

    @Override
    public boolean existsByUsername(String username) {
        log.debug("Check whether a user with username: {} exists", username);
        return userRepository.existsByUsername(username);
    }

    @Override
    public void setRoles(User user, Set<RoleTitle> roleTitles) {
        log.debug("Set roles: {} to user: ", roleTitles, user);
        final var roles = roleTitles.stream()
                .map(roleDataService::findByTitle)
                .collect(Collectors.toSet());

        if (user.getRoles() == null) {
            user.setRoles(roles);
        } else {
            user.getRoles().addAll(roles);
        }
    }

    @Transactional
    @Override
    public User save(User user) {
        log.debug("Save user: {}", user);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User create(String firstName, String lastName, String username, String password, Set<Role> roles) {
        log.debug("Create user: {}, {}, {}", firstName, username, roles);

        final var user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(roles);

        return save(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        log.debug("Delete user: {}", id);
        userRepository.deleteById(id);
    }
}
