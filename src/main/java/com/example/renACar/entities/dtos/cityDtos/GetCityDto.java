package com.example.renACar.entities.dtos.cityDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCityDto {

    private int cityId;
    private String cityName;

}
