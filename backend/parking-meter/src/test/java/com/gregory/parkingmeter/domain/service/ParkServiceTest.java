package com.gregory.parkingmeter.domain.service;

import com.gregory.parkingmeter.commons.AbstractUseful;
import com.gregory.parkingmeter.domain.usecase.ParkUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParkServiceTest extends AbstractUseful {

    @Autowired
    private ParkService service;

    @Mock
    private ParkUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be return successful after parked a car")
    void saveParkTest() {
        var mock = buildMockParkResponse();
        when(useCase.parking(any())).thenReturn(mock);

        var request = buildMockParkRequest();
        var car = service.parking(request);
        assertNotNull(car);
    }

    @Test
    @DisplayName("Should be return a car parked list")
    void listAllCarsParkedTest() {
        var mock = buildMockParkResponse();
        when(useCase.parkingList()).thenReturn(List.of(mock));

        var request = buildMockParkRequest();
        var car = service.parking(request);
        assertNotNull(car);
    }

}
