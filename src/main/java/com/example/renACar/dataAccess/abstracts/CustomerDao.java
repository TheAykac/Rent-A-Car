package com.example.renACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.renACar.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
