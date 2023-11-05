package com.gregory.parkingmeter.infra.db.repository;

import com.gregory.parkingmeter.infra.db.model.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepository extends JpaRepository<Park, Long> {
}
