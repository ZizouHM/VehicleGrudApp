package com.app.boot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author zaynab
 *
 */
@Entity
public class Assembler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;

	@OneToMany(mappedBy = "assembler", cascade = { CascadeType.REMOVE })
	List<Moto> motos;

	public Assembler() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Moto> getMotos() {
		return motos;
	}

	public void setMotos(List<Moto> motos) {
		this.motos = motos;
	}

}
