package com.example.renACar.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedAdditionalListDto {

    private int orderedAdditionalId;
    private short orderedAdditionalQuantity;
    private int additionalId;
    private String additionalName;
    private int rentalCarId;

}
