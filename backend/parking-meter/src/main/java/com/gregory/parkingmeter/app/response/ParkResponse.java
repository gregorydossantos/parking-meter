package com.gregory.parkingmeter.app.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkResponse {

    static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm";

    @JsonProperty(access = WRITE_ONLY)
    private Long id;

    @JsonFormat(pattern = DATE_TIME_PATTERN)
    private LocalDateTime dateTime;

    @JsonFormat(pattern = DATE_TIME_PATTERN)
    private LocalDateTime timeExpiration;
    private String licensePlate;

}
