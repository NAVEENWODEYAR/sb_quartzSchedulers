package com.gowri.quartz.utils;

/**
 * @author NaveenWodeyar
 * @date 22-Oct-2024
 * @time 12:07:51 am
 */
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gowri.quartz.model.TestEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class RepoUtilsTest {

    @Mock
    private JpaRepository<TestEntity, Long> dairyRepository;

    @InjectMocks
    private RepoUtils<TestEntity, Long> repoUtils;

    private TestEntity dairy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dairy = new TestEntity(); 
    }

    @Test
    void testSave() {
        when(dairyRepository.save(any(TestEntity.class))).thenReturn(dairy);

        TestEntity savedDairy = repoUtils.save(dairy);

        assertNotNull(savedDairy);
        verify(dairyRepository, times(1)).save(dairy);
    }

    @Test
    void testFindById() {
        when(dairyRepository.findById(1L)).thenReturn(Optional.of(dairy));

        Optional<TestEntity> foundDairy = repoUtils.findById(1L);

        assertTrue(foundDairy.isPresent());
        assertEquals(dairy, foundDairy.get());
        verify(dairyRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        when(dairyRepository.findAll()).thenReturn(Arrays.asList(dairy));

        List<TestEntity> dairies = repoUtils.findAll();

        assertFalse(dairies.isEmpty());
        assertEquals(1, dairies.size());
        verify(dairyRepository, times(1)).findAll();
    }

    @Test
    void testUpdate() {
        when(dairyRepository.save(any(TestEntity.class))).thenReturn(dairy);

        TestEntity updatedDairy = repoUtils.update(dairy);

        assertNotNull(updatedDairy);
        verify(dairyRepository, times(1)).save(dairy);
    }

    @Test
    void testDeleteById() {
        doNothing().when(dairyRepository).deleteById(1L);

        repoUtils.deleteById(1L);

        verify(dairyRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDelete() {
        doNothing().when(dairyRepository).delete(any(TestEntity.class));

        repoUtils.delete(dairy);

        verify(dairyRepository, times(1)).delete(dairy);
    }

    @Test
    void testSaveThrowsException() {
        when(dairyRepository.save(any(TestEntity.class))).thenThrow(new RuntimeException("Save error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            repoUtils.save(dairy);
        });

        assertEquals("Save error", exception.getMessage());
    }

    @Test
    void testFindByIdThrowsException() {
        when(dairyRepository.findById(1L)).thenThrow(new RuntimeException("Find error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            repoUtils.findById(1L);
        });

        assertEquals("Find error", exception.getMessage());
    }

}
