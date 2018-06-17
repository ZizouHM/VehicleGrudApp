package com.app.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.boot.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

	Model getModelById(Long id);

}
