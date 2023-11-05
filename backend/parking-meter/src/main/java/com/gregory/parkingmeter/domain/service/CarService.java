package com.gregory.parkingmeter.domain.service;

import com.gregory.parkingmeter.app.request.CarRequest;
import com.gregory.parkingmeter.domain.dto.CarDto;
import com.gregory.parkingmeter.domain.usecase.CarUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    final CarUseCase useCase;

    public CarDto save(CarRequest request) {
        return useCase.save(request);
    }

    public void delete(Long id) {
        useCase.delete(id);
    }
}
