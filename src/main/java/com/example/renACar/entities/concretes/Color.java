package com.example.renACar.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Table(name = "colors")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cars" })
public class Color {

	@Id
	@GeneratedValue
	@Column(name = "color_id")
	private int id;

	@Column(name = "color_name")
	private String colorName;

	@OneToMany(mappedBy = "color", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Car> cars;

}
