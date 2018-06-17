package com.app.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.boot.model.Car;
import com.app.boot.model.Moto;
import com.app.boot.repository.CarRepository;
import com.app.boot.services.CarService;
import com.app.boot.services.MotoService;

import net.logstash.logback.marker.Markers;

/**
 * 
 * @author zaynab
 *
 */
@RestController
@RequestMapping("/")
public class VehicleController {

	@Autowired
	CarService iservcieCar;

	@Autowired
	CarRepository carrepository;

	@Autowired
	MotoService iserviceMoto;

	private static final String DELETE_MESSAGE_MOTO = "Delete the Moto";
	private static final String UPDATE_MESSAGE_MOTO = "Update the Moto";
	private static final String CREATE_MESSAGE_MOTO = "Add a new Moto";

	private static final String DELETE_MESSAGE_CAR = "Delete the Car";
	private static final String UPDATE_MESSAGE_CAR = "Update the Car";
	private static final String CREATE_MESSAGE_CAR = "Add a new Car";

	/**
	 * Logger
	 **/
	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

	@ResponseBody
	@GetMapping(value = "car/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Car>> getAllCar() {
		List<Car> cars = iservcieCar.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(cars);
	}

	@ResponseBody
	@PostMapping(value = "car/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		logCarInfo(car, CREATE_MESSAGE_CAR);
		return ResponseEntity.ok(iservcieCar.save(car));
	}

	@ResponseBody
	@PutMapping(value = "car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @Valid @RequestBody Car car) {

		final Car updatedcar;
		try {
			updatedcar = this.iservcieCar.update(car);
			logCarInfo(updatedcar, UPDATE_MESSAGE_CAR);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(updatedcar);
	}

	@ResponseBody
	@DeleteMapping(value = "car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Car> deleteCar(@PathVariable("id") Long id) {

		final Car deledtedCar;
		try {
			deledtedCar = iservcieCar.deleteById(id);
			if (deledtedCar == null) {
				return ResponseEntity.notFound().build();
			}
			logCarInfo(deledtedCar, DELETE_MESSAGE_CAR);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(deledtedCar);

	}

	// Moto Contorller

	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = "moto/")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Moto>> getAllMoto() {
		List<Moto> motos = this.iserviceMoto.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(motos);

	}

	@ResponseBody
	@GetMapping(value = "moto/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Moto> getMotoById(@PathVariable("id") Long id) {
		Moto moto = this.iserviceMoto.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(moto);

	}

	@ResponseBody
	@PostMapping(value = "moto/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Moto> createMoto(@RequestBody Moto moto) {
		logMotoInfo(moto, CREATE_MESSAGE_MOTO);
		return ResponseEntity.ok(iserviceMoto.save(moto));
	}

	@ResponseBody
	@PutMapping(value = "moto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Moto> updateMoto(@PathVariable("id") Long id, @Valid @RequestBody Moto moto) {

		final Moto updatedmoto;
		try {
			updatedmoto = iserviceMoto.update(moto);
			logMotoInfo(updatedmoto, UPDATE_MESSAGE_MOTO);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(updatedmoto);

	}

	@ResponseBody
	@DeleteMapping(value = "moto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Moto> deleteMoto(@PathVariable("id") Long id) {

		final Moto deledtedMoto;
		try {
			deledtedMoto = iserviceMoto.deleteById(id);
			if (deledtedMoto == null) {
				return ResponseEntity.notFound().build();
			}
			logMotoInfo(deledtedMoto, DELETE_MESSAGE_MOTO);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(deledtedMoto);

	}

	private void logMotoInfo(final Moto moto, final String message) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(Markers.append("app_moto_id", moto.getId())
					.and(Markers.append("app_moto_assembler", moto.getAssembler().getDescription()))
					.and(Markers.append("app_moto_model", moto.getModel().getDescription()))
					.and(Markers.append("app_moto_color", moto.getColor().getDescription()))
					.and(Markers.append("app_moto_mileage", moto.getMileage().getDescription()))
					.and(Markers.append("app_moto_motor", moto.getMotor().getDescription())), message);
		}
	}

	private void logCarInfo(final Car car, final String message) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(Markers.append("app_car_id", car.getId())
					.and(Markers.append("app_car_CarMarker", car.getCarMarker().getDescription()))
					.and(Markers.append("app_car_model", car.getModel().getDescription()))
					.and(Markers.append("app_car_color", car.getColor().getDescription()))
					.and(Markers.append("app_car_mileage", car.getMileage().getDescription()))
					.and(Markers.append("app_car_motor", car.getMotor().getDescription())), message);
		}
	}

}
