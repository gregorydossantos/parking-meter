package com.gregory.parkingmeter.app.rest;

import com.gregory.parkingmeter.app.request.CarRequest;
import com.gregory.parkingmeter.domain.dto.CarDto;
import com.gregory.parkingmeter.domain.service.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
@Tag(name = "Cars Controllers")
@RequestMapping(value = "/v1/car", produces = {"application/json"})
public class CarController {

    final CarService service;

    public ResponseEntity<CarDto> save(@RequestBody CarRequest request) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(service.save(request)).toUri();
        return ResponseEntity.created(uri).build();
    }
}
