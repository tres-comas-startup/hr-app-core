package com.trescomas.service;

import java.io.Serializable;
import java.util.List;

public interface DataService<T, ID extends Serializable> {

    Long count();

    List<T> list();

    T get(ID id);

    T save(T instance);

    List<T> saveAll(List<T> instances);

    void delete(T instance);

}
