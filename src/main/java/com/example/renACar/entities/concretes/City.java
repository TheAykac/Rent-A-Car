package com.example.renACar.entities.concretes;

import lombok.Data;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_name", unique = true, nullable = false)
	private String cityName;

	@OneToMany(mappedBy = "rentedCity")
	private List<Rental> rentedCarsFromCity;

	@OneToMany(mappedBy = "deliveredCity")
	private List<Rental> deliveredCarsToCity;
}
