package com.example.renACar.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cars" })

public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private int id;

	@Column(name = "brad_name")
	private String brandName;

	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Car> cars;
}
