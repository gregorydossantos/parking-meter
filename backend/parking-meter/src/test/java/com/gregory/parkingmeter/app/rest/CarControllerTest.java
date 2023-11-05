package com.gregory.parkingmeter.app.rest;

import com.gregory.parkingmeter.commons.AbstractUseful;
import com.gregory.parkingmeter.domain.dto.CarDto;
import com.gregory.parkingmeter.domain.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarControllerTest extends AbstractUseful {

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
        var mock = buildMockDto();
        when(service.save(any())).thenReturn(mock);

        var request = buildMockRequest(LICENSE_PLATE, BALANCE);
        ResponseEntity<CarDto> response = controller.save(request);
        assertNotNull(response);
    }

    @Test
    @DisplayName("Should be return a http status 200 - success")
    void deleteCarTest() {
        controller.delete(1L);

        assertEquals(HttpStatus.OK.value(), 200);
    }

}
