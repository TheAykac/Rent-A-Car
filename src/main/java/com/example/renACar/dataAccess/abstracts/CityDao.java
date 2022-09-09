package com.example.renACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.renACar.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	boolean existsByCityId(int cityId);
    boolean existsByCityName(String name);
}
