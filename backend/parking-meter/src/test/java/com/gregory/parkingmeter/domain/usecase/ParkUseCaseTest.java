package com.gregory.parkingmeter.domain.usecase;

import com.gregory.parkingmeter.app.response.ParkResponse;
import com.gregory.parkingmeter.commons.AbstractUseful;
import com.gregory.parkingmeter.domain.exception.DataNullOrEmptyException;
import com.gregory.parkingmeter.domain.exception.InsufficientBalanceException;
import com.gregory.parkingmeter.infra.db.repository.ParkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParkUseCaseTest extends AbstractUseful {

    @Autowired
    private ParkUseCase useCase;

    @Autowired
    private ParkRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        repository.deleteAll();
    }

    @Test
    @DisplayName("Should be return a parking car")
    void saveParkTest() {
        var request = buildMockParkRequest();
        var car = useCase.parking(request);

        assertNotNull(car);
    }

    @Test
    @DisplayName("Should be return error - car not exists")
    void errorCarNotExistsTest() {
        var request = buildMockParkRequest("QAZ0129", BigDecimal.TEN);

        assertThrows(DataNullOrEmptyException.class, () -> useCase.parking(request));
    }

    @Test
    @DisplayName("Should be return error - no has balance to park")
    void errorInsufficientBalanceTest() {
        var request = buildMockParkRequest("AAA1234", BigDecimal.TEN);

        assertThrows(InsufficientBalanceException.class, () -> useCase.parking(request));
    }

    @Test
    @DisplayName("Should be return a parked car list")
    void parkedCarListTest() {
        List<ParkResponse> response = useCase.parkingList();
        assertNotNull(response);
    }

    @Test
    @DisplayName("Should be return error - no has car parked")
    void parkedCarListNullOrEmptyTest() {
        assertThrows(DataNullOrEmptyException.class, () -> useCase.parkingList());
    }

}
