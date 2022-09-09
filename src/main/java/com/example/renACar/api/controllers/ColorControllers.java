package com.example.renACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.renACar.business.abstracts.ColorService;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.dtos.colorDtos.ColorListDto;
import com.example.renACar.requests.colorRequests.CreateColorRequest;

@RestController
@RequestMapping("/api/color")
public class ColorControllers {
	
	private ColorService colorService;

	@Autowired
	public ColorControllers(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateColorRequest createColorRequest) throws BusinessException{
		return this.colorService.add(createColorRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ColorListDto>> getAll() throws BusinessException {
		return this.colorService.getAll();
	}

	
}
