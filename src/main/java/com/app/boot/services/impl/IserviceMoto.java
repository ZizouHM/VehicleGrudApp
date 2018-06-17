package com.app.boot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.boot.exception.CodeOperationException;
import com.app.boot.model.Moto;
import com.app.boot.repository.MotoRepository;
import com.app.boot.services.MotoService;

@Service
@Transactional
public class IserviceMoto implements MotoService {

	@Autowired
	MotoRepository motoRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Moto save(Moto moto) {
		return motoRepository.save(moto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Moto update(Moto moto) {
		return motoRepository.saveAndFlush(moto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Moto moto) {
		motoRepository.delete(moto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Moto> findAll() {
		return motoRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Moto findById(Long id) {
		return motoRepository.getMotoById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Moto deleteById(Long id) {

		Moto deletedMoto = motoRepository.getMotoById(id);
		if (deletedMoto == null) {
			throw new CodeOperationException(CodeOperationException.CodeError.CODE_NOT_FOUND.name(), id.toString());
		}
		motoRepository.delete(deletedMoto);
		return deletedMoto;

	}

}
