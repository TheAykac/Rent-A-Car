package com.example.renACar.entities.dtos.carDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarListDto {

    private int carId;

    private double dailyPrice;
    private int modelYear;
    private String description;
    private double kilometerInformation;
    private String brandName;
    private String colorName;
    
}