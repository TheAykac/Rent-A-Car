package com.example.renACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.renACar.business.abstracts.CarMaintenanceService;
import com.example.renACar.business.constants.messages.BusinessMessages;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.entities.concretes.CarMaintenance;
import com.example.renACar.entities.dtos.carMaintenanceDtos.CarMaintenanceDto;
import com.example.renACar.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.example.renACar.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;
import com.example.renACar.requests.carRequest.CreateCarRequest;

@RestController
@RequestMapping("/api/carMaintenance")
public class CarMaintenanceControllers {
	
	private CarMaintenanceService carMaintenanceService;

	@Autowired
	public CarMaintenanceControllers(CarMaintenanceService carMaintenanceService) {
		super();
		this.carMaintenanceService = carMaintenanceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CarMaintenanceDto>> getAll() throws BusinessException{
		return this.carMaintenanceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCarMaintenanceRequest createCarMaintenanceRequest) throws BusinessException{
		return this.carMaintenanceService.add(createCarMaintenanceRequest);
	}
 
	@DeleteMapping("/delete")
	public Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) throws BusinessException {
		return this.carMaintenanceService.delete(deleteCarMaintenanceRequest);
		
	}
}
