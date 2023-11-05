package com.gregory.parkingmeter.app.rest;

import com.gregory.parkingmeter.app.response.ParkResponse;
import com.gregory.parkingmeter.domain.dto.ParkDto;
import com.gregory.parkingmeter.domain.service.ParkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Park Controllers")
@RequestMapping(value = "/v1/park", produces = {"application/json"})
public class ParkController {

    final static String PATH_LICENSE_PLATE = "/{licensePlate}";

    final ParkService service;

    @Operation(summary = "Parking a car", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully parking a car"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @PostMapping(PATH_LICENSE_PLATE)
    public ResponseEntity<ParkResponse> park(@PathParam("licensePlate") String licensePlate,
                                             @PathParam("balance") BigDecimal value) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand
                (service.parking(licensePlate, value)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "List of parked cars ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a parked car list"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ParkDto>> parkList() {
        return ResponseEntity.ok(service.parkingList());
    }

}
