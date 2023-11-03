package com.gregory.parkingmeter.app.rest;

import com.gregory.parkingmeter.app.request.CarRequest;
import com.gregory.parkingmeter.domain.dto.CarDto;
import com.gregory.parkingmeter.domain.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class CarControllerTest {

    @InjectMocks
    private CarController controller;

    @Mock
    private CarService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be return a http status 201 - created")
    void saveCarTest() {
        var mock = Mockito.mock(CarDto.class);
        when(service.save(any())).thenReturn(mock);

        var request = buildRequest();
        ResponseEntity<CarDto> response = controller.save(request);
        assertNotNull(response);
    }

    private CarRequest buildRequest() {
        return CarRequest.builder()
                .licensePlate("DEF4567")
                .balance(BigDecimal.TEN)
                .retiree("N")
                .build();
    }
}
