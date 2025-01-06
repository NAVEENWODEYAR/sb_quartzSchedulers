package com.gowri.quartz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gowri.quartz.model.TestEntity;

/**
 * @author NaveenWodeyar
 * @date 20-Oct-2024
 * @time 12:47:26 pm
 */
@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Integer> {

}
