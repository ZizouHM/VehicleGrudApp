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
}
