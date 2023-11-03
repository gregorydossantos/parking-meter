package com.gregory.parkingmeter.app.rest;

import com.gregory.parkingmeter.app.request.CarRequest;
import com.gregory.parkingmeter.domain.dto.CarDto;
import com.gregory.parkingmeter.domain.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
@Tag(name = "Cars Controllers")
@RequestMapping(value = "/v1/car", produces = {"application/json"})
public class CarController {

    final static String PATH_ID = "/{id}";

    final CarService service;

    @Operation(summary = "Create a car", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created a car"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> save(@RequestBody CarRequest request) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(service.save(request)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Delete a car", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully delete a car"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @DeleteMapping(PATH_ID)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
