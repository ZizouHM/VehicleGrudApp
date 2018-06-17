package com.app.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.boot.model.Assembler;

public interface AssemblerRepository extends JpaRepository<Assembler, Long> {

	Assembler getAssemblerById(Long id);

}
