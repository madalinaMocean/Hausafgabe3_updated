package com.company.repos;

import java.util.List;

/**
 * The interface Crud repository.
 *
 * @param <T> the type parameter
 */
public interface ICrudRepository<T> {

    /**
     * Create t.
     *
     * @param obj the obj
     * @return the t
     */
    T create(T obj);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<T> getAll();

    /**
     * Update t.
     *
     * @param obj the obj
     * @return the t
     */
    T update(T obj);

    /**
     * Delete t.
     *
     * @param obj the obj
     * @return the t
     */
    T delete(T obj);
}
