package com.app.boot.services;

import java.util.List;

import com.app.boot.model.Assembler;

public interface AssemblerService {

	public Assembler save(Assembler assembler);

	public Assembler update(Assembler assembler);

	public void delete(Assembler assembler);

	public Assembler deleteById(Long id);

	public List<Assembler> findAll();

	public Assembler findById(Long id);

}
