package com.example.renACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.renACar.business.abstracts.CityService;
import com.example.renACar.business.constants.messages.BusinessMessages;
import com.example.renACar.core.utilities.exceptions.cityExceptions.CityAlreadyExistsException;
import com.example.renACar.core.utilities.exceptions.cityExceptions.CityNotFoundException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.dataAccess.abstracts.CityDao;
import com.example.renACar.entities.concretes.City;
import com.example.renACar.entities.dtos.cityDtos.CityListDto;
import com.example.renACar.entities.dtos.cityDtos.GetCityDto;
import com.example.renACar.requests.citiesRequests.CreateCityRequest;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
		super();
		this.cityDao = cityDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CityListDto>> getAll() {
		List<City> cities = this.cityDao.findAll();

		List<CityListDto> result = cities.stream()
				.map(city -> this.modelMapperService.forDto().map(city, CityListDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<>(result, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public Result add(CreateCityRequest createCityRequest) throws CityAlreadyExistsException {

		checkIsNotExistByCityName(createCityRequest.getCityName());

		City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);
		city.setCityId(0);

		this.cityDao.save(city);

		return new SuccessResult(BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
	}

	@Override
	public DataResult<GetCityDto> getByCityId(int cityId) throws CityNotFoundException {
		checkIfExistsByCityId(cityId);

		City city = this.cityDao.getById(cityId);

		GetCityDto result = this.modelMapperService.forDto().map(city, GetCityDto.class);

		return new SuccessDataResult<>(result, BusinessMessages.GlobalMessages.DATA_BROUGHT_SUCCESSFULLY + cityId);
	}

	@Override
	public void checkIfExistsByCityId(int cityId) throws CityNotFoundException {
		if (!this.cityDao.existsByCityId(cityId)) {
			throw new CityNotFoundException(BusinessMessages.CityMessages.CITY_ID_NOT_FOUND + cityId);
		}

	}

	private void checkIsNotExistByCityName(String cityName) throws CityAlreadyExistsException {
		if (this.cityDao.existsByCityName(cityName)) {
			throw new CityAlreadyExistsException(BusinessMessages.CityMessages.CITY_NAME_ALREADY_EXISTS + cityName);
		}

	}

}
