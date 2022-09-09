package com.example.renACar.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.renACar.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer>{
	


}
