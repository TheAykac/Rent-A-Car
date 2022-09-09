package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.exceptions.additionalException.AdditionalAlreadyExistsException;
import com.example.renACar.core.utilities.exceptions.additionalException.AdditionalNotFoundException;
import com.example.renACar.core.utilities.exceptions.orderedAdditionalExceptions.AdditionalAlreadyExistsInOrderedAdditionalException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.dtos.additionalDtos.AdditionalListDto;
import com.example.renACar.entities.dtos.additionalDtos.GetAdditionalDto;
import com.example.renACar.requests.additionalRequest.CreateAdditionalRequest;
import com.example.renACar.requests.additionalRequest.DeleteAdditionalRequest;
import com.example.renACar.requests.additionalRequest.UpdateAdditionalRequest;

public interface AdditionalService {
	DataResult<List<AdditionalListDto>> getAll();

	Result add(CreateAdditionalRequest createAdditionalRequest) throws AdditionalAlreadyExistsException;

	Result update(UpdateAdditionalRequest updateAdditionalRequest)
			throws AdditionalAlreadyExistsException, AdditionalNotFoundException;

	Result delete(DeleteAdditionalRequest deleteAdditionalRequest)
			throws AdditionalNotFoundException, AdditionalAlreadyExistsInOrderedAdditionalException;

	DataResult<GetAdditionalDto> getByAdditionalId(int additionalId) throws AdditionalNotFoundException;

	void checkIfExistsByAdditionalId(int additionalId) throws AdditionalNotFoundException;

}
