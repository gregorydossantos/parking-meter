package com.gregory.parkingmeter.app.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class StandardError {

    private LocalDateTime dateTime;
    private Integer status;
    private String error;
    private String path;

}
