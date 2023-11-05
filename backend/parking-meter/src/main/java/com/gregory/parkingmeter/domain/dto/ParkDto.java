package com.gregory.parkingmeter.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkDto {

    private Long id;
    private LocalDateTime dateTime;
    private LocalDateTime timeExpiration;
    private String licensePlate;

}
