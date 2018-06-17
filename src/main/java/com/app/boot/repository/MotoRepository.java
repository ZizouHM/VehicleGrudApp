package com.app.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.boot.model.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

	Moto getMotoById(Long id);

}
