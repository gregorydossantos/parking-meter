package com.gregory.parkingmeter.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @JsonProperty(access = WRITE_ONLY)
    private Long id;
    private String licensePlate;
    private String retiree;
    private BigDecimal balance;
    
}
