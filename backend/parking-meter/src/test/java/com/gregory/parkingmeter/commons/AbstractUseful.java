package com.gregory.parkingmeter.commons;

import com.gregory.parkingmeter.app.request.CarRequest;
import com.gregory.parkingmeter.domain.dto.CarDto;

import java.math.BigDecimal;

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


}
