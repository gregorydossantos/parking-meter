package com.gregory.parkingmeter.commons;

import com.gregory.parkingmeter.app.request.CarRequest;
import com.gregory.parkingmeter.app.request.ParkRequest;
import com.gregory.parkingmeter.app.response.ParkResponse;
import com.gregory.parkingmeter.domain.dto.CarDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class AbstractUseful {

    public static final String LICENSE_PLATE = "DEF4567";
    public static final BigDecimal BALANCE = BigDecimal.TEN;

    public static CarRequest buildMockRequest(String licensePlate, BigDecimal balance) {
        return CarRequest.builder()
                .licensePlate(licensePlate)
                .balance(balance)
                .build();
    }

    public static CarDto buildMockDto() {
        return CarDto.builder()
                .id(2L)
                .licensePlate("DEF4567")
                .balance(BigDecimal.TEN)
                .build();
    }

    public static ParkRequest buildMockParkRequest() {
        return ParkRequest.builder()
                .licensePlate("ABC0123")
                .value(BigDecimal.ONE)
                .build();
    }

    public static ParkRequest buildMockParkRequest(String licensePlate, BigDecimal value) {
        return ParkRequest.builder()
                .licensePlate(licensePlate)
                .value(value)
                .build();
    }

    public static ParkResponse buildMockParkResponse() {
        return ParkResponse.builder()
                .id(1L)
                .dateTime(LocalDateTime.now())
                .timeExpiration(LocalDateTime.now().plusHours(1L))
                .licensePlate("ABC0123")
                .build();
    }

}
