package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.concretes.Brand;
import com.example.renACar.entities.dtos.brandDtos.BrandListDto;
import com.example.renACar.requests.brandRequests.CreateBrandRequest;

public interface BrandService {
	
	
	
	Result add(CreateBrandRequest createBrandRequest) throws BusinessException;
	
	DataResult<List<BrandListDto>> getAll () throws BusinessException;
	
	Result delete(int id) throws BusinessException;

	
	
	
	
	
	

}
