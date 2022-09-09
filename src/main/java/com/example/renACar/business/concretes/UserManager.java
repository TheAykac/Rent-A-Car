package com.example.renACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.renACar.business.abstracts.UserService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.core.utilities.result.SuccessDataResult;
import com.example.renACar.core.utilities.result.SuccessResult;
import com.example.renACar.dataAccess.abstracts.UserDao;
import com.example.renACar.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {

		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Veriler Listelendi");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Veriler Eklendi");
	}

	@Override
	public Result delete(User user) {
		this.userDao.deleteById(user.getId());
		return new SuccessResult("verilen başarıyla silindi");
	}

}
