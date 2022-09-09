package com.example.renACar.business.concretes;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.renACar.business.abstracts.BrandService;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.ErrorResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.dataAccess.abstracts.BrandDao;
import com.example.renACar.dataAccess.abstracts.CarDao;
import com.example.renACar.entities.concretes.Brand;
import com.example.renACar.entities.dtos.brandDtos.BrandDto;
import com.example.renACar.entities.dtos.brandDtos.BrandListDto;
import com.example.renACar.requests.brandRequests.CreateBrandRequest;

@Service
public class BrandManager implements BrandService {

	private BrandDao brandDao;
	private CarDao carDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public BrandManager(BrandDao brandDao, CarDao carDao, ModelMapperService modelMapperService) {
		super();
		this.brandDao = brandDao;
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateBrandRequest createBrandRequest) throws BusinessException {

		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		checkIfNameNotDuplicated(brand.getBrandName());

		this.brandDao.save(brand);

		return new SuccessDataResult(createBrandRequest, "Data added : " + brand.getBrandName());
	}

	@Override
	public DataResult<List<BrandListDto>> getAll() throws BusinessException {

		List<Brand> brands = this.brandDao.findAll();

		List<BrandListDto> brandListDtos = brands.stream()
				.map(brand -> this.modelMapperService.forDto().map(brand, BrandListDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<>(brandListDtos, "Data listed Successfully: ");
	}

	@Override
	public Result delete(int id) throws BusinessException {
		checkIfBrandExists(id);
		checkIfCarExists(id);

		BrandDto brandDto = this.modelMapperService.forDto().map(this.brandDao.getById(id), BrandDto.class);
		this.brandDao.deleteById(id);

		return new SuccessResult("Data Deleted : " + id);
	}

	private void checkIfBrandExists(int id) throws BusinessException {

		if (!this.brandDao.existsById(id)) {
			throw new BusinessException("There is no brand with following id : " + id);
		}
	}

	private void checkIfCarExists(int id) throws BusinessException {

		if (this.carDao.existsById(id))
			;
		throw new BusinessException("There is a car from this brand :" + id);
	}

	private void checkIfNameNotDuplicated(String branName) throws BusinessException {

		if (this.brandDao.existsByBrandName(branName)) {
			throw new BusinessException("This brand is already exist in system: " + branName);
		}
	}

}
