package com.example.renACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.renACar.entities.concretes.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {


			
 boolean existsByBrandName(String brandName);
 
 Brand findById(int id);
		

 
 


}
