package com.example.renACar.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "Lazy" })
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int id;

	@Column(name = "car_daily_price")
	private double dailyPrice;

	@Column(name = "car_model_year")
	private int modelYear;

	@Column(name = "car_description")
	private String description;

	@Column(name = "car_kilometer_information")
	private double kilometerInformation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "color_id")
	private Color color;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Rental> rentals;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CarMaintenance> carMaintenances;

}
