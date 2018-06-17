package com.app.boot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.boot.exception.CodeOperationException;
import com.app.boot.model.Model;
import com.app.boot.repository.ModelRepository;
import com.app.boot.services.ModelService;

@Service
@Transactional
public class IserviceModel implements ModelService {

	@Autowired
	ModelRepository modelRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Model save(Model model) {
		return modelRepository.save(model);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Model update(Model model) {
		return modelRepository.saveAndFlush(model);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Model model) {
		modelRepository.delete(model);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Model deleteById(Long id) {
		Model deletedModel = modelRepository.getModelById(id);
		if (deletedModel == null) {
			throw new CodeOperationException(CodeOperationException.CodeError.CODE_NOT_FOUND.name(), id.toString());
		}
		modelRepository.delete(deletedModel);
		return deletedModel;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Model> findAll() {
		return modelRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Model findById(Long id) {
		return modelRepository.getModelById(id);
	}

}
