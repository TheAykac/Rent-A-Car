package com.example.renACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.renACar.business.abstracts.CarMaintenanceService;
import com.example.renACar.business.constants.messages.BusinessMessages;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.dataAccess.abstracts.CarMaintenanceDao;
import com.example.renACar.dataAccess.abstracts.RentalDao;
import com.example.renACar.entities.concretes.CarMaintenance;
import com.example.renACar.entities.dtos.carMaintenanceDtos.CarMaintenanceDto;
import com.example.renACar.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.example.renACar.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;

@Service
public class CarMaintenanceManager implements CarMaintenanceService {

	private CarMaintenanceDao carMaintenanceDao;
	private ModelMapperService modelMapperService;
	private RentalDao rentalDao;

	@Autowired
	public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService,
			RentalDao rentalDao) {
		super();
		this.carMaintenanceDao = carMaintenanceDao;
		this.modelMapperService = modelMapperService;
		this.rentalDao = rentalDao;
	}

	@Override
	public DataResult<List<CarMaintenanceDto>> getAll() throws BusinessException {
		List<CarMaintenance> carMaintenances = this.carMaintenanceDao.findAll();
		List<CarMaintenanceDto> carMaintenanceDtos = carMaintenances.stream()
				.map(carMaintenance -> modelMapperService.forDto().map(carMaintenance, CarMaintenanceDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<>(carMaintenanceDtos, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest) throws BusinessException {
		checkIfRentalExists(createCarMaintenanceRequest.getCarId());
		CarMaintenance carMaintenance = this.modelMapperService.forDto().map(createCarMaintenanceRequest,
				CarMaintenance.class);
		this.carMaintenanceDao.save(carMaintenance);
		return new SuccessResult(BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
	}

	@Override
	public Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) throws BusinessException {
		CarMaintenance carMaintenance = this.modelMapperService.forDto().map(deleteCarMaintenanceRequest,
				CarMaintenance.class);
		this.carMaintenanceDao.deleteById(deleteCarMaintenanceRequest.getId());
		return new SuccessResult(BusinessMessages.GlobalMessages.DATA_DELETED_SUCCESSFULLY);

	}

	private void checkIfRentalExists(int id) throws BusinessException {
		if (this.rentalDao.existsById(id)) {
			throw new BusinessException(BusinessMessages.CarMaintenanceMessages.CAR_ID_EXISTS_IN_RENTAL + id);
		}
	}
}
