package com.kodigo.managmentflights.DAL;

import com.kodigo.managmentflights.Entities.Entity;

import java.util.List;
import java.util.Set;

public interface IRepository<T extends Entity> {

    T create(T t);
    void delete(T t);
    T find(T t);
    T update(T t);
    Set<T> findAll();
}
