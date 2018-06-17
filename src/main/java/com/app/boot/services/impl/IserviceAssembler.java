package com.app.boot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.boot.exception.CodeOperationException;
import com.app.boot.model.Assembler;
import com.app.boot.repository.AssemblerRepository;
import com.app.boot.services.AssemblerService;

@Service
@Transactional
public class IserviceAssembler implements AssemblerService {

	@Autowired
	AssemblerRepository assemblerRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Assembler save(Assembler assembler) {
		return assemblerRepository.save(assembler);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Assembler update(Assembler assembler) {
		return assemblerRepository.saveAndFlush(assembler);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Assembler assembler) {
		assemblerRepository.delete(assembler);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Assembler deleteById(Long id) {
		Assembler deletedAssembler = assemblerRepository.getAssemblerById(id);
		if (deletedAssembler == null) {
			throw new CodeOperationException(CodeOperationException.CodeError.CODE_NOT_FOUND.name(), id.toString());
		}
		assemblerRepository.delete(deletedAssembler);
		return deletedAssembler;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Assembler> findAll() {
		return assemblerRepository.findAll();

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Assembler findById(Long id) {
		return assemblerRepository.getAssemblerById(id);
	}

}
