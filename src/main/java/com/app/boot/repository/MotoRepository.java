package com.app.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.boot.model.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

	Moto getMotoById(Long id);

	@Query("FROM Moto m where m.model.description = :description")
	List<Moto> getMotoByModel(@Param("description") String description);

	@Query("FROM Moto m where m.motor.description = :description")
	List<Moto> getMotoByMotor(@Param("description") String description);

	@Query("FROM Moto m where m.assembler.description = :description")
	List<Moto> getMotoByAssembler(@Param("description") String description);

	@Query("FROM Moto m where m.mileage.description = :description")
	List<Moto> getMotoByMileage(@Param("description") String description);

	@Query("FROM Moto m where m.color.description = :description")
	List<Moto> getMotoByColor(@Param("description") String description);

}
