package com.gowri.quartz.model;
/**
 * @author NaveenWodeyar
 * @date 18-Oct-2024
 * @time 12:49:47 am
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AuditableEntityTest {

    private TestEntity testEntity;

    @BeforeEach
    void setUp() {
        testEntity = new TestEntity();
        testEntity.setCreatedBy("Admin");
        testEntity.setUpdatedBy("Admin");
    }

    @Test
    void testCreationTimeIsSetOnPersist() {
        testEntity.onCreate(); // Simulating persist
        assertNotNull(testEntity.getCreatedTime(), "Created time should not be null");
        assertNotNull(testEntity.getUpdatedTime(), "Updated time should not be null");
        assertEquals("Admin", testEntity.getCreatedBy(), "Created by should match");
    }

    @Test
    void testUpdateTimeIsSetOnUpdate() {
        testEntity.onCreate(); // Simulate creation
        LocalDateTime initialUpdateTime = testEntity.getUpdatedTime();

        // Simulate update
        testEntity.onUpdate();
        assertNotEquals(initialUpdateTime, testEntity.getUpdatedTime(), "Updated time should be different after update");
    }
}
