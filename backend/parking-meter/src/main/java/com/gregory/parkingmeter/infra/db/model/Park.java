package com.gregory.parkingmeter.infra.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_park")
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "license_plate", unique = true)
    @Size(max = 7)
    private String licensePlate;

    @Column(name = "park_value")
    private BigDecimal value;

}
