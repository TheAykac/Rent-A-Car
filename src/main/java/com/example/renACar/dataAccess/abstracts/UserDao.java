package com.example.renACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.renACar.entities.concretes.User;

public interface UserDao  extends JpaRepository<User, Integer>{

}
