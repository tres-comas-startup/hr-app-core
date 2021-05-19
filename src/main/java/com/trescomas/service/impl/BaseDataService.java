package com.trescomas.service.impl;

import com.trescomas.domain.model.BaseEntity;
import com.trescomas.repository.BaseRepository;
import com.trescomas.service.dataService.abstraction.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class BaseDataService<ENTITY extends BaseEntity<ID>, ID extends Serializable> implements DataService<ENTITY, ID> {

    protected final BaseRepository<ENTITY, ID> repository;

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<ENTITY> list() {
        log.debug("List resources");
        return repository.list();
    }

    @Override
    public ENTITY get(ID id) {
        log.debug("Get entity with id: {}", id);
        return repository.get(id);
    }

    @Override
    public ENTITY save(ENTITY entity) {
        log.debug("Save entity: {}", entity);
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        log.debug("Delete entity with id: {}", id);
        repository.deleteById(id);
    }

}
