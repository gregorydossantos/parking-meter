package com.gregory.parkingmeter.app.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Builder
public class ParkResponse {

    @JsonProperty(access = WRITE_ONLY)
    private Long id;
    private LocalDateTime dateTime;
    private LocalDateTime timeExpiration;
    private String licensePlate;

}
