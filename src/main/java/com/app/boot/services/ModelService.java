package com.app.boot.services;

import java.util.List;

import com.app.boot.model.Model;

public interface ModelService {

	public Model save(Model model);

	public Model update(Model model);

	public void delete(Model model);

	public Model deleteById(Long id);

	public List<Model> findAll();

	public Model findById(Long id);

}
