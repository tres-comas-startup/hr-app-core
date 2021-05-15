package com.trescomas.repository;

import com.trescomas.domain.model.user.User;
import com.trescomas.exception.ResourceNotFoundException;
import com.trescomas.repository.BaseRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    @Override
    default User get(Long id) {
        return BaseRepository.super.get(id, new ResourceNotFoundException(id));
    }

    Optional<User> findByUsername(@NotNull String username);

    boolean existsByUsername(@NotNull String username);

}
