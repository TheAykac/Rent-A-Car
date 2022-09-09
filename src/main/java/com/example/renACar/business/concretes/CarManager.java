package com.example.renACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.renACar.business.abstracts.CarService;
import com.example.renACar.business.constants.messages.BusinessMessages;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.ErrorResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.dataAccess.abstracts.BrandDao;
import com.example.renACar.dataAccess.abstracts.CarDao;
import com.example.renACar.dataAccess.abstracts.ColorDao;
import com.example.renACar.entities.concretes.Brand;
import com.example.renACar.entities.concretes.Car;
import com.example.renACar.entities.dtos.carDtos.CarListDto;
import com.example.renACar.requests.carRequest.CreateCarRequest;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;
	private BrandDao brandDao;
	private ColorDao colorDao;

	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService, BrandDao brandDao, ColorDao colorDao) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
		this.brandDao = brandDao;
		this.colorDao = colorDao;
	}

	@Override
	public DataResult<List<CarListDto>> getAll() throws BusinessException {

		List<Car> cars = this.carDao.findAll();

		List<CarListDto> carListDtos = cars.stream().map(car -> modelMapperService.forDto().map(car, CarListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<>(carListDtos, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public Result add(CreateCarRequest createCarRequest) throws BusinessException {

		Car car = this.modelMapperService.forDto().map(createCarRequest, Car.class);
		checkIfBrandIdExists(createCarRequest.getBrandId());
		checkIfColorIdExists(createCarRequest.getColorId());
		this.carDao.save(car);
		return new SuccessResult("Data Aded : ");
	}

	@Override
	public DataResult<Car> getById(@RequestParam int id) {
		return new SuccessDataResult<Car>(this.carDao.getById(id),
				BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public DataResult<Car> getByIdAndDailyPrice(int id, int dailyPrice) {

		return new SuccessDataResult<Car>(this.carDao.getByIdAndDailyPrice(id, dailyPrice),
				BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public DataResult<List<Car>> getByIdOrDailyPrice(int id, int dailyPrice) {

		return new SuccessDataResult<List<Car>>(this.carDao.getByIdOrDailyPrice(id, dailyPrice),
				BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public DataResult<List<Car>> getByIdIn(List<Integer> cars) {

		return new SuccessDataResult<List<Car>>(this.carDao.getByIdIn(cars),
				BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public DataResult<List<Car>> getByDescriptionContains(String description) {

		return new SuccessDataResult<List<Car>>(this.carDao.getByDescriptionContains(description),
				BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public Result delete(int id) throws BusinessException {
		checkIfIdExists(id);
		this.carDao.deleteById(id);
		return new SuccessResult("Data Deleted : " + id);
	}

	@Override
	public DataResult<List<CarListDto>> getByDailyPriceLessThanEqual(double dailyPrice) throws BusinessException {
		List<Car> cars = this.carDao.getByDailyPriceLessThanEqual(dailyPrice);

		List<CarListDto> carListDtos = cars.stream().map(car -> modelMapperService.forDto().map(car, CarListDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<>(carListDtos, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);

	}

	@Override
	public DataResult<List<CarListDto>> getByDailyPriceSortBy(int i) throws BusinessException {
		checkEnteredNumber(i);

		if (i == 1) {
			List<Car> cars = this.carDao.findByOrderByDailyPriceDesc();
			List<CarListDto> carListDtos = cars.stream()
					.map(car -> modelMapperService.forDto().map(car, CarListDto.class)).collect(Collectors.toList());
			return new SuccessDataResult<>(carListDtos, BusinessMessages.CarMessages.ALL_CARS_SORTED);
		} else {
			List<Car> cars = this.carDao.findByOrderByDailyPriceAsc();
			List<CarListDto> carListDtos = cars.stream()
					.map(car -> modelMapperService.forDto().map(car, CarListDto.class)).collect(Collectors.toList());
			return new SuccessDataResult<>(carListDtos, BusinessMessages.CarMessages.ALL_CARS_SORTED);
		}

	}

	/* Control Commands */

	private void checkEnteredNumber(int i) throws BusinessException {
		if (!(i == 1 || i == 2)) {
			throw new BusinessException(BusinessMessages.CarMessages.CAR_LISTED_NUMBER_FALSE);
		}
	}

	private void checkIfBrandIdExists(int id) throws BusinessException {
		if (!this.brandDao.existsById(id)) {
			throw new BusinessException(BusinessMessages.BrandMessages.BRAND_ID_NOT_FOUND + id);
		}
	}

	private void checkIfColorIdExists(int id) throws BusinessException {
		if (!this.colorDao.existsById(id)) {
			throw new BusinessException(BusinessMessages.ColorMessages.COLOR_ID_NOT_FOUND + id);
		}
	}

	private void checkIfIdExists(int id) throws BusinessException {
		if (!this.carDao.existsById(id)) {
			throw new BusinessException("There is no car with following id: " + id);
		}
	}

}
