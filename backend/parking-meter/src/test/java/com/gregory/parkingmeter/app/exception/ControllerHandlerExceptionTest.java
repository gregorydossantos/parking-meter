package com.gregory.parkingmeter.app.exception;

import com.gregory.parkingmeter.domain.exception.DataIntegrityException;
import com.gregory.parkingmeter.domain.exception.DataNullOrEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class ControllerHandlerExceptionTest {

    private static final String DATA_NOT_FOUND = "Vehicle not found!";
    private static final String DATA_ALREADY_EXISTS = "Vehicle already registered!";
    private static final String BAD_REQUEST = "Error in the context of the request!";

    @InjectMocks
    private ControllerHandlerException exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be return BadRequestViolationException")
    void testWhenRequestComesWithError() {
        ResponseEntity<StandardError> response = exceptionHandler.badRequestException(
                new BadRequestException(BAD_REQUEST),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
    }

    @Test
    @DisplayName("Should be return DataIntegrityException")
    void testWhenHomeApplianceAlreadyExists() {
        ResponseEntity<StandardError> response = exceptionHandler.dataIntegrityException(
                new DataIntegrityException(DATA_ALREADY_EXISTS),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
    }

    @Test
    @DisplayName("Should be return DataNullOrEmptyException")
    void testWhenDataNotFound() {
        ResponseEntity<StandardError> response = exceptionHandler.dataNullOrEmptyException(
                new DataNullOrEmptyException(DATA_NOT_FOUND),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
    }
}
