package com.trescomas.repository;

import com.trescomas.domain.model.User;
import com.trescomas.exception.ResourceNotFoundException;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {

    @Override
    default User get(Long id) {
        return BaseRepository.super.get(id, new ResourceNotFoundException(id));
    }

    Optional<User> findByUsername(@NotNull String username);

    boolean existsByUsername(@NotNull String username);

}
