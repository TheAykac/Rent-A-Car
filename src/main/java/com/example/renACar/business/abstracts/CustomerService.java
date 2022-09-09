package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.exceptions.customerException.CustomerNotFoundException;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.concretes.Customer;
import com.example.renACar.entities.dtos.customerDtos.CustomerListDto;
import com.example.renACar.entities.dtos.getDtos.GetCustomerDto;
import com.example.renACar.requests.customerRequests.CreateCustomerRequest;
import com.example.renACar.requests.customerRequests.DeleteCustomerRequest;

public interface CustomerService {
	 
	DataResult<List<CustomerListDto>> getAll()throws BusinessException;
	
	DataResult<GetCustomerDto> getById (int customerId) throws CustomerNotFoundException;
	
	void checkIfCustomerIdExists (int customerId) throws CustomerNotFoundException;
	
	Customer getCustomerById(int customerId);
	
	Result add(CreateCustomerRequest createCustomerRequest)throws BusinessException;
	
	Result delete(DeleteCustomerRequest deleteCustomerRequest)throws BusinessException;
	
	
}
