package com.trescomas.repository;

import com.trescomas.domain.model.BaseEntity;
import com.trescomas.exception.ResourceNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotNull;

@NoRepositoryBean
public interface BaseRepository<ENTITY extends BaseEntity> extends CrudRepository<ENTITY, Long> {

    default ENTITY get(@NotNull Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    default ENTITY get(@NotNull Long id, @NotNull ResourceNotFoundException e) {
        return findById(id).orElseThrow(() -> e);
    }

}
