package com.example.renACar.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.renACar.business.abstracts.BrandService;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.concretes.Brand;
import com.example.renACar.entities.dtos.brandDtos.BrandListDto;
import com.example.renACar.requests.brandRequests.CreateBrandRequest;
@RestController
@RequestMapping("/api/brand")
public class BrandControllers {
	private BrandService brandService;

	@Autowired
	public BrandControllers(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	
@PostMapping("/add")
public Result add(@RequestBody @Valid CreateBrandRequest createBrandRequest) throws BusinessException {
    return this.brandService.add(createBrandRequest);
}

@GetMapping("/getAll")
public DataResult<List<BrandListDto>> getAll() throws BusinessException{
	return this.brandService.getAll();
}

@DeleteMapping("/delete")
public Result delete(int id) throws BusinessException {
	return this.brandService.delete(id);
}

	

}
