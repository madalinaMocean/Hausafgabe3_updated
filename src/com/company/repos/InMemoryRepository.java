package com.company.repos;

import java.util.ArrayList;
import java.util.List;

/**
 * The type In memory repository.
 *
 * @param <T> the type parameter
 */
public abstract class InMemoryRepository<T> implements ICrudRepository<T> {


    /**
     * The Repo list.
     */
    protected List<T> repoList;

    /**
     * Instantiates a new In memory repository.
     */
    public InMemoryRepository() {
        this.repoList = new ArrayList<>();

    }

    @Override
    public T create(T obj) {
        this.repoList.add(obj);
        return obj;
    }

    @Override
    public List<T> getAll() {
        return this.repoList;
    }

    @Override
    public T delete(T obj) {
        this.repoList.remove(obj);
        return obj;
    }

}