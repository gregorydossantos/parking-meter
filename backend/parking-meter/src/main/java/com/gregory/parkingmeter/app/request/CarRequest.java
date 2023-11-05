package com.gregory.parkingmeter.app.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CarRequest {

    @NotNull
    @Size(max = 7)
    private String licensePlate;

    @NotNull
    private BigDecimal balance;

    @NotNull
    @Size(max = 1)
    private String retiree;

}
