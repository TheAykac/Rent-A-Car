package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.dtos.carMaintenanceDtos.CarMaintenanceDto;
import com.example.renACar.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.example.renACar.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;

public interface CarMaintenanceService {
	DataResult<List<CarMaintenanceDto>> getAll() throws BusinessException;
	
	Result add (CreateCarMaintenanceRequest createCarMaintenanceRequest) throws BusinessException;

	Result delete (DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) throws BusinessException;
}
