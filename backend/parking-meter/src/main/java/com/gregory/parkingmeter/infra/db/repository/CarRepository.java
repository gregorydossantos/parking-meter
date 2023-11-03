package com.gregory.parkingmeter.infra.db.repository;

import com.gregory.parkingmeter.infra.db.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByLicensePlate(String licensePlate);
    
}
