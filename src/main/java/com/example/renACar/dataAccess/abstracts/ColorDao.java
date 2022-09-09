package com.example.renACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.renACar.entities.concretes.Color;

public interface ColorDao extends JpaRepository<Color, Integer>{

	boolean existsByColorName (String name);
}
