package com.example.renACar.requests.citiesRequests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCityRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String cityName;

}
