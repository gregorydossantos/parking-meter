package com.gregory.parkingmeter.app.rest;

import com.gregory.parkingmeter.app.request.ParkRequest;
import com.gregory.parkingmeter.app.response.ParkResponse;
import com.gregory.parkingmeter.domain.service.ParkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.BeanParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Park Controllers")
@RequestMapping(value = "/v1/park", produces = {"application/json"})
public class ParkController {

    final ParkService service;

    @Operation(summary = "Parking a car", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully parking a car"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @PostMapping
    public ResponseEntity<ParkResponse> park(@BeanParam ParkRequest request) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand
                (service.parking(request)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "List of parked cars ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a parked car list"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping
    public ResponseEntity<List<ParkResponse>> parkList() {
        return ResponseEntity.ok(service.parkingList());
    }

}
