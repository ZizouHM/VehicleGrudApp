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

import com.app.boot.model.Assembler;
import com.app.boot.services.AssemblerService;

import net.logstash.logback.marker.Markers;

@RestController
@RequestMapping("/assembler")
public class AssemblerController {

	@Autowired
	AssemblerService assemblerService;

	private static final String DELETE_MESSAGE_ASSEMBLER = "Delete the assembler";
	private static final String UPDATE_MESSAGE_ASSEMBLER = "Update the assembler";
	private static final String CREATE_MESSAGE_ASSEMBLER = "Add a new assembler";

	/**
	 * Logger
	 **/
	private static final Logger LOGGER = LoggerFactory.getLogger(AssemblerController.class);

	@ResponseBody
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Assembler>> getAllassembler() {
		List<Assembler> assemblers = assemblerService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(assemblers);
	}

	@ResponseBody
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Assembler> createAssembler(@RequestBody Assembler assembler) {
		logAssemblerInfo(assembler, CREATE_MESSAGE_ASSEMBLER);
		return ResponseEntity.ok(assemblerService.save(assembler));
	}

	@ResponseBody
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Assembler> updateAssembler(@PathVariable("id") Long id,
			@Valid @RequestBody Assembler assembler) {

		final Assembler updatedassembler;
		try {
			updatedassembler = this.assemblerService.update(assembler);
			logAssemblerInfo(updatedassembler, UPDATE_MESSAGE_ASSEMBLER);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(updatedassembler);
	}

	@ResponseBody
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Assembler> deleteAssembler(@PathVariable("id") Long id) {

		final Assembler deledtedAssembler;
		try {
			deledtedAssembler = assemblerService.deleteById(id);
			if (deledtedAssembler == null) {
				return ResponseEntity.notFound().build();
			}
			logAssemblerInfo(deledtedAssembler, DELETE_MESSAGE_ASSEMBLER);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(deledtedAssembler);

	}

	@ResponseBody
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Assembler> getAssemblerById(@PathVariable("id") Long id) {
		Assembler assembler = this.assemblerService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(assembler);

	}

	private void logAssemblerInfo(final Assembler assembler, final String message) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(Markers.append("app_assembler_id", assembler.getId())
					.and(Markers.append("app_assembler_CarMarker", assembler.getDescription())), message);
		}
	}
}
