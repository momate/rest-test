package com.momate.rest.test.dao;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T,ID> {
    
    void save(T entity);
    void delete(T entity);
    void update(ID id, T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    
}
