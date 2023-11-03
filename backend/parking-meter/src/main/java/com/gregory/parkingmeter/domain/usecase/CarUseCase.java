package com.gregory.parkingmeter.domain.usecase;

import com.gregory.parkingmeter.app.request.CarRequest;
import com.gregory.parkingmeter.domain.dto.CarDto;
import com.gregory.parkingmeter.domain.exception.DataIntegrityException;
import com.gregory.parkingmeter.domain.useful.ValidationUseful;
import com.gregory.parkingmeter.infra.db.model.Car;
import com.gregory.parkingmeter.infra.db.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarUseCase {

    static final String CAR_ALREADY_EXISTS = "Car already exists!";

    final CarRepository repository;
    final ValidationUseful validator;
    final ModelMapper mapper;

    public CarDto save(CarRequest request) {
        validator.validateRequest(request);

        if(carExists(request.getLicensePlate()))
            throw new DataIntegrityException(CAR_ALREADY_EXISTS);

        var response = toResponse(request);
        return mapper.map(response, CarDto.class);
    }

    public void delete(Long id) {}

    private boolean carExists(String licensePlate) {
        var car = repository.findByLicensePlate(licensePlate);
        return car == null;
    }

    private Car toResponse(CarRequest request) {
        var car = Car.builder()
                .licensePlate(request.getLicensePlate())
                .balance(request.getBalance())
                .retiree(request.getRetiree())
                .build();

        return repository.save(car);
    }
}
