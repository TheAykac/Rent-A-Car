package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.concretes.Rental;
import com.example.renACar.requests.rentalsRequests.CreateRentalRequest;

public interface RentalService {
	
	Result add(CreateRentalRequest createRentalRequest) throws BusinessException;
	
	DataResult<List<Rental>> getAll();
	
	Result delete (int id) throws BusinessException;
	
	
	
	

}
