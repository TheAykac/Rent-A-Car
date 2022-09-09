package com.example.renACar.business.concretes;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.renACar.business.abstracts.CustomerService;
import com.example.renACar.business.constants.messages.BusinessMessages;
import com.example.renACar.core.utilities.exceptions.BusinessException;
import com.example.renACar.core.utilities.exceptions.customerException.CustomerNotFoundException;
import com.example.renACar.core.utilities.mapping.ModelMapperService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.dataAccess.abstracts.CustomerDao;
import com.example.renACar.entities.concretes.Customer;
import com.example.renACar.entities.dtos.customerDtos.CustomerListDto;
import com.example.renACar.entities.dtos.getDtos.GetCustomerDto;
import com.example.renACar.requests.customerRequests.CreateCustomerRequest;
import com.example.renACar.requests.customerRequests.DeleteCustomerRequest;

@Service
public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CustomerManager(CustomerDao customerDao, ModelMapperService modelMapperService) {
		super();
		this.customerDao = customerDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<GetCustomerDto> getById(int customerId) throws CustomerNotFoundException {
		checkIfCustomerIdExists(customerId);

		Customer customer = this.customerDao.getById(customerId);

		GetCustomerDto result = this.modelMapperService.forDto().map(customer, GetCustomerDto.class);
		return new SuccessDataResult<>(result, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY + customerId);
	}

	@Override
	public void checkIfCustomerIdExists(int customerId) throws CustomerNotFoundException {
		if (!this.customerDao.existsById(customerId)) {
			throw new CustomerNotFoundException(BusinessMessages.CustomerMessages.CUSTOMER_ID_NOT_FOUND);
		}

	}

	@Override
	public Customer getCustomerById(int customerId) {

		return this.customerDao.getById(customerId);
	}

	@Override
	public Result add(CreateCustomerRequest createCustomerRequest) throws BusinessException {
		Customer customer = this.modelMapperService.forDto().map(createCustomerRequest, Customer.class);
		this.customerDao.save(customer);
		return new SuccessDataResult<>(customer, BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
	}

	@Override
	public DataResult<List<CustomerListDto>> getAll() throws BusinessException {
		List<Customer> customers = this.customerDao.findAll();
		List<CustomerListDto> customerListDtos = customers.stream()
				.map(customer -> this.modelMapperService.forDto().map(customer, CustomerListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<>(customerListDtos, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
	}

	@Override
	public Result delete(DeleteCustomerRequest deleteCustomerRequest) throws BusinessException {
		checkIfCustomerIdExists(deleteCustomerRequest.getId());
		this.customerDao.deleteById(deleteCustomerRequest.getId());
		return new SuccessResult(BusinessMessages.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
	}

}
