package com.gregory.parkingmeter.app.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkRequest {

    static final String ALPHA_NUMERIC = "^[a-zA-Z0-9]*$";

    @NotNull
    @Size(max = 7)
    @Pattern(regexp = ALPHA_NUMERIC)
    private String licensePlate;

}
