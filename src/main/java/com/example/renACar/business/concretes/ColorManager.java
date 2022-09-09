package com.example.renACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.renACar.business.abstracts.ColorService;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.dataAccess.abstracts.ColorDao;
import com.example.renACar.entities.concretes.Color;
import com.example.renACar.entities.dtos.colorDtos.ColorListDto;
import com.example.renACar.requests.colorRequests.CreateColorRequest;

@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		super();
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateColorRequest createColorRequest) throws BusinessException {

		Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		checkIfColorExists(color.getColorName());
		this.colorDao.save(color);
		return new SuccessDataResult(createColorRequest, "Data added : " + color.getColorName());
	}

	private void checkIfColorExists(String colorName) throws BusinessException {
		if (this.colorDao.existsByColorName(colorName)) {
			throw new BusinessException("This color is already exist in system : " + colorName);

		}
	}

	@Override
	public DataResult<List<ColorListDto>> getAll() throws BusinessException {

		List<Color> colors = this.colorDao.findAll();

		List<ColorListDto> colorListDtos = colors.stream()
				.map(color -> this.modelMapperService.forDto().map(color, ColorListDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<>(colorListDtos, "Data listed");
	}
}
