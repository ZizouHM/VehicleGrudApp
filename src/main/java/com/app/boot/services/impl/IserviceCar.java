package com.app.boot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.boot.exception.CodeOperationException;
import com.app.boot.model.Car;
import com.app.boot.repository.CarRepository;
import com.app.boot.services.CarService;

@Service
@Transactional
public class IserviceCar implements CarService {

	@Autowired
	CarRepository carrepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Car save(Car car) {
		return carrepository.save(car);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Car update(Car car) {
		return carrepository.saveAndFlush(car);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Car car) {
		carrepository.delete(car);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Car> findAll() {
		return carrepository.findAll();
	}

	@Override
	public Car findById(Long id) {
		return carrepository.getCarById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Car deleteById(Long id) {

		Car deletedCar = carrepository.getCarById(id);
		if (deletedCar == null) {
			throw new CodeOperationException(CodeOperationException.CodeError.CODE_NOT_FOUND.name(), id.toString());
		}
		carrepository.delete(deletedCar);
		return deletedCar;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Car> findcarByModel(String description) {
		return carrepository.getCarByModel(description);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Car> findcarByMotor(String description) {
		return carrepository.getCarByMotor(description);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Car> findcarByCarMarker(String description) {
		return carrepository.getCarByCarMarker(description);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Car> findcarByMileage(String description) {
		return carrepository.getCarByMileage(description);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Car> findcarByColor(String description) {
		return carrepository.getCarByColor(description);
	}
}
