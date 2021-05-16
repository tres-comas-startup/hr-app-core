package com.trescomas.repository;

import com.trescomas.domain.model.BaseEntity;
import com.trescomas.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<ENTITY extends BaseEntity, ID extends Serializable> extends CrudRepository<ENTITY, ID> {

    @Override
    @Query(value = "select count(entity) from #{#entityName} entity")
    long count();

    default ENTITY get(ID id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException((Long) id));
    }

    default ENTITY get(ID id, ResourceNotFoundException e) {
        return findById(id).orElseThrow(() -> e);
    }

}
