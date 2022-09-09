package com.example.renACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.renACar.entities.concretes.Additional;

public interface AdditionalDao extends JpaRepository<Additional, Integer>{

	boolean existsByAdditionalName(String additionalName);
    boolean existsByAdditionalId(int additionalId);
}
