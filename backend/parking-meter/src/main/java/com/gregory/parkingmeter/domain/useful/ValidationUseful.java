package com.gregory.parkingmeter.domain.useful;

import com.gregory.parkingmeter.app.exception.BadRequestException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class ValidationUseful {

    static final String BAD_REQUEST = "Error in the context of the request!";

    final Validator validator;

    public <T> void validateRequest(T request) {
        Set<ConstraintViolation<T>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new BadRequestException(BAD_REQUEST);
        }
    }
}
