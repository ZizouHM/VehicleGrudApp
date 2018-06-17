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

	public List<Car> findcarByModel(String description);

	public List<Car> findcarByMotor(String description);

	public List<Car> findcarByMileage(String description);

	public List<Car> findcarByCarMarker(String description);

	public List<Car> findcarByColor(String description);
}
