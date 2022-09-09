package com.example.renACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.renACar.business.abstracts.RentalService;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.concretes.Rental;
import com.example.renACar.requests.rentalsRequests.CreateRentalRequest;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/rental")
public class RentalControllers {

	private RentalService rentalService;

@Autowired
	public RentalControllers(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}
	
@PostMapping("/add")
	public Result add(@RequestBody CreateRentalRequest createRentalRequest) throws BusinessException {
		
		return this.rentalService.add(createRentalRequest);
	}

@GetMapping("/getall")
public DataResult<List<Rental>> getAll(){
	
	return this.rentalService.getAll();
}

@DeleteMapping("/delete")
public Result delete (int id)throws BusinessException{
	return this.rentalService.delete(id);
}


	
}
