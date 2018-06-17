package com.app.boot.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author zaynab
 *
 */
@Entity
public class Moto extends Vehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Moto() {
		super();
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "assembler_id")
	private Assembler assembler;

	public Assembler getAssembler() {
		return assembler;
	}

	public void setAssembler(Assembler assembler) {
		this.assembler = assembler;
	}

}
