package com.app.boot.services;

import java.util.List;

import com.app.boot.model.Moto;

public interface MotoService {

	public Moto save(Moto moto);

	public Moto update(Moto moto);

	public void delete(Moto moto);

	public Moto deleteById(Long id);

	public List<Moto> findAll();

	public Moto findById(Long id);

	public List<Moto> findmotoByModel(String description);

	public List<Moto> findmotoByMotor(String description);

	public List<Moto> findmotoByAssembler(String description);

	public List<Moto> findmotoByMileage(String description);

	public List<Moto> findmotoByColor(String description);
}
