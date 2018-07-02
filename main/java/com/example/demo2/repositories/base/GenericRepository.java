package com.example.demo2.repositories.base;

import com.example.demo2.entities.base.ModelEntity;

import java.util.List;

public interface GenericRepository<T extends ModelEntity> {
    List<T> getAll();

    T getById(int id);

    T create(T entity);
}
