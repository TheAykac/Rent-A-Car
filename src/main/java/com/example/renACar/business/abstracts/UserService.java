package com.example.renACar.business.abstracts;

import java.util.List;

import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.concretes.User;

public interface UserService {
	

	DataResult<List<User>> getAll();
	
	Result add(User user);
	
	Result delete (User user);

	

	
}
