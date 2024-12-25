package com.gowri.quartz.repoutil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * @author NaveenWodeyar
 * @date 18-Oct-2024
 * @time 12:41:42 am
 */

@Component
public class GenericRepositoryUtil<T, ID> {

    private final JpaRepository<T, ID> repository;

    public GenericRepositoryUtil(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    // Save a new entity
    public T save(T entity) {
        return repository.save(entity);
    }

    // Update an existing entity
    public T update(T entity) {
        return repository.save(entity); 
    }

    // Delete an entity by ID
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    // Find an entity by ID
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    // Get all entities
    public Iterable<T> findAll() {
        return repository.findAll();
    }
}
