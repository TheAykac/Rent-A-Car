package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.dtos.cityDtos.CityListDto;
import com.example.renACar.entities.dtos.cityDtos.GetCityDto;
import com.example.renACar.requests.citiesRequests.CreateCityRequest;
import com.example.renACar.core.utilities.exceptions.cityExceptions.CityAlreadyExistsException;
import com.example.renACar.core.utilities.exceptions.cityExceptions.CityNotFoundException;

public interface CityService {
	
	DataResult<List<CityListDto>> getAll();
	
	Result add (CreateCityRequest cityRequest) throws CityAlreadyExistsException;
	
	DataResult<GetCityDto> getByCityId(int cityId) throws CityNotFoundException;

	void checkIfExistsByCityId(int cityId) throws CityNotFoundException;
}
