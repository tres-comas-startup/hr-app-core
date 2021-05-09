package com.trescomas.repository.user;

import com.trescomas.domain.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    default User loadUserByUsername(String username) {
        return findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User: %s, not found", username)));
    }

}
