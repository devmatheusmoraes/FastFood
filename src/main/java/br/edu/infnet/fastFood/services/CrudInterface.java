package br.edu.infnet.fastFood.services;

import java.util.List;

public interface CrudInterface<T> {
    List<T> getAll();
    T getById(int id);
    void create(T entity);
    void update(int id, T updatedEntity);
    void delete(int id);
}