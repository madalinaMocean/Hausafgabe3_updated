package com.company.repos;

import java.util.List;

public interface ICrudRepository<T> {

    T create(T obj);

    List<T> getAll();

    T update(T obj);

    T delete(T obj);
}
