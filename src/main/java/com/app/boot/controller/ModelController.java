package com.app.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.boot.model.Model;
import com.app.boot.services.ModelService;

import net.logstash.logback.marker.Markers;

@RestController
@RequestMapping("model/")
public class ModelController {

	@Autowired
	ModelService modelService;

	private static final String DELETE_MESSAGE_MODEL = "Delete the Model";
	private static final String UPDATE_MESSAGE_MODEL = "Update the Model";
	private static final String CREATE_MESSAGE_MODEL = "Add a new Model";

	/**
	 * Logger
	 **/
	private static final Logger LOGGER = LoggerFactory.getLogger(ModelController.class);

	@ResponseBody
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Model>> getAllModel() {
		List<Model> models = modelService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(models);
	}

	@ResponseBody
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Model> createModel(@RequestBody Model model) {
		logModelInfo(model, CREATE_MESSAGE_MODEL);
		return ResponseEntity.ok(modelService.save(model));
	}

	@ResponseBody
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Model> updateModel(@PathVariable("id") Long id, @Valid @RequestBody Model model) {

		final Model updatedmodel;
		try {
			updatedmodel = this.modelService.update(model);
			logModelInfo(updatedmodel, UPDATE_MESSAGE_MODEL);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(updatedmodel);
	}

	@ResponseBody
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Model> deleteModel(@PathVariable("id") Long id) {

		final Model deledtedModel;
		try {
			deledtedModel = modelService.deleteById(id);
			if (deledtedModel == null) {
				return ResponseEntity.notFound().build();
			}
			logModelInfo(deledtedModel, DELETE_MESSAGE_MODEL);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(deledtedModel);

	}

	@ResponseBody
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Model> getModelById(@PathVariable("id") Long id) {
		Model model = this.modelService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(model);

	}

	private void logModelInfo(final Model model, final String message) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(Markers.append("app_model_id", model.getId())
					.and(Markers.append("app_model_CarMarker", model.getDescription())), message);
		}
	}
}
