package com.app.boot.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car extends Vehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "carMarker_id", nullable = false)
	private CarMarker carMarker;

	public CarMarker getCarMarker() {
		return carMarker;
	}

	public void setCarMarker(CarMarker carMarker) {
		this.carMarker = carMarker;
	}

}
