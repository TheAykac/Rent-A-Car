package com.example.renACar.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.renACar.business.abstracts.CityService;
import com.example.renACar.core.utilities.exceptions.cityExceptions.CityAlreadyExistsException;
import com.example.renACar.core.utilities.exceptions.cityExceptions.CityNotFoundException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.dtos.cityDtos.CityListDto;
import com.example.renACar.entities.dtos.cityDtos.GetCityDto;
import com.example.renACar.requests.citiesRequests.CreateCityRequest;
@RestController
@RequestMapping("/api/city")
public class CityControllers {
	private final CityService cityService;
  

@Autowired
    public CityControllers(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("/getAll")
    public DataResult<List<CityListDto>> getAll(){
        return this.cityService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCityRequest createCityRequest) throws CityAlreadyExistsException {
        return this.cityService.add(createCityRequest);
    }

    @GetMapping("getByCityId")
    public DataResult<GetCityDto> getByCityId(@RequestParam int cityId) throws CityNotFoundException {
        return this.cityService.getByCityId(cityId);
    }

}
