package com.gregory.parkingmeter.app.rest;

import com.gregory.parkingmeter.app.response.ParkResponse;
import com.gregory.parkingmeter.commons.AbstractUseful;
import com.gregory.parkingmeter.domain.service.ParkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParkControllerTest extends AbstractUseful {

    @InjectMocks
    private ParkController controller;

    @Mock
    private ParkService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be return a http status 201 - created")
    void saveParkTest() {
        var mock = buildMockParkResponse();
        when(service.parking(any())).thenReturn(mock);

        var request = buildMockParkRequest();
        ResponseEntity<ParkResponse> response = controller.park(request);
        assertNotNull(response);
    }

    @Test
    @DisplayName("Should be return a http status 200 - success")
    void getParkedListTest() {
        var mock = buildMockParkResponse();
        when(service.parkingList()).thenReturn(List.of(mock));

        ResponseEntity<List<ParkResponse>> response = controller.parkList();
        assertNotNull(response);
    }

}
