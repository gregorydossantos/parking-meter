package com.gregory.parkingmeter.app.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.QueryParam;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ParkRequest {

    static final String ALPHA_NUMERIC = "^[a-zA-Z0-9]*$";

    @NotNull
    @Size(max = 7)
    @Pattern(regexp = ALPHA_NUMERIC)
    @QueryParam("licensePlate")
    private String licensePlate;

    @Min(1)
    @Max(2)
    @NotNull
    @QueryParam("value")
    private BigDecimal value;

}
