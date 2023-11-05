package com.gregory.parkingmeter.domain.service;

import com.gregory.parkingmeter.app.response.ParkResponse;
import com.gregory.parkingmeter.domain.dto.ParkDto;
import com.gregory.parkingmeter.domain.usecase.ParkUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ParkService {

    final ParkUseCase useCase;

    public ParkResponse parking(String licensePlate, BigDecimal value) {
        return useCase.parking(licensePlate, value);
    }

    public List<ParkDto> parkingList() {
        return useCase.parkingList();
    }

}
