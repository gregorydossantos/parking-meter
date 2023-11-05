package com.gregory.parkingmeter.domain.usecase;

import com.gregory.parkingmeter.commons.AbstractUseful;
import com.gregory.parkingmeter.domain.exception.DataIntegrityException;
import com.gregory.parkingmeter.domain.exception.DataNullOrEmptyException;
import com.gregory.parkingmeter.infra.db.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarUseCaseTest extends AbstractUseful {

    @Autowired
    private CarUseCase useCase;

    @Autowired
    private CarRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        repository.deleteAll();
    }

    @Test
    @DisplayName("Should be return a car after save")
    void saveCarTest() {
        var request = buildMockRequest(LICENSE_PLATE, BALANCE);
        var car = useCase.save(request);

        assertNotNull(car);
    }

    @Test
    @DisplayName("Should be return error - car already exists")
    void saveCarAlreadyExistsTest() {
        var request = buildMockRequest("ABC0123", BigDecimal.TEN);

        assertThrows(DataIntegrityException.class, () -> useCase.save(request));
    }

    @Test
    @DisplayName("Should be return successful after delete a car")
    void deleteCarTest() {
        useCase.delete(1L);

        var car = repository.findById(1L);
        assertTrue(car.isEmpty());
    }

    @Test
    @DisplayName("Should be return error - car not found")
    void deleteCarThatNotExistsTest() {
        assertThrows(DataNullOrEmptyException.class, () -> useCase.delete(10L));
    }

}
