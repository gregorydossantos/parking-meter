package com.gregory.parkingmeter.domain.usecase;

import com.gregory.parkingmeter.app.response.ParkResponse;
import com.gregory.parkingmeter.domain.dto.ParkDto;
import com.gregory.parkingmeter.domain.exception.CalculateTimeExpirationException;
import com.gregory.parkingmeter.domain.exception.DataNullOrEmptyException;
import com.gregory.parkingmeter.domain.exception.InsufficientBalanceException;
import com.gregory.parkingmeter.infra.db.model.Car;
import com.gregory.parkingmeter.infra.db.model.Park;
import com.gregory.parkingmeter.infra.db.repository.CarRepository;
import com.gregory.parkingmeter.infra.db.repository.ParkRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkUseCase {

    static final String PARK_NOT_FOUND = "Parked car list is empty!";
    static final String CAR_NOT_FOUND = "Car not found!";
    static final String INSUFFICIENT_BALANCE = "Insufficient balance!";
    static final String UNABLE_CALCULATE_EXPIRATION = "Unable to calculate expiration time!";

    final ParkRepository repository;
    final CarRepository carRepository;
    final ModelMapper mapper;

    public ParkResponse parking(String licensePlate, BigDecimal value) {
        var car = carExists(licensePlate);

        hasBalance(car, value);

        var response = toResponse(car, value);
        return mapper.map(response, ParkResponse.class);
    }

    public List<ParkDto> parkingList() {
        var parkList = repository.findAll();

        if (parkList.isEmpty())
            throw new DataNullOrEmptyException(PARK_NOT_FOUND);

        return parkList.stream().map(park -> mapper.map(park, ParkDto.class)).collect(Collectors.toList());
    }

    private Car carExists(String licensePlate) {
        var car = carRepository.findByLicensePlate(licensePlate);
        if (Objects.isNull(car))
            throw new DataNullOrEmptyException(CAR_NOT_FOUND);

        return car;
    }

    private void hasBalance(Car car, BigDecimal value) {
        BigDecimal result = car.getBalance().subtract(value);
        if (result.compareTo(BigDecimal.ZERO) < 0)
            throw new InsufficientBalanceException(INSUFFICIENT_BALANCE);

        car.setBalance(result);
        //carRepository.saveAndFlush(car);
    }

    private ParkDto toResponse(Car car, BigDecimal value) {
        return toParkDto(savePark(Park.builder()
                .dateTime(LocalDateTime.now())
                .licensePlate(car.getLicensePlate())
                .build()), value);
    }

    private Park savePark(Park park) {
        return repository.saveAndFlush(park);
    }

    private ParkDto toParkDto(Park park, BigDecimal value) {
        return ParkDto.builder()
                .id(park.getId())
                .dateTime(park.getDateTime())
                .timeExpiration(calculateTimeExpiration(park.getDateTime(), value))
                .licensePlate(park.getLicensePlate())
                .build();
    }

    private LocalDateTime calculateTimeExpiration(LocalDateTime dateTime, BigDecimal value) {
        switch (value.intValue()) {
            case 1:
                return dateTime.plusHours(1L);
            case 2:
                return dateTime.plusHours(2L);

        }
        throw new CalculateTimeExpirationException(UNABLE_CALCULATE_EXPIRATION);
    }
}
