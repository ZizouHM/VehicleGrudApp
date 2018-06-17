package com.app.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.boot.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	Car getCarById(Long id);

	@Query("FROM Car c where c.model.description = :description")
	List<Car> getCarByModel(@Param("description") String description);

	@Query("FROM Car c where c.motor.description = :description")
	List<Car> getCarByMotor(@Param("description") String description);

	@Query("FROM Car c where c.carMarker.description = :description")
	List<Car> getCarByCarMarker(@Param("description") String description);

	@Query("FROM Car c where c.mileage.description = :description")
	List<Car> getCarByMileage(@Param("description") String description);

	@Query("FROM Car c where c.color.description = :description")
	List<Car> getCarByColor(@Param("description") String description);
}
