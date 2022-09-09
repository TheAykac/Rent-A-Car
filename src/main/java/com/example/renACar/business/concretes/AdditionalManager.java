package com.example.renACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.renACar.business.abstracts.AdditionalService;
import com.example.renACar.core.utilities.exceptions.additionalException.AdditionalAlreadyExistsException;
import com.example.renACar.core.utilities.exceptions.additionalException.AdditionalNotFoundException;
import com.example.renACar.core.utilities.exceptions.orderedAdditionalExceptions.AdditionalAlreadyExistsInOrderedAdditionalException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.dataAccess.abstracts.AdditionalDao;
import com.example.renACar.entities.dtos.additionalDtos.AdditionalListDto;
import com.example.renACar.entities.dtos.additionalDtos.GetAdditionalDto;
import com.example.renACar.requests.additionalRequest.CreateAdditionalRequest;
import com.example.renACar.requests.additionalRequest.DeleteAdditionalRequest;
import com.example.renACar.requests.additionalRequest.UpdateAdditionalRequest;

@Service
public class AdditionalManager implements AdditionalService {

	private AdditionalDao additionalDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public AdditionalManager(AdditionalDao additionalDao, ModelMapperService modelMapperService) {
		super();
		this.additionalDao = additionalDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<AdditionalListDto>> getAll() {
		this.additionalDao.findAll();

		return null;
	}

	@Override
	public Result add(CreateAdditionalRequest createAdditionalRequest) throws AdditionalAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(UpdateAdditionalRequest updateAdditionalRequest)
			throws AdditionalAlreadyExistsException, AdditionalNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(DeleteAdditionalRequest deleteAdditionalRequest)
			throws AdditionalNotFoundException, AdditionalAlreadyExistsInOrderedAdditionalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<GetAdditionalDto> getByAdditionalId(int additionalId) throws AdditionalNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkIfExistsByAdditionalId(int additionalId) throws AdditionalNotFoundException {
		// TODO Auto-generated method stub

	}

}
