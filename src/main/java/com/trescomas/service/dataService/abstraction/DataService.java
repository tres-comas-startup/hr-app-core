package com.trescomas.service.dataService.abstraction;

import com.trescomas.domain.model.BaseEntity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public interface DataService<ENTITY extends BaseEntity<ID>, ID extends Serializable> {

    Long count();

    List<ENTITY> list();

    ENTITY get(@NotNull final ID id);

    ENTITY save(@NotNull final ENTITY entity);

    void deleteById(@NotNull final ID id);

}
