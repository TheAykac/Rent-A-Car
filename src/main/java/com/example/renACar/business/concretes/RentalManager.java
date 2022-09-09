package com.example.renACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.renACar.business.abstracts.RentalService;
import com.example.renACar.business.constants.messages.BusinessMessages;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.dataAccess.abstracts.RentalDao;
import com.example.renACar.entities.concretes.CarMaintenance;
import com.example.renACar.entities.concretes.Rental;
import com.example.renACar.requests.rentalsRequests.CreateRentalRequest;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService) {
		super();
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) throws BusinessException {
		Rental rental = this.modelMapperService.forDto().map(createRentalRequest, Rental.class);
		this.rentalDao.save(rental);
		return new SuccessDataResult<>(rental,BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);

	}

	@Override
	public DataResult<List<Rental>> getAll() {

		return new SuccessDataResult<List<Rental>>(this.rentalDao.findAll(), "Veriler Listelendi");
	}

	@Override
	public Result delete(int id) throws BusinessException {
		checkIfRentalExists(id);

		this.rentalDao.deleteById(id);

		return null;
	}

	private void checkIfRentalExists(int id) throws BusinessException {
		if (!this.rentalDao.existsById(id)) {
			throw new BusinessException("There is no rental with following id :" + id);
		}

	}

}
