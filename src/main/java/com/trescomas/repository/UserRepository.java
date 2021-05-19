package com.trescomas.repository;

import com.trescomas.domain.model.User;
import com.trescomas.exception.ResourceNotFoundException;
import com.trescomas.domain.projection.user.UserExcerptProjection;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RepositoryRestResource(excerptProjection = UserExcerptProjection.class)
public interface UserRepository extends BaseRepository<User, Long> {

    @Override
    default User get(Long id) {
        return BaseRepository.super.get(id, new ResourceNotFoundException(id));
    }

    Optional<User> findByUsername(@NotNull String username);

    boolean existsByUsername(@NotNull String username);

}
