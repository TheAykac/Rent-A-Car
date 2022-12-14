package com.example.renACar.entities.dtos.additionalDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalListDto {

    private int additionalId;
    private String additionalName;
    private double additionalDailyPrice;

}
