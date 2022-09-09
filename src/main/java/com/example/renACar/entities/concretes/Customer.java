package com.example.renACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "customers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "Lazy" })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "customer_name")
	private String customerName;

	@OneToMany(mappedBy = "customer")
	private List<Rental> rentals;

}
