package com.example.renACar.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.renACar.entities.concretes.Car;



public interface CarDao extends JpaRepository<Car, Integer> {
	Car getById (int id);
	
	Car getByIdAndDailyPrice(int id, int dailyPrice );
	
	List<Car> getByIdOrDailyPrice(int id, int dailyPrice);

	List<Car> getByIdIn(List<Integer> cars);
	
	List<Car> getByDescriptionContains(String description);
	
	boolean existsById(int id);
	
	List<Car> getByDailyPriceLessThanEqual(double dailyPrice);
	
	List<Car> findByOrderByDailyPriceDesc();
	
	List<Car> findByOrderByDailyPriceAsc();
	
	
	
}
