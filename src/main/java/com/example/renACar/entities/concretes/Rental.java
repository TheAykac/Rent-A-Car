package com.example.renACar.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentals")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "Lazy" })
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private int id;

	@Column(name = "rent_date", nullable = false)
	private LocalDate rentDate;

	@Column(name = "return_date", nullable = false)
	private LocalDate returnDate;

	@Column(name = "rented_kilometer")
	private Integer rentedKilometer;

	@Column(name = "delivered_kilometer")
	private Integer deliveredKilometer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Car car;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne()
	@JoinColumn(name = "rented_city", nullable = false)
	private City rentedCity;

	@ManyToOne()
	@JoinColumn(name = "delivered_city", nullable = false)
	private City deliveredCity;

}
