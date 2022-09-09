package com.example.renACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.renACar.business.abstracts.CustomerService;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.exceptions.customerException.CustomerNotFoundException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.dtos.customerDtos.CustomerListDto;
import com.example.renACar.entities.dtos.getDtos.GetCustomerDto;
import com.example.renACar.requests.customerRequests.CreateCustomerRequest;
import com.example.renACar.requests.customerRequests.DeleteCustomerRequest;

@RestController
@RequestMapping("/api/customer")
public class CustomerControllers {

	private CustomerService customerService;
@Autowired
	public CustomerControllers(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	

@GetMapping("/getAll")
public DataResult<List<CustomerListDto>> getAll()throws BusinessException{
    return this.customerService.getAll();
}

@GetMapping("getById")
public DataResult<GetCustomerDto> getById(@RequestParam int customerId) throws CustomerNotFoundException {
    return this.customerService.getById(customerId);
}
@PostMapping("/add")
public Result add(@RequestBody CreateCustomerRequest createCustomerRequest) throws BusinessException{
	return this.customerService.add(createCustomerRequest);
}

@DeleteMapping("/delete")
public Result add(@RequestBody DeleteCustomerRequest deleteCustomerRequest) throws BusinessException{
	return this.customerService.delete(deleteCustomerRequest);
}
	
}
