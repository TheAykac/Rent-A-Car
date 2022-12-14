package com.example.renACar.entities.dtos.carMaintenanceDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarMaintenanceDto {

    private String carMaintenanceDescription;
    private LocalDate returnDate;

    private int carCarId;
}
