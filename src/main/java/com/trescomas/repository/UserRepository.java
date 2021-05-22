package com.trescomas.repository;

import com.trescomas.domain.model.User;
import com.trescomas.domain.projection.user.UserExcerptProjection;
import com.trescomas.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RepositoryRestResource(excerptProjection = UserExcerptProjection.class)
public interface UserRepository extends BaseRepository<User, Long> {

    @Override
    default User get(Long id) {
        return BaseRepository.super.get(id, new ResourceNotFoundException(id));
    }

    Optional<User> findByUsername(@NotNull String username);

    @RestResource(exported = false)
    @Query("from User u join fetch u.roles where u.username = ?1")
    Optional<User> findByUsernameEager(String username);

    boolean existsByUsername(@NotNull String username);

}
