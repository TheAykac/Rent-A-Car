package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.concretes.Car;
import com.example.renACar.entities.dtos.carDtos.CarListDto;
import com.example.renACar.requests.carRequest.CreateCarRequest;



public interface CarService {
	
	DataResult<List<CarListDto>> getAll() throws BusinessException;
	
	Result add(CreateCarRequest carRequest)throws BusinessException;
	
	Result delete (int id) throws BusinessException;
	
	DataResult<Car> getById (int id);
	
	DataResult<Car> getByIdAndDailyPrice(int id, int dailyPrice );
	
	DataResult<List<Car>> getByIdOrDailyPrice(int id, int dailyPrice);

	DataResult<List<Car>> getByIdIn(List<Integer> cars);
	
	DataResult<List<Car>> getByDescriptionContains(String description);
	
	DataResult<List<CarListDto>> getByDailyPriceLessThanEqual(double dailyPrice) throws BusinessException;
	
	DataResult<List<CarListDto>> getByDailyPriceSortBy(int i) throws BusinessException;
	
	
	
	
	

 	
	
	
	

}
