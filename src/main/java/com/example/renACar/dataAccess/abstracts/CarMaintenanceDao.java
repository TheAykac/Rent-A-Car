package com.example.renACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.renACar.entities.concretes.CarMaintenance;

public interface CarMaintenanceDao extends JpaRepository<CarMaintenance, Integer>{

}
