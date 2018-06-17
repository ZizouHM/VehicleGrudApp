package com.app.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.boot.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	Car getCarById(Long id);
}
