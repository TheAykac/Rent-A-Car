package com.example.renACar.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.renACar.business.abstracts.CarService;
import com.example.renACar.business.constants.messages.BusinessMessages;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.entities.concretes.Car;
import com.example.renACar.entities.dtos.carDtos.CarListDto;
import com.example.renACar.requests.carRequest.CreateCarRequest;


@RestController
@RequestMapping("/api/car")
public class CarControllers {

	private CarService carService;

	
@Autowired
	public CarControllers(CarService carService) {
		super();
		this.carService = carService;
	
	}

	
	
	
	@GetMapping("/getall")
	public DataResult<List<CarListDto>> getAll() throws BusinessException{
		
		
		
		return this.carService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCarRequest createCarRequest) throws BusinessException {
		return this.carService.add(createCarRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(int id)throws BusinessException {
		return this.carService.delete(id);
	}
	@GetMapping("getById")
	public DataResult<Car> getById(int id) {
		return this.carService.getById(id);
	}
	
	@GetMapping("/getByDailyPriceLessThanEqual")
	public DataResult<List<CarListDto>> getByDailyPriceLessThanEqual(double dailyPrice) throws BusinessException {
		return this.carService.getByDailyPriceLessThanEqual(dailyPrice);
		
		
	}
	
	@GetMapping("/getByDailyPriceSortBy")
	public DataResult<List<CarListDto>> getByDailyPriceSortBy(int i) throws BusinessException{
		return this.carService.getByDailyPriceSortBy(i);
	}
	
	
	
}
