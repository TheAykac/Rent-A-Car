package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.dtos.colorDtos.ColorListDto;
import com.example.renACar.requests.colorRequests.CreateColorRequest;

public interface ColorService {
	
	Result add (CreateColorRequest createColorRequest) throws BusinessException;
	
	DataResult<List<ColorListDto>> getAll() throws BusinessException;

}
