package com.app.boot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author zaynab
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param model
	 * @param color
	 * @param mileage
	 * @param motor
	 */
	public Vehicle(Long id, Model model, Color color, Mileage mileage, Motor motor) {
		super();
		this.id = id;
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.motor = motor;
	}

	/**
	 * Default Constructor
	 */
	public Vehicle() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "mileage_id")
	private Mileage mileage;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "moto_id")
	private Motor motor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Mileage getMileage() {
		return mileage;
	}

	public void setMileage(Mileage mileage) {
		this.mileage = mileage;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

}
