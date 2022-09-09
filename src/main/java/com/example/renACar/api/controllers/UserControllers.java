package com.example.renACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.renACar.business.abstracts.UserService;
import com.example.renACar.core.utilities.result.DataResult;
import com.example.renACar.core.utilities.result.Result;
import com.example.renACar.entities.concretes.User;

@RestController
@RequestMapping("/api/user")
public class UserControllers {
	
	private UserService userService;

	@Autowired
	public UserControllers(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(User user) {
		
		return this.userService.add(user);
	}
	
	@DeleteMapping("/delete")
	public Result delete(User user) {
		return this.userService.delete(user);
	}
	
	

}
