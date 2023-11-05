package com.gregory.parkingmeter.domain.service;

import com.gregory.parkingmeter.commons.AbstractUseful;
import com.gregory.parkingmeter.domain.usecase.CarUseCase;
import com.gregory.parkingmeter.infra.db.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarServiceTest extends AbstractUseful {

    @Autowired
    private CarService service;

    @Autowired
    private CarRepository repository;

    @Mock
    private CarUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be return successful after save a car")
    void saveCarTest() {
        var mock = buildMockDto();
        when(useCase.save(any())).thenReturn(mock);

        var request = buildMockRequest(LICENSE_PLATE, BALANCE, RETIREE);
        var car = service.save(request);
        assertNotNull(car);
    }

    @Test
    @DisplayName("Should be return successful after delete a car")
    void deleteCarTest() {
        service.delete(1L);

        var car = repository.findById(1L);
        assertTrue(car.isEmpty());
    }
}
