package com.gregory.parkingmeter.domain.service;

import com.gregory.parkingmeter.app.request.ParkRequest;
import com.gregory.parkingmeter.app.response.ParkResponse;
import com.gregory.parkingmeter.domain.usecase.ParkUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParkService {

    final ParkUseCase useCase;

    public ParkResponse parking(ParkRequest request) {
        return useCase.parking(request);
    }

    public List<ParkResponse> parkingList() {
        return useCase.parkingList();
    }

}
