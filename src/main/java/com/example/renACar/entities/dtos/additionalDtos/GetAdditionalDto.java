package com.example.renACar.entities.dtos.additionalDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAdditionalDto {

    private int additionalId;
    private String additionalName;
    private double additionalDailyPrice;
    private short maxUnitsPerRental;
}
