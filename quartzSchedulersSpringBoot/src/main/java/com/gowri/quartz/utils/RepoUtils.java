package com.gowri.quartz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
/**
 * @author NaveenWodeyar
 * @date 22-Oct-2024
 * @time 12:05:56 am
 */
@Component
public class RepoUtils<T, ID> {

    private static final Logger log = LoggerFactory.getLogger(RepoUtils.class);
    private final JpaRepository<T, ID> repository;

    @Autowired
    public RepoUtils(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        Instant start = Instant.now();
        try {
            T savedEntity = repository.save(entity);
            logDuration("save", start);
            return savedEntity;
        } catch (Exception e) {
            log.error("Error occurred while saving entity: {}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    public Optional<T> findById(ID id) {
        Instant start = Instant.now();
        try {
            Optional<T> result = repository.findById(id);
            logDuration("findById", start);
            return result;
        } catch (Exception e) {
            log.error("Error occurred while finding entity by ID {}: {}", id, e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    public List<T> findAll() {
        Instant start = Instant.now();
        try {
            List<T> result = repository.findAll();
            logDuration("findAll", start);
            return result;
        } catch (Exception e) {
            log.error("Error occurred while finding all entities: {}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    public T update(T entity) {
        Instant start = Instant.now();
        try {
            T updatedEntity = repository.save(entity);
            logDuration("update", start);
            return updatedEntity; // save() method can also be used for updates
        } catch (Exception e) {
            log.error("Error occurred while updating entity: {}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    public void deleteById(ID id) {
        Instant start = Instant.now();
        try {
            repository.deleteById(id);
            logDuration("deleteById", start);
        } catch (Exception e) {
            log.error("Error occurred while deleting entity by ID {}: {}", id, e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    public void delete(T entity) {
        Instant start = Instant.now();
        try {
            repository.delete(entity);
            logDuration("delete", start);
        } catch (Exception e) {
            log.error("Error occurred while deleting entity: {}", e.getMessage());
            throw e; 
        }
    }

    private void logDuration(String methodName, Instant start) {
        long durationInMillis = java.time.Duration.between(start, Instant.now()).toMillis();
        log.info("Method {} executed in {} ms", methodName, durationInMillis);
    }
}
