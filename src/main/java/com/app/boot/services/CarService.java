package com.app.boot.services;

import java.util.List;

import com.app.boot.model.Car;

public interface CarService {

	public Car save(Car car);

	public Car update(Car car);

	public void delete(Car car);

	public Car deleteById(Long id);

	public List<Car> findAll();

	public Car findById(Long id);

}
